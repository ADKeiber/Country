package com.example.country.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.country.model.User;
import com.example.country.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(UserRegistrationDto registration) {
		// TODO Auto-generated method stub
		return null;
	}


}
