package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lp3btechsys.samamstocker.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// Listing Customers By First Name
	@Query("FROM Customer WHERE firstName = ?1")
	List<Customer> findCustomerByFirstName(String firstName);
	
	// Listing Customers By Last Name
	@Query("FROM Customer WHERE lastName = ?1")
	List<Customer> findCustomerByLastName(String lastName);

	// Listing Customers By Doc CPF
	@Query("FROM Customer WHERE docCPF = ?1")
	List<Customer> findCustomerByDocCPF(String docCPF);
	
	// Listing Customers By Doc CNPJ
	@Query("FROM Customer WHERE docCNPJ = ?1")
	List<Customer> findCustomerByDocCNPJ(String docCNPJ);
	
	// Listing Customers Order by Last Name
	@Query("FROM Customer WHERE firstName = ?1 ORDER BY lastName ASC")
	List<Customer> findCustomerByFirstNameOrderByLastname(String firstName);
}
