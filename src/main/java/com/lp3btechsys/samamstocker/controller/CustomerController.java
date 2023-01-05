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

import com.lp3btechsys.samamstocker.model.Customer;
import com.lp3btechsys.samamstocker.repository.CustomerRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(
				@RequestParam(required = false) String FirstName, String LastName, String DocCPF
			)
	{
		try {
			List<Customer> customers = new ArrayList<Customer>();
			
			if (FirstName == null && LastName == null && DocCPF == null)
				customerRepository.findAll().forEach(customers::add);
			else if (FirstName != null)
				customerRepository.findCustomerByFirstName(FirstName).forEach(customers::add);
			else if (LastName != null)
				customerRepository.findCustomerByLastName(LastName).forEach(customers::add);
			else
				customerRepository.findCustomerByDocCPF(DocCPF).forEach(customers::add);
			
			
			if ( customers.isEmpty() )
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		Optional<Customer> customerData = customerRepository.findById(id);
		
		if (customerData.isPresent()) {
	      return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/customer/new") //eg.: https://localhost:8081/api/customer/new
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		try {
			Customer _customer = customerRepository
			          .save(
			        		  new Customer(
			        				  	customer.getFirstName(),
			        				  	customer.getLastName(),
			        				  	customer.getSex(),
			        				  	customer.getDocCPF(),
			        				  	customer.getDocCNPJ(),
			        				  	customer.getPhoneMain(),
			        				  	customer.getPhoneSecondary(),
			        				  	customer.getEmailContact(),
			        				  	customer.getCity(),
			        				  	customer.getNeighboorhood(),
			        				  	customer.getAddressLine1(),
			        				  	customer.getAddressLine2(),
			        				  	customer.getAddressNumber()
			        				  )
		        		  );
			return new ResponseEntity<>(_customer, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		Optional<Customer> customerData = customerRepository.findById(id);
		
		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setFirstName(customer.getFirstName());
			_customer.setLastName(customer.getLastName());
			_customer.setSex(customer.getSex());
			_customer.setDocCPF(customer.getDocCPF());
			_customer.setDocCNPJ(customer.getDocCNPJ());
			_customer.setPhoneMain(customer.getPhoneMain());
			_customer.setPhoneSecondary(customer.getPhoneSecondary());
			_customer.setEmailContact(customer.getEmailContact());
			_customer.setCity(customer.getCity());
			_customer.setNeighboorhood(customer.getNeighboorhood());
			_customer.setAddressLine1(customer.getAddressLine1());
			_customer.setAddressLine2(customer.getAddressLine2());
			_customer.setAddressNumber(customer.getAddressNumber());
			
			return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
		} else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
		try {
			customerRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<HttpStatus> deleteAllCustomers() {
		try {
			customerRepository.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
