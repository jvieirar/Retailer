package com.grawar.retailer.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grawar.retailer.entity.Retailer;

@Repository("RetailerJPARepository")
public interface RetailerJPARepository extends JpaRepository<Retailer, Serializable>{
	
	//method JPA will process
	public abstract Retailer findById(int id);
}
