package com.infy.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.project.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, String>{

	

}
