package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.City;
import com.example.demo.repository.CityRepo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Service
public class CityService {
    @Autowired
    private CityRepo ct;

    // Retrieve all Cities
    public Iterable<City> getCities(){ return ct.findAll(); }

    // Add new City
    public City addCity(@Valid City city) {
    	// Check if ID is Valid to be used
        if (city.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID is not allowed!");
        }        
        if (idExists(city.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ID Already Exists");
        }
        // Return 
        return ct.save(city);
    }

    // Check if City Exists
    public boolean idExists(@NotBlank Integer id) {
        Optional<City> existingCity = ct.findById(id);
        return existingCity.isPresent();
    }

    // Save City
    public City saveCity(City city) {
        try {
            return ct.save(city);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(403),
                    "City ID: " + city.getId() + " already exists");
        }

    }

    // Update City
    public City updateCity(Integer id, City cityUpdates) {
    	// Check a Valid City Name has been  entered
        if (cityUpdates.getCity() == null || cityUpdates.getCity().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "City Name cannot be left blank");
        }

        Optional<City> existingCity = ct.findById(id);

        if (!existingCity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found");
        }

        City updatedCity = existingCity.get();

        // Update 
        if (cityUpdates.getCity() != null) {
            updatedCity.setCity(cityUpdates.getCity());
        }
        if (cityUpdates.getIsCapital() != null) {
            updatedCity.setIsCapital(cityUpdates.getIsCapital());
        }
        if (cityUpdates.getPopulation() != null) {
            updatedCity.setPopulation(cityUpdates.getPopulation());
        }

        return ct.save(updatedCity);
    }

    // Find City by ID
    public Optional<City> getCityById(Integer id) {
        return ct.findById(id);
    }

    // Find City by 
    public Iterable<City> findCitiesByCountryAndPopulation(String coun, Integer pop) {
        return ct.findCitiesByCountryAndPopulation(coun, pop);
    }
}