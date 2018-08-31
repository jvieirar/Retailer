package com.grawar.retailer.service.impl;
import com.grawar.retailer.constant.ConstantNames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grawar.retailer.constant.ConstantParams;
import com.grawar.retailer.converter.RetailerConverter;
import com.grawar.retailer.entity.Retailer;
import com.grawar.retailer.exception.RetailerNotFoundException;
import com.grawar.retailer.model.RetailerModel;
import com.grawar.retailer.repository.RetailerJPARepository;
import com.grawar.retailer.service.RetailerService;

/**
 * The Class RetailerServiceImpl.
 * Service to interact with the database
 */
@Service(ConstantNames.RETAILER_SERVICE_IMPL)
public class RetailerServiceImpl implements RetailerService{

	/** The retailer repository. */
	@Autowired
	@Qualifier(ConstantNames.RETAILER_JPA_REPOSITORY)
	private RetailerJPARepository retailerRepository;
	

	/** The retailer converter. */
	@Autowired
	@Qualifier(ConstantNames.RETAILER_CONVERTER)
	private RetailerConverter retailerConverter;
	

	@Override
	public RetailerModel getRetailer() throws RetailerNotFoundException {
		return getRetailer(ConstantParams.DEFAULT_RETAILER_ID);
	}
	
	@Override
	public RetailerModel getRetailer(int id) throws RetailerNotFoundException{
		Retailer retailer = retailerRepository.findById(id);
		if(retailer != null) {
			return retailerConverter.entity2Model(retailer);
		}else {
			throw new RetailerNotFoundException();
		}
	}

	@Override
	public int incrementBarcode(int inc) throws RetailerNotFoundException{
		return incrementBarcode(ConstantParams.DEFAULT_RETAILER_ID, inc);
	}

	@Override
	public int incrementBarcode(int id, int inc) throws RetailerNotFoundException{
		Retailer retailer = retailerRepository.findById(id);
		if(retailer != null) {
			retailer.setBarcode(retailer.getBarcode() + inc);
			retailerRepository.save(retailer);
			return inc;
		}else {
			throw new RetailerNotFoundException();
		}
	}

	@Override
	public Retailer addRetailer(RetailerModel retailerModel) {
		return retailerRepository.save(retailerConverter.model2Entity(retailerModel));
	}

}
