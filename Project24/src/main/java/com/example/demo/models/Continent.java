package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "continent")
public class Continent {	
	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String continent;
	private int area;
	private String pop;
	@OneToMany(mappedBy = "continent")
	private List<Country> countries = new ArrayList<Country>();
	
	// Getters
	public int getId() { return id; }
	public String getContinent() { return continent; }
	public int getArea() { return area; }
	public String getPop() { return pop; }
	public List<Country> getCountries() { return countries; }

	//Setters
	public void setId(int id) { this.id = id; }
	public void setContinent(String continent) { this.continent = continent; }
	public void setArea(int area) { this.area = area; }
	public void setPop(String pop) { this.pop = pop; }
	public void setCountries(List<Country> countries) { this.countries = countries; }
}