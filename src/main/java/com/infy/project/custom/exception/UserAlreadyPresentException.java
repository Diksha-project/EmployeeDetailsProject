package com.infy.project.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAlreadyPresentException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String ErrorCode;
	private String ErrorMessage;
}
