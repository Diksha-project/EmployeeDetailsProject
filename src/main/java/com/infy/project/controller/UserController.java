package com.infy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.project.custom.exception.EmptyInputException;
import com.infy.project.entity.User;
import com.infy.project.service.EmployeeService;
import com.infy.project.service.UserService;


@RequestMapping("/users")
@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	 @GetMapping
	 ResponseEntity<List<User>> getAllUser(){
		 
		List<User> userList  = userService.getAllUsers();
		
		 return new ResponseEntity<>(userList, HttpStatus.OK) ;
	 }
	 
	
	 @GetMapping("/{userId}")
	ResponseEntity<User> getByUserId(@PathVariable String userId){
		 
		 if(userId == null) {
			 
			 throw new EmptyInputException();
		 }
		 
		 User user = userService.getUserByUserId(userId);
		 
		 return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	 
	 
	 @PostMapping("/add")
	ResponseEntity<String> addNewUser(@RequestBody User user){
		if(user == null || user.getUserId() == null) {
			
			throw new EmptyInputException("601 ","Please Add UserDetails to add user ");
		}
		
	String str = 	userService.addNewUser(user);
	
	return new ResponseEntity<>(str,HttpStatus.CREATED);
		
		
	}
	
	

}
