package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp3btechsys.samamstocker.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	// LISTING CITY BY NAME
	List<City> findCityByCityName(String cityName);

}
