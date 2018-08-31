package com.grawar.retailer.service;

import com.grawar.retailer.entity.Retailer;
import com.grawar.retailer.exception.RetailerNotFoundException;
import com.grawar.retailer.model.RetailerModel;

/**
 * Interface RetailerService.
 * Service to interact with the database
 */
public interface RetailerService {
	
	/**
	 * Gets the Retailer Model by default.
	 *
	 * @return the Retailer Model
	 * @throws RetailerNotFoundException 
	 */
	public abstract RetailerModel getRetailer() throws RetailerNotFoundException;
	
	/**
	 * Gets the Retailer Model by id.
	 *
	 * @param id the id
	 * @return the Retailer Model
	 * @throws RetailerNotFoundException 
	 */
	public abstract RetailerModel getRetailer(int id) throws RetailerNotFoundException;
	
	/**
	 * Increments barcode in the default Retailer.
	 *
	 * @param inc the increment
	 * @return the increment or 0
	 * @throws RetailerNotFoundException 
	 */
	public abstract int incrementBarcode(int inc) throws RetailerNotFoundException;
	
	/**
	 * Increment barcode in the Retailer(id).
	 *
	 * @param id the Retailer id
	 * @param inc the increment
	 * @return the increment or 0
	 * @throws RetailerNotFoundException 
	 */
	public abstract int incrementBarcode(int id, int inc) throws RetailerNotFoundException;
	
	/**
	 * Adds the a Retailer from a Retailer model object.
	 *
	 * @param retailerModel the retailer model
	 * @return the Retailer
	 */
	public abstract Retailer addRetailer(RetailerModel retailerModel);
}
