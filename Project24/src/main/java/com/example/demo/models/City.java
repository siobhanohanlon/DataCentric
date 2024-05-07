package com.example.demo.models;

import com.example.demo.Validation.CityPOSTValidation;
import com.example.demo.Validation.CityPUTValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

@Entity
@Table(name = "city")
public class City {	
	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Null(message = "ID not allowed!", groups = CityPUTValidation.class)
	@Null(message = "ID not allowed!", groups = CityPOSTValidation.class)
	private Integer id;
	@Column(unique = true)
	@NotNull(message = "City Name is required", groups = CityPUTValidation.class)
	@NotNull(message = "City Name is required", groups = CityPOSTValidation.class)
	private String city;
	private Boolean isCapital;
	private Integer population;
	@ManyToOne
	@JoinColumn(name = "country_fk")
	private Country country;
	
	// Getters
	public Integer getId() { return id; }
	public String getCity() { return city; }
	public Boolean getIsCapital() { return isCapital; }
	public Integer getPopulation() { return population; }
	public Country getCountry() { return country; }
	
	//Setters
	public void setId(Integer id) { this.id = id; }
	public void setCity(String city) { this.city = city; }
	public void setIsCapital(Boolean isCapital) { this.isCapital = isCapital; }
	public void setPopulation(Integer population) { this.population = population; }
	public void setCountry(Country country) { this.country = country; }
}