package com.grawar.retailer.converter;

import org.springframework.stereotype.Component;

import com.grawar.retailer.constant.ConstantNames;
import com.grawar.retailer.entity.Retailer;
import com.grawar.retailer.model.RetailerModel;

/**
 * Class RetailerConverter.
 * Converts Retailer Entity <-> Model
 */
@Component(ConstantNames.RETAILER_CONVERTER)
public class RetailerConverter {
	
	/**
	 * Entity 2 model.
	 *
	 * @param retailer is Retailer entity
	 * @return Retailer model
	 */
	public RetailerModel entity2Model(Retailer retailer) {
		return new RetailerModel(retailer.getBarcode());
	}
	
	/**
	 * Model 2 entity.
	 *
	 * @param retailerModel is Retailer model
	 * @return Retailer entity
	 */
	public Retailer model2Entity(RetailerModel retailerModel) {
		Retailer retailer = new Retailer();
		retailer.setBarcode(retailerModel.getBarcode());
		return retailer;
	}
}
