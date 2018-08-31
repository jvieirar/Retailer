package com.grawar.retailer.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grawar.retailer.constant.ConstantNames;
import com.grawar.retailer.entity.Retailer;

/**
 * Interface RetailerJPARepository.
 */
@Repository(ConstantNames.RETAILER_JPA_REPOSITORY)
public interface RetailerJPARepository extends JpaRepository<Retailer, Serializable>{
	
	/**
	 * Find Retailer by id.
	 * JPA will process
	 *
	 * @param id the id
	 * @return the retailer
	 */ 
	public abstract Retailer findById(int id);
}
