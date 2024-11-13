package com.infy.project.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.project.entity.User;
import com.infy.project.repo.UserRepo;

@SpringBootTest
public class UserServiceImplTest {
	
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepo userRepo;
	

	
	//@Disabled
	@ParameterizedTest
	@ValueSource(strings = {"100010", "100020", "100030"})
    void getUserByUserId(String userId) {
		
		when(userRepo.findById("100010")).thenReturn(createUserStub(userId));
		
		 User userTested = userServiceImpl.getUserByUserId("100010");
	  
  }

	private Optional<User> createUserStub(String userId) {
		// TODO Auto-generated method stub
		User userstub = User.builder().userId(userId)
	            .email("test@example.com")
	            .password("password123")
	            .phoneNo("1234567890")
	            .build();

		return Optional.of(userstub);
	}
	
	
	@ParameterizedTest
	@CsvSource({
	        "100010, test1@example.com, password123, 1234567890",
	        "100020, test2@example.com, pass456, 0987654321",
	        "100030, test3@example.com, pass789, 1112223333"
	    })
    void addNewUserTest(String userId, String email, String password, String phoneNo) {
		
		when(userRepo.findById(userId)).thenReturn(addNewUserStub(userId, email, password, phoneNo));

		 User userTested = userServiceImpl.getUserByUserId(userId);
		 
		 assertEquals(userId, userTested.getUserId());
	        assertEquals(email, userTested.getEmail());
	        assertEquals(password, userTested.getPassword());
	        assertEquals(phoneNo, userTested.getPhoneNo());
	  
  }

	private Optional<User> addNewUserStub(String userId, String email, String password, String phoneNo) {
		// TODO Auto-generated method stub
		User userstub = User.builder().userId(userId)
	            .email(email)
	            .password(password)
	            .phoneNo(phoneNo)
				.build();
		return Optional.of(userstub);
	}
	

}
