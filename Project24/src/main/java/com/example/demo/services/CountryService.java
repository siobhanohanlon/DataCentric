package com.example.demo.services;

import com.example.demo.repository.CountryRepo;
import com.example.demo.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    public Optional<Country> getCountryById(Integer id) {
        return countryRepo.findById(id);
    }

//    public ResponseEntity<ErrorResponseBuilder> deleteCountryBySid(String sid) {
//        Optional<Country> optionalCountry = countryRepo.findBySid(sid);
//
//        if (optionalCountry.isPresent()) {
//            Country country = optionalCountry.get();
//
//            if (!country.getModules().isEmpty()) {
//                ErrorResponseBuilder errorResponseBuilder = ErrorResponseBuilder.buildErrorResponse(
//                        HttpStatus.INTERNAL_SERVER_ERROR, "Cannot delete country with associated modules",
//                        "/Countries/" + sid);
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseBuilder);
//            }
//
//            countryRepo.delete(country);
//
//            ErrorResponseBuilder successResponseBuilder = ErrorResponseBuilder.buildErrorResponse(
//                    HttpStatus.OK, "Country deleted successfully", "/Countrys/" + sid);
//            return ResponseEntity.ok().body(successResponseBuilder);
//        } else {
//            ErrorResponseBuilder errorResponseBuilder = ErrorResponseBuilder.buildErrorResponse(
//                    HttpStatus.INTERNAL_SERVER_ERROR, "Country not found", "/Countrys/" + sid);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseBuilder);
//        }
//    }
}