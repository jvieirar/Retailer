package com.grawar.retailer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grawar.retailer.constant.ConstantParams;
import com.grawar.retailer.entity.Retailer;
import com.grawar.retailer.repository.RetailerJPARepository;
import com.grawar.retailer.service.RetailerService;

@Service("RetailerServiceImpl")
public class RetailerServiceImpl implements RetailerService{

	@Autowired
	@Qualifier("RetailerJPARepository")
	private RetailerJPARepository retailerRepository;
	
	@Override
	public Retailer getRetailer() {
		return getRetailer(1);
	}
	
	@Override
	public Retailer getRetailer(int id) {
		return retailerRepository.findById(id);
	}

	@Override
	public int incrementBarcode(int inc) {
		return incrementBarcode(ConstantParams.DEFAULT_RETAILER_ID, inc);
	}

	@Override
	public int incrementBarcode(int id, int inc) {
		Retailer retailer = getRetailer(id);
		if(retailer == null) {
			return 0;
		}
		retailer.setBarcode(retailer.getBarcode() + inc);
		retailerRepository.save(retailer);
		return 1;
	}

}
