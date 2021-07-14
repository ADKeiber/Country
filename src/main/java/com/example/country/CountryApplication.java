package com.example.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CountryApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CountryApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(countryApplicationClass);
	}
	
	private static Class<CountryApplication> countryApplicationClass = CountryApplication.class;

}
