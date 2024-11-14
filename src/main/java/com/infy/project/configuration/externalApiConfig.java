package com.infy.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class externalApiConfig {
	
	
       @Bean
       RestTemplate restTemplate() {

		 return new RestTemplate();

		
	}

}
