package com.example.demo.repository;

import com.example.demo.models.Country;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
    Optional<Country> findById(Integer id);
}