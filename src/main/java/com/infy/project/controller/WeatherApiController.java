package com.infy.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.project.externalApi.WeatherApiService;

@RestController
@RequestMapping("/weather")
public class WeatherApiController {
	
	@Autowired
	private WeatherApiService weatherApiService;
	
	@GetMapping
	String getWeatherDetails(){
		
		String str = weatherApiService.postWeatherApiData();
		

		 return str;

		
	}

}
