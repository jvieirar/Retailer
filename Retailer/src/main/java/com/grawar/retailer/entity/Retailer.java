package com.grawar.retailer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Retailer")
public class Retailer {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="barcode")
	private int barcode;
	
	public Retailer() {
		
	}
	
	public Retailer(int id, int barcode) {
		super();
		this.id = id;
		this.barcode = barcode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
}
