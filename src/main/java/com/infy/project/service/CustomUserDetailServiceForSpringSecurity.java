package com.infy.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infy.project.entity.User;
import com.infy.project.model.UserPrinciple;
import com.infy.project.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailServiceForSpringSecurity implements UserDetailsService {

	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> userOptional = userRepo.findById(username);
		
		User user = userOptional.get();
		
		if(user == null) {
			
			log.info("User Not Fount at our database"+username);
			throw new UsernameNotFoundException("User Not Fount at our database"+username);
		}
		
		return new UserPrinciple(user);
	}

}
