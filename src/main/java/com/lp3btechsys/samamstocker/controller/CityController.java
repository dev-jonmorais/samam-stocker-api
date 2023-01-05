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

import com.lp3btechsys.samamstocker.model.City;
import com.lp3btechsys.samamstocker.repository.CityRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CityController {

	@Autowired
	CityRepository cityRepository;
	
	@GetMapping("/cities")
	public ResponseEntity<List<City>> getAllCities(
				@RequestParam(required = false) String cityName
			) {
		try {
			List<City> cities = new ArrayList<City>();
			
			if (cityName == null)
		        cityRepository.findAll().forEach(cities::add);
		      else
		        cityRepository.findCityByCityName(cityName).forEach(cities::add);
			
			
			if (cities.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
			
			return new ResponseEntity<>(cities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cities/{id}")
	public ResponseEntity<City> getCityById(@PathVariable("id") long id) {
		Optional<City> cityData = cityRepository.findById(id);
		
		if (cityData.isPresent()) {
	      return new ResponseEntity<>(cityData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/city/new")
	public ResponseEntity<City> createCity(@RequestBody City city) {
		try {
			City _city = cityRepository.save(new City(city.getCityName(), city.getState()));
			
			return new ResponseEntity<>(_city, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/cities/{id}")
	public ResponseEntity<City> updateCity(@PathVariable("id") long id, @RequestBody City city) {
		Optional<City> cityData = cityRepository.findById(id);
		
		if ( cityData.isPresent() ) {
			City _city = cityData.get();
			
			_city.setCityName(city.getCityName());
			_city.setState(city.getState());
			
			return new ResponseEntity<>(cityRepository.save(_city), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/cities/{id}")
	public ResponseEntity<HttpStatus> deleteCity(@PathVariable("id") long id) {
		try {
			cityRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/cities")
	public ResponseEntity<HttpStatus> deleteAllCities() {
		try {
			cityRepository.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
