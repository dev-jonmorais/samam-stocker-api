package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lp3btechsys.samamstocker.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Listing Employees where First Name
	@Query("FROM Employee WHERE firstName = ?1")
	List<Employee> findEmployeeByFirstName(String firstName);
	
	// Listing Employees where Last Name
	@Query("FROM Employee WHERE lastName = ?1")
	List<Employee> findEmployeeByLastName(String lastName);
}
