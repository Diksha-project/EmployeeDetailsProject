package com.infy.project.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.infy.project.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository <Employee, Long>{
    
	
	
	 Optional<Employee>  findByEmpId(String empid);

}
