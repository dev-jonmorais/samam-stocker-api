package com.lp3btechsys.samamstocker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lp3btechsys.samamstocker.model.Employee;
import com.lp3btechsys.samamstocker.repository.EmployeeRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(
				@RequestParam(required = false) String FirstName, String LastName, String DocCPF
			)
	{
		try {
			List<Employee> employees = new ArrayList<Employee>();
			
			if (FirstName == null && LastName == null && DocCPF == null)
				employeeRepository.findAll().forEach(employees::add);
			else if (FirstName != null)
				employeeRepository.findEmployeeByFirstName(FirstName).forEach(employees::add);
			else if (LastName != null)
				employeeRepository.findEmployeeByLastName(LastName).forEach(employees::add);
			
			
			if ( employees.isEmpty() )
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		
		if (employeeData.isPresent()) {
	      return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/employee/new") //eg.: https://localhost:8081/api/customer/new
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			Employee _employee = employeeRepository
			          .save(
			        		  new Employee(
			        				  employee.getFirstName(),
			        				  employee.getLastName(),
			        				  employee.getAliasName(),
			        				  employee.getSex(),
			        				  employee.getAge(),
			        				  employee.getPhoneMain(),
			        				  employee.getDocCPF(),
			        				  employee.getDocRG(),
			        				  employee.getPosition(),
			        				  employee.getExperienceTime(),
			        				  employee.getNeighboorhood(),
			        				  employee.getAddressLine1(),
			        				  employee.getAddressLine2(),
			        				  employee.getAddressNumber()
			        				  )
		        		  );
			return new ResponseEntity<>(_employee, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		
		if (employeeData.isPresent()) {
			Employee _employee = employeeData.get();
			_employee.setFirstName(employee.getFirstName());
			_employee.setLastName(employee.getLastName());
			_employee.setAliasName(employee.getAliasName());
			_employee.setSex(employee.getSex());
			_employee.setAge(employee.getAge());
			_employee.setPhoneMain(employee.getPhoneMain());
			_employee.setDocCPF(employee.getDocCPF());
			_employee.setDocRG(employee.getDocRG());						
			_employee.setPosition(employee.getPosition());
			_employee.setExperienceTime(employee.getExperienceTime());
			_employee.setNeighboorhood(employee.getNeighboorhood());
			_employee.setAddressLine1(employee.getAddressLine1());
			_employee.setAddressLine2(employee.getAddressLine2());
			_employee.setAddressNumber(employee.getAddressNumber());
			
			return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
		} else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		try {
			employeeRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteAllEmployees() {
		try {
			employeeRepository.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
