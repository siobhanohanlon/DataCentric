package com.example.demo.controllers;

import com.example.demo.models.Country;
import com.example.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountryController {

    // Inject the CountryService object into the controller using @Autowired
    // annotation
    @Autowired
    private CountryService countryService;

    // HTTP GET request to retrieve all countries
    @GetMapping
    public List<Country> getAllCountrys() {
        return countryService.getAllCountries();
    }

    // HTTP GET request to retrieve a country by their SID
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Integer id) {
        // Call the getCountryBySid() method of the CountryService to get the country by ID
        Optional<Country> optionalCountry = countryService.getCountryById(id);

        // If the country exists, return the country in the response body with HTTP
        // status code 200 OK
        if (optionalCountry.isPresent()) {
            return ResponseEntity.ok(optionalCountry.get());
        } else { // Otherwise, return HTTP status code 404 NOT FOUND
            return ResponseEntity.notFound().build();
        }
    }

//    // HTTP DELETE request to delete a country by their ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ErrorResponseBuilder> deleteCountryById(@PathVariable Integer id) {
//        // Call the deleteCountryBySid() method of the CountryService to delete the
//        // country by ID
//        return countryService.deleteCountryById(id);
//    }
}