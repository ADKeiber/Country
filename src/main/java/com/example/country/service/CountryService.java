package com.example.country.service;

import java.util.List;
import com.example.country.model.Country;

public interface CountryService {
	public List<Country> getCountriesList();
	public Country getCountryById(int id);
	public void saveCountry(Country c);
	public void removeCountry(Country c);
}
