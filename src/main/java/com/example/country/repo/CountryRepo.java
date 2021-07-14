package com.example.country.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.country.model.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {

}
