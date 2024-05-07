package com.example.demo.repository;

import com.example.demo.models.City;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
    Optional<City> findById(Integer id);

    // @Query(value = "SELECT * FROM Lecturer WHERE tax_band = ?1", nativeQuery =
    // true)
    // Iterable<Lecturer> findLecturersByTaxBand(String taxBand);

    // @Query(value = "SELECT * FROM Lecturer WHERE salary_scale >= :salaryScale",
    // nativeQuery = true)
    // Iterable<Lecturer> findLecturersBySalaryScaleOrGreater(int salaryScale);

    @Query(value = "SELECT * FROM City c WHERE (:country IS NULL OR c.country = :country) AND (:population IS NULL OR c.population >= :population)", nativeQuery = true)
    Iterable<City> findCitiesByCountryAndPopulation(@BindParam("country") String country,
            @BindParam("population") Integer population);
}