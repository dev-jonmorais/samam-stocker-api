package com.lp3btechsys.samamstocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lp3btechsys.samamstocker.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	// LISTING CITY BY NAME
	@Query("FROM City WHERE cityName = ?1")
	List<City> findCityByCityName(String cityName);

}
