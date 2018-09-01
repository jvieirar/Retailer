package com.grawar.retailer.model;

import com.grawar.retailer.constant.ConstantParams;

/**
 * Class IncRequestModel.
 * Object to transmit the information using JSON
 */
public class IncRequestModel {
	
	/** The increment */
	private int inc;
	
	public IncRequestModel() {
		this(ConstantParams.DEFAULT_INCREMENT);
	}
	
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

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof IncRequestModel)) {
			return false;
		}
		IncRequestModel irm = (IncRequestModel)obj;
		return this.getInc() == irm.getInc();
	}
}
