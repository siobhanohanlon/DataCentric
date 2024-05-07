package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String country;
	private String headOfState;
	@ManyToOne
	@JoinColumn(name = "continent_fk")
	private Continent continent;
	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private List<City> cities;
	
	// Getters
	public Integer getId() { return id; }
	public String getCountry() { return country; }
	public String getHeadOfState() { return headOfState; }
	public Continent getContinent() { return continent; }
	public List<City> getCities() { return cities; }
	
	//Setters
	public void setId(Integer id) { this.id = id; }
	public void setCountry(String country) { this.country = country; }
	public void setHeadOfState(String headOfState) { this.headOfState = headOfState; }
	public void setContinent(Continent continent) { this.continent = continent;	}	
	public void setCities(List<City> cities) { this.cities = cities; }
}