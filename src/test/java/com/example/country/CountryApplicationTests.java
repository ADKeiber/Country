package com.example.country;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.country.model.Country;
import com.example.country.repo.CountryRepo;

@SpringBootTest
class CountryApplicationTests {

	@Autowired
	CountryRepo repo;
	
	@Test
	void contextLoads() {
		
		Country c1 = new Country("United States of America", "Washington D.C", 332513320);
		Country c2 = new Country("China", "Beijing", 1397897720);
		Country c3 = new Country("United Kingdom", "London", 68255526);
		Country c4 = new Country("Canada", "Ottawa", 38087233);
		Country c5 = new Country("India", "New Delhi", 1339330514);
		List<Country> countries = new ArrayList<>();
		
		countries.add(c1);
		countries.add(c2);
		countries.add(c3);
		countries.add(c4);
		countries.add(c5);
		
		repo.saveAll(countries);
	}

}
