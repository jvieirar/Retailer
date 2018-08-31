package com.grawar.retailer.exception;

import com.grawar.retailer.constant.ConstantParams;

/**
 * Class RetailerNotFoundException.
 * 
 */
public class RetailerNotFoundException extends Exception{
	
	/**
	 * Instantiates a new retailer not found exception with the default message
	 */
	public RetailerNotFoundException() {
		this(ConstantParams.DEFAULT_NOT_FOUND_EXCEPTION_MSG);
	}
	
	/**
	 * Instantiates a new retailer not found exception.
	 *
	 * @param message the message
	 */
	public RetailerNotFoundException(String message) {
		super(message);
	}
}
