package com.grawar.retailer.model;

public class RetailerModel {
	private int barcode;

	public RetailerModel() {
	}
	
	public RetailerModel(int barcode) {
		super();
		this.barcode = barcode;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	
}
