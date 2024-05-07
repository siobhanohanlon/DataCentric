package com.example.demo.controllers;
//import com.example.demo.Errors.ErrorResponseBuilder;
//import com.example.demo.Errors.HTTP403;
//import com.example.demo.Errors.HTTP500;
import com.example.demo.Validation.CityPOSTValidation;
import com.example.demo.Validation.CityPUTValidation;
import com.example.demo.models.City;
import com.example.demo.services.CityService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/city")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CityController {

    @Autowired
    CityService cityS;

    @GetMapping
    public ResponseEntity<Iterable<City>> getCities() {
        return ResponseEntity.ok(cityS.getCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Integer id) {
        return cityS.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<City>> searchCities(
            @RequestHeader(value = "Country", required = false) String country,
            @RequestHeader(value = "Population", required = false) Integer population) {
        return ResponseEntity.ok(cityS.findCitiesByCountryAndPopulation(country, population));
    }

    @PostMapping
    @Validated(CityPOSTValidation.class)
    public ResponseEntity<City> addCity(
            @Valid @RequestBody City cityValidation) {

        City createdCity = cityS.saveCity(cityValidation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }

    @PutMapping(path = "/{id}")
    @Validated(CityPUTValidation.class)
    public ResponseEntity<City> updateCity(@PathVariable("id") Integer id,
            @Valid @RequestBody City updatedCity) {
        return ResponseEntity.ok(cityS.updateCity(id, updatedCity));
    }
}