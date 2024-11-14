package com.infy.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
	
	@GetMapping
	String getAddress(){
		
		 return "This is address controller"; 
		
	}

}
