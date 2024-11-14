package com.infy.project.service;

import java.util.List;

import com.infy.project.entity.User;

public interface UserService {
	
	
	 List<User>  getAllUsers();
	 User getUserByUserId(String userId);
	 
	 User getByEmail(String email);
	 
	 String addNewUser(User user);
	 
	 

}
