package com.grawar.retailer.model;

/**
 * Class IncRequestModel.
 * Object to transmit the information using JSON
 */
public class IncRequestModel {
	
	/** The increment */
	private int inc;
	
	public IncRequestModel() {}
	
	/**
	 * Instantiates a new increment request model.
	 *
	 * @param inc the inc
	 */
	public IncRequestModel(int inc) {
		this.inc = inc;
	}

	/**
	 * Gets the increment.
	 *
	 * @return the inc
	 */
	public int getInc() {
		return inc;
	}

	/**
	 * Sets the increment.
	 *
	 * @param inc the new inc
	 */
	public void setInc(int inc) {
		this.inc = inc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.inc);
	}
}
