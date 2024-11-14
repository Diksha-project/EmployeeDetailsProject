package com.infy.project.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmptyInputException extends RuntimeException{
	
	 private String ErrorCode;
     private  String ErrorMessage;
	

}
