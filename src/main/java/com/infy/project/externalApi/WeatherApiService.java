package com.infy.project.externalApi;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {
	

	 String url = "https://weatherapi-com.p.rapidapi.com/current.json?q=53.1%2C-0.13";
	 String api_key_name = "X-RapidAPI-Key";
	 String api_key_value = "710d7d7fddmsh908eceb920b8633p139720jsn3be385f7cb9b";

	
	
	@Autowired
	private RestTemplate restTemplate ;
	
	
	public String postWeatherApiData() {
	 // Create HttpHeaders and set the secret key
	HttpHeaders headers = new HttpHeaders();
	
	 headers.set(api_key_name ,api_key_value);
	 
	 // Create HttpEntity 
	 HttpEntity<String> entity = new HttpEntity<String>(headers);
	 
	 return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	  
   
	
	}
	

}
