package com.grawar.retailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class RetailerApplication.
 * API to increment a Retailer's barcodes and show them using JSON
 */
@SpringBootApplication
public class RetailerApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(RetailerApplication.class, args);
	}
}
