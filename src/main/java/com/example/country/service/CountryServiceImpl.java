package com.example.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.country.model.Country;
import com.example.country.repo.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepo repo;

	@Override
	public List<Country> getCountriesList() {
		return repo.findAll();
	}

	@Override
	public Country getCountryById(int id) {
//		System.out.println(repo.getById(id).toString());
		return repo.getById(id);
	}

	@Override
	public void saveCountry(Country c) {
		repo.save(c);
	}

	@Override
	public void removeCountry(Country c) {
		System.out.println(c.countryId);
//		repo.deleteById(c.countryId);
	}
	
}
