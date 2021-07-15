package com.example.country.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.country.model.Role;
import com.example.country.model.User;
import com.example.country.repo.UserRepo;
import com.example.country.web.dto.UserRegistrationDto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;


	@Override
	public User findByEmail(String email) {
		return repo.findUserByEmail(email);
	}

	@Override
	public User save(UserRegistrationDto registration) {
		 User user = new User();
	        user.setFirstName(registration.getFirstName());
	        user.setLastName(registration.getLastName());
	        user.setEmail(registration.getEmail());
	        user.setPassword(passwordEncoder.encode(registration.getPassword()));
	        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		return repo.save(user);
	}

	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findUserByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
