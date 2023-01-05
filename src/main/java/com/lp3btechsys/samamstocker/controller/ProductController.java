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

import com.lp3btechsys.samamstocker.model.Product;
import com.lp3btechsys.samamstocker.repository.ProductRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(
				@RequestParam(required = false) String ProductName
			)
	{
		try {
			List<Product> products = new ArrayList<Product>();
			
			if (ProductName == null)
				productRepository.findAll().forEach(products::add);
			else
				productRepository.findProductByProductName(ProductName).forEach(products::add);
			
			
			if ( products.isEmpty() )
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> productData = productRepository.findById(id);
		
		if (productData.isPresent()) {
	      return new ResponseEntity<>(productData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/product/new") //eg.: https://localhost:8081/api/product/new
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		try {
			Product _product = productRepository
			          .save(
			        		  new Product(
			        				  	product.getProductName(),
			        				  	product.getSupplier(),
			        				  	product.getCategory(),
			        				  	product.getProductGroup(),
			        				  	product.getPurchasePrice(),
			        				  	product.getSellingPrice(),
			        				  	product.getProductQuantity(),
			        				  	product.getProductPhotoCover(),
			        				  	product.getProductDescription()
			        				  )
		        		  );
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		Optional<Product> productData = productRepository.findById(id);
		
		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setProductName(product.getProductName());
			_product.setSupplier(product.getSupplier());
			_product.setCategory(product.getCategory());
			_product.setProductGroup(product.getProductGroup());
			_product.setPurchasePrice(product.getPurchasePrice());
			_product.setSellingPrice(product.getSellingPrice());
			_product.setProductQuantity(product.getProductQuantity());
			_product.setProductPhotoCover(product.getProductPhotoCover());
			_product.setProductDescription(product.getProductDescription());
			
			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
		} else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
		try {
			productRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			productRepository.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
