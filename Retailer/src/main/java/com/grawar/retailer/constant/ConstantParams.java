package com.grawar.retailer.constant;
/**
 * Class ConstantParams.
 * Contains constants for every app parameter
 */
public class ConstantParams {
	//Defaults
	public static final int DEFAULT_RETAILER_ID = 1;
	public static final String DEFAULT_NOT_FOUND_EXCEPTION_MSG = "Retailer not found";
	public static final int DEFAULT_TASK_DELAY = /*7200000*/5000;//2h
	public static final long DEFAULT_TASK_INI_DELAY = 5000;
	public static final int DEFAULT_INCREMENT = 1;
	
	//Paths
	public static final String GET_BARCODE_PATH = "/api/retailer/barcode";
	public static final String INCREMENT_BARCODE_PATH = "/api/retailer/inc";
	public static final String SERVER_URL = "http://localhost:8080";
	
	//
	public static final int TASK_INCREMENT = 2;
}
