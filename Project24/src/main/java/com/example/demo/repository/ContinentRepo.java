package com.example.demo.repository;

import com.example.demo.models.Continent;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepo extends JpaRepository<Continent, Integer> {
    Optional<Continent> findById(Integer id);
}