package com.grawar.retailer.model;

/**
 * Class RetailerModel.
 * Retailer model
 */
public class RetailerModel {
	
	/** The barcode. */
	private int barcode;

	public RetailerModel() {
	}
	
	/**
	 * Instantiates a new retailer model.
	 *
	 * @param barcode the barcode
	 */
	public RetailerModel(int barcode) {
		super();
		this.barcode = barcode;
	}

	/**
	 * Gets the barcode.
	 *
	 * @return the barcode
	 */
	public int getBarcode() {
		return barcode;
	}

	/**
	 * Sets the barcode.
	 *
	 * @param barcode the new barcode
	 */
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	
}
