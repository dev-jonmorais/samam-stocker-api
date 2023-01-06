package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lp3btechsys.samamstocker.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// Listing Products Order by productName
	@Query("FROM Product WHERE productName = ?1 ORDER BY productName ASC")
	List<Product> findProductByProductName(String productName);
	
	// Listing Product Order by category
	@Query("FROM Product WHERE productName = ?1 ORDER BY category ASC")
	List<Product> findProductsByCategory(String category);
}
