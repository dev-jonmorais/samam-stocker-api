package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp3btechsys.samamstocker.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// Listing Products By Name
	List<Product> findProductByProductName(String ProductName);
}
