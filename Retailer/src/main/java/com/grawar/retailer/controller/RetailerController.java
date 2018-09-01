package com.grawar.retailer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grawar.retailer.constant.ConstantNames;
import com.grawar.retailer.constant.ConstantParams;
import com.grawar.retailer.exception.RetailerNotFoundException;
import com.grawar.retailer.model.IncRequestModel;
import com.grawar.retailer.model.RetailerModel;
import com.grawar.retailer.service.RetailerService;
/**
 * Class RetailerController.
 * Controls the increment of barcodes and shows them using JSON.
 */
@RestController
public class RetailerController {
	private final static Log LOG = LogFactory.getLog(RetailerController.class);
	
	/** Retailer service. */
	@Autowired
	@Qualifier(ConstantNames.RETAILER_SERVICE_IMPL)
	private RetailerService retailerService;
	
	/**
	 * Shows the barcodes of the Retailer(id).
	 * As default, it shows the Retailer(1).
	 * Use the param ?id=n to specify the Retailer id.
	 *
	 * @param id the Retailer id
	 * @return the barcode or RetailerNotFoundException and 404 if not OK
	 */
	@RequestMapping(name=ConstantParams.GET_BARCODE_PATH)
    public ResponseEntity<RetailerModel> getBarcodes(@RequestParam(value="id", defaultValue="1") int id) 
		throws RetailerNotFoundException{
		RetailerModel retailer;
		try {
			retailer = retailerService.getRetailer(id);
			LOG.info("GET Request. Method: 'getBarcodes'. Returning barcode " + retailer.getBarcode());
			return new ResponseEntity<RetailerModel>(retailer, HttpStatus.OK);
		} catch (RetailerNotFoundException e) {
			LOG.error("GET Request. Method: 'getBarcodes'. Retailer not found");
			throw e;
		}
    }
	
	/**
	 * Increments barcode.
	 *
	 * @param JSON incReqModel. Only has attribute 'inc'.
	 * {inc:n}
	 * @return echo of the JSON incReqModel if result OK. RetailerNotFoundException and 404 if not OK.
	 */
	@RequestMapping(name=ConstantParams.INCREMENT_BARCODE_PATH, method=RequestMethod.POST)
    public ResponseEntity<IncRequestModel> incrementBarcode(@RequestBody IncRequestModel incReqModel) 
		throws RetailerNotFoundException{
		try {
			LOG.info("POST Request. Method: 'incrementBarcode'. Increment " + incReqModel);
			retailerService.incrementBarcode(incReqModel.getInc());
			return new ResponseEntity<IncRequestModel>(incReqModel, HttpStatus.OK);
		} catch (RetailerNotFoundException e) {
			LOG.error("POST Request. Method: 'incrementBarcode'. Retailer not found");
			throw e;
		}
    }	
}
