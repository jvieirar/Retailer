package com.grawar.retailer.service;

import com.grawar.retailer.entity.Retailer;

public interface RetailerService {
	public abstract Retailer getRetailer();
	public abstract Retailer getRetailer(int id);
	public abstract int incrementBarcode(int inc);
	public abstract int incrementBarcode(int id, int inc);
}
