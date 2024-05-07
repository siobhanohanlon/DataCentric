package com.example.demo.services;

import com.example.demo.repository.ContinentRepo;
import com.example.demo.models.Continent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepo continentRepo;

    public List<Continent> getAllContinents() {
        return continentRepo.findAll();
    }

    public Optional<Continent> getContinentById(Integer id) {
        return continentRepo.findById(id);
    }
}