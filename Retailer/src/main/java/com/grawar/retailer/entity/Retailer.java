package com.grawar.retailer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.grawar.retailer.constant.ConstantNames;

/**
 * Class Retailer.
 * Entity
 */
@Entity
@Table(name=ConstantNames.RETAILER_ENTITY)
public class Retailer {
	
	/** id autoincrement */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	/** The barcode. */
	@Column(name="barcode")
	private int barcode;
	
	public Retailer() {
	}
	
	/**
	 * Instantiates a new retailer.
	 *
	 * @param id the id
	 * @param barcode the barcode
	 */
	public Retailer(int id, int barcode) {
		super();
		this.id = id;
		this.barcode = barcode;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
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
