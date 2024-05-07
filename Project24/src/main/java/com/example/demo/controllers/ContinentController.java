package com.example.demo.controllers;

import com.example.demo.models.Continent;
import com.example.demo.services.ContinentService;
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
@RequestMapping("/continents")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContinentController {

    // Inject the ContinentService object into the controller using @Autowired
    // annotation
    @Autowired
    private ContinentService continentService;

    // HTTP GET request to retrieve all continents
    @GetMapping
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }

    // HTTP GET request to retrieve a continent by their SID
    @GetMapping("/{id}")
    public ResponseEntity<Continent> getContinentById(@PathVariable Integer id) {
        // Call the getContinentBySid() method of the ContinentService to get the continent by ID
        Optional<Continent> optionalContinent = continentService.getContinentById(id);

        // If the continent exists, return the continent in the response body with HTTP
        // status code 200 OK
        if (optionalContinent.isPresent()) {
            return ResponseEntity.ok(optionalContinent.get());
        } else { // Otherwise, return HTTP status code 404 NOT FOUND
            return ResponseEntity.notFound().build();
        }
    }

//    // HTTP DELETE request to delete a continent by their ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ErrorResponseBuilder> deleteContinentById(@PathVariable Integer id) {
//        // Call the deleteContinentBySid() method of the ContinentService to delete the
//        // continent by ID
//        return continentService.deleteContinentById(id);
//    }
}