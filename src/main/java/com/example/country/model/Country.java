package com.example.country.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
@Entity
@Table(name="countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int countryId;
	
	@Size(min=2, max=30)
	public String countryName;
	
	@Size(min=2, max=30)
	public String capital;

	@Min(value = 1000)
	public int population;
	
	public Country() {
		
	}

	public Country(String countryName, String capital, int population) {
		super();
		this.countryName = countryName;
		this.capital = capital;
		this.population = population;
	}
	public void setCountryId(int id) {
		this.countryId = id;
	}
	public int getCountryId() {
		return this.countryId;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [countryId= " + countryId + ", countryName= " + countryName + ", capital= " + capital
				+ ", population= " + population + "]";
	}
	
	
	
	
}
