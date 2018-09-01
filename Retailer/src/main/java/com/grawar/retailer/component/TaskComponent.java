package com.grawar.retailer.component;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grawar.retailer.constant.ConstantParams;
import com.grawar.retailer.model.IncRequestModel;
import com.grawar.retailer.model.RetailerModel;

/**
 * Class TaskComponent.
 * Sends an increment of the barcodes, reads the number of barcodes and shows them.
 */
@Component("taskComponent")
public class TaskComponent {
	
	private static final Log LOG = LogFactory.getLog(TaskComponent.class);
	
	/**
	 * incrementBarcodes
	 * Increments the barcodes and shows them
	 */
	@Scheduled(fixedDelay = ConstantParams.DEFAULT_TASK_DELAY, initialDelay = ConstantParams.DEFAULT_TASK_INI_DELAY)
	public void incrementBarcodes() {
		ObjectMapper mapper = new ObjectMapper();
		//Create the model object we use in the request
		IncRequestModel incRequestModel = new IncRequestModel(ConstantParams.TASK_INCREMENT);
		try {
			//1-increment the barcode in 2
			URL url = new URL(ConstantParams.SERVER_URL + ConstantParams.INCREMENT_BARCODE_PATH);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoOutput(true);
			//specify it's in JSON
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			//send the POST request with the JSON object in the body
			out.write(mapper.writeValueAsString(incRequestModel));
			out.close();
			//check if we have OK response
			if (connection.getResponseCode() == HttpStatus.OK.value()) {
				IncRequestModel response = mapper.readValue(connection.getInputStream(), IncRequestModel.class);
				//we check that the increment we sent is the increment the server processed
				if(incRequestModel.equals(response)) {
					System.out.println("1-Barcode incremented in " + response.getInc());
					//2-get the barcodes
					url = new URL(ConstantParams.SERVER_URL + ConstantParams.GET_BARCODE_PATH);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestProperty("Content-Type", "application/json");
					connection.setConnectTimeout(5000);
					connection.setReadTimeout(5000);
					if (connection.getResponseCode() == HttpStatus.OK.value()) {
						//we could send the parameter id in the outputdata
						RetailerModel retailerResponse = mapper.readValue(connection.getInputStream(),
								RetailerModel.class);
						System.out.println("2-The number of barcodes is " + retailerResponse.getBarcode());
					}else {
						LOG.error("GET Barcode: The server couldn't find the Retailer in the database");
					}
				}else {
					LOG.error(String.format("The increment sent (%s) is not the same than the increment received (%s)", 
							incRequestModel, response));
				}
			}else {
				LOG.error("POST Increment: The server couldn't find the Retailer in the database");
			}
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			LOG.error("Error during the HTTP communication");
			e.printStackTrace();
		} 
	}
}
