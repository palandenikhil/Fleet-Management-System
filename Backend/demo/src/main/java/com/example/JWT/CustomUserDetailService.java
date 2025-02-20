package com.example.JWT;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Models.*;

import com.example.Repositories.UserRepository;

import java.util.*;;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	   UserLogin user =userRepository.findByEmail(email);
		 if (user == null) {
	            throw new UsernameNotFoundException("User not found with email: " + email);
	        }
	        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
	}

}
