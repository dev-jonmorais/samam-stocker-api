package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp3btechsys.samamstocker.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Listing Employees By First Name
	List<Employee> findEmployeeByFirstName(String FirstName);
	
	// Listing Employees By Last Name
	List<Employee> findEmployeeByLastName(String LastName);
}
