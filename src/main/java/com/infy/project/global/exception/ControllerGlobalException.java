package com.infy.project.global.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infy.project.custom.exception.EmptyInputException;
import com.infy.project.custom.exception.NoSuchElementException;
import com.infy.project.custom.exception.UserAlreadyPresentException;



@RestControllerAdvice
public class ControllerGlobalException extends ResponseEntityExceptionHandler{
	
  	
 @ExceptionHandler(NoSuchElementException.class)
 public ResponseEntity<Map> handleNoSuchElementException( NoSuchElementException ex){
	 Map<String, String> errorResponse = new HashMap<>();
     errorResponse.put("errorCode", ex.getErrorCode());
     errorResponse.put("errorMessage", ex.getErrorMessage());

     return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
 }
 
 
 @ExceptionHandler(EmptyInputException.class)
 public ResponseEntity<Map>handleEmptyInputException(EmptyInputException ex){
	 
	 Map<String,String> errorResponse = new HashMap<>();
	 errorResponse.put("errorCode", ex.getErrorCode());
     errorResponse.put("errorMessage", ex.getErrorMessage());

     return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
 }
 
 @ExceptionHandler(UserAlreadyPresentException.class)
 public ResponseEntity<Map> handleUserAlreadyPresentException(UserAlreadyPresentException ex){
	 Map<String,String> errorResponse = new HashMap<>();
	 errorResponse.put("errorCode", ex.getErrorCode());
     errorResponse.put("errorMessage", ex.getErrorMessage());

     return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	 
 }
 
 

}
