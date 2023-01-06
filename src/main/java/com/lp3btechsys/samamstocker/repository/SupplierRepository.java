package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lp3btechsys.samamstocker.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	// Listing Suppliers where SupplierName
	@Query("FROM Supplier WHERE supplierName = ?1")
	List<Supplier> findSupplierBySupplierName(String supplierName);
}
