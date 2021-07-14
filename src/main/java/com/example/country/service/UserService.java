package com.example.country.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.country.model.User;
import com.example.country.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService{
	
	  	User findByEmail(String email);
	    User save(UserRegistrationDto registration);
	    
}
