package com.grawar.retailer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grawar.retailer.model.IncRequestModel;
import com.grawar.retailer.model.RetailerModel;
import com.grawar.retailer.service.RetailerService;

@RestController
public class RetailerController {
	private final static Log LOG = LogFactory.getLog(RetailerController.class);
	
	@Autowired
	@Qualifier("RetailerServiceImpl")
	private RetailerService retailerService;
	
	@RequestMapping(name="/api/retailer/barcode")
    public RetailerModel getBarcodes(@RequestParam(value="id", defaultValue="1") int id) {
		LOG.info("receiving petition");
		RetailerModel retailer = new RetailerModel(retailerService.getRetailer(id).getBarcode());
        return retailer;
    }
	
	@RequestMapping(name="/api/retailer/inc", method=RequestMethod.POST)
    public ResponseEntity<IncRequestModel> incrementBarcode(@RequestBody IncRequestModel inc) {
		LOG.info("receiving petition post" +  inc.toString());
		LOG.info("we want to increment the barcode in " +  inc.getInc());
		retailerService.incrementBarcode(inc.getInc());
		return new ResponseEntity<IncRequestModel>(inc, HttpStatus.OK);
    }
	
//	@RequestMapping(name="/api/retailer/inc", method=RequestMethod.POST)
//    public String incrementBarcode(HttpEntity<String> httpEntity) {
//		LOG.info("receiving petition post");
//		String json = httpEntity.getBody();
//		return json;
//    }
	
//	@RequestMapping(name="/api/retailer/inc", method=RequestMethod.POST)
//    public String incrementBarcode(@RequestParam(value="inc", defaultValue="1") int inc,
//    		HttpEntity<String> httpEntity) {
//		LOG.info("receiving petition post");
//		String json = httpEntity.getBody();
////        return new RetailerModel(inc);
//		return json;
//    }
	
}
