package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp3btechsys.samamstocker.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// Listing Customers By First Name
	List<Customer> findCustomerByFirstName(String FirstName);
	
	// Listing Customers By Last Name
	List<Customer> findCustomerByLastName(String LastName);

	// Listing Customers By Doc CPF
	List<Customer> findCustomerByDocCPF(String DocCPF);
}
