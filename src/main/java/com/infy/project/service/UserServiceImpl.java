package com.infy.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infy.project.custom.exception.NoSuchElementException;
import com.infy.project.custom.exception.UserAlreadyPresentException;
import com.infy.project.entity.User;
import com.infy.project.repo.UserRepo;


@Service
public class  UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepo  userRepo;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService jwtService;
	
	@Override
	public List<User> getAllUsers() {
		List<User> userList =  userRepo.findAll();
		
		return userList;
	}

	@Override
	public User getUserByUserId(String userId) {
		 Optional<User> userOptional = userRepo.findById(userId);
		 
		 if(userOptional.isEmpty()) {
			 
			 throw  new NoSuchElementException("602", "This UserId id not present in our database"+userId);
		 }
		 
		 User user = userOptional.get();
		 return user;
		
	}

	@Override
	public User getByEmail(String email) {
		return null;
	}

	@Override
	public String addNewUser(User user) {
	 
//User getExistingUser = userRepo.getById(user.getUserId());

Optional<User> getExistingUserOptional = userRepo.findById(user.getUserId());

User getExistingUser = new User();
if( !getExistingUserOptional.isEmpty()) {
	
	 getExistingUser=  getExistingUserOptional.get();
}

		 		 
		 if(  getExistingUser.getUserId() == user.getUserId() ) {
		System.out.println(	"To check userid -----"+ getExistingUser.getUserId());
			 throw new UserAlreadyPresentException("603", "This User is Already Present in the Database, Kindly change your UserId");
		 }
		
		User newUser =  User.builder().userId(user.getUserId())
				.email(user.getEmail())
				.password(user.getPassword())
				.phoneNo(user.getPhoneNo())
				.build();
		
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
//		newUser.setUserId(user.getUserId());
//		newUser.setEmail(user.getEmail());
//		newUser.setPassword(user.getPassword());
//		newUser.setPhoneNo(user.getPhoneNo());
		
		userRepo.save(newUser);
		
		return "User Has been created Successfully"+newUser.getPassword();
		
	}

	
	
	@Override
	public String verifyUser(User user) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(),user.getPassword()));
		
		if(authentication.isAuthenticated()) {
			
			
			String token = jwtService.generateToken(user.getUserId());
			return token;
		}
		return "User Auntication failed";
	}

}
