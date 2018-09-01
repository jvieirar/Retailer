package com.grawar.retailer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class RetailerNotFoundAdvice.
 * Controls the RetailerNotFoundException during HTTP communication
 */
@ControllerAdvice
public class RetailerNotFoundAdvice {
	
	/**
	 * Retailer not found handler.
	 *
	 * @param e the RetailerNotFoundException
	 * @return the message
	 */
	@ResponseBody
	@ExceptionHandler(RetailerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String retailerNotFoundHandler(RetailerNotFoundException e) {
		return e.getMessage();
	}
}
