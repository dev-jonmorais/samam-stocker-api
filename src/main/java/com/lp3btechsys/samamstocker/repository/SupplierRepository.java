package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp3btechsys.samamstocker.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	// Listing Suppliers By Name
	List<Supplier> findSupplierBySupplierName(String SupplierName);
}
