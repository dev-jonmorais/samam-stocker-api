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

import com.lp3btechsys.samamstocker.model.Supplier;
import com.lp3btechsys.samamstocker.repository.SupplierRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SupplierController {

	@Autowired
	SupplierRepository supplierRepository;
	
	@GetMapping("/suppliers")
	public ResponseEntity<List<Supplier>> getAllSuppliers(
				@RequestParam(required = false) String SupplierName
			)
	{
		try {
			List<Supplier> suppliers = new ArrayList<Supplier>();
			
			if (SupplierName == null)
				supplierRepository.findAll().forEach(suppliers::add);
			else
				supplierRepository.findSupplierBySupplierName(SupplierName).forEach(suppliers::add);
			
			
			if ( suppliers.isEmpty() )
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(suppliers, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") long id) {
		Optional<Supplier> supplierData = supplierRepository.findById(id);
		
		if (supplierData.isPresent()) {
	      return new ResponseEntity<>(supplierData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/supplier/new") //eg.: https://localhost:8081/api/customer/new
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
		try {
			Supplier _supplier = supplierRepository
			          .save(
			        		  new Supplier(
			        				  	supplier.getSupplierName(),
			        				  	supplier.getCity(),
			        				  	supplier.getPhoneMain(),
			        				  	supplier.getPhoneSecondary(),
			        				  	supplier.getEmailContact(),
			        				  	supplier.getDocCNPJ(),
			        				  	supplier.getNeighboorhood(),
			        				  	supplier.getAddressLine1(),
			        				  	supplier.getAddressLine2(),
			        				  	supplier.getAddressNumber()
			        				  )
		        		  );
			return new ResponseEntity<>(_supplier, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") long id, @RequestBody Supplier supplier) {
		Optional<Supplier> supplierData = supplierRepository.findById(id);
		
		if (supplierData.isPresent()) {
			Supplier _supplier = supplierData.get();
			_supplier.setSupplierName(supplier.getSupplierName());
			_supplier.setCity(supplier.getCity());
			_supplier.setPhoneMain(supplier.getPhoneMain());
			_supplier.setPhoneSecondary(supplier.getPhoneSecondary());
			_supplier.setEmailContact(supplier.getEmailContact());
			_supplier.setDocCNPJ(supplier.getDocCNPJ());
			_supplier.setNeighboorhood(supplier.getNeighboorhood());
			_supplier.setAddressLine1(supplier.getAddressLine1());
			_supplier.setAddressLine2(supplier.getAddressLine1());
			_supplier.setAddressNumber(supplier.getAddressNumber());
			
			return new ResponseEntity<>(supplierRepository.save(_supplier), HttpStatus.OK);
		} else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<HttpStatus> deleteSupplier(@PathVariable("id") long id) {
		try {
			supplierRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/suppliers")
	public ResponseEntity<HttpStatus> deleteAllSuppliers() {
		try {
			supplierRepository.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
