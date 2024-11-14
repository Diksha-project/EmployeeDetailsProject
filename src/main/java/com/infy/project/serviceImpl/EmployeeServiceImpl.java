package com.infy.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.infy.project.custom.exception.NoSuchElementException;
import com.infy.project.entity.Address;
import com.infy.project.entity.Employee;
import com.infy.project.repo.EmployeeRepo;
import com.infy.project.service.EmployeeService;


@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepo    employeeRepo;

	@Override
	public List<Employee> getEmployee() {
	List<Employee> employeeList = 	employeeRepo.findAll();
		
		return employeeList;
	}

	@Override
	public String addEmployee(Employee emp) {
		
		  if (emp.getAddress() != null) {
			  
			  
		        for (Address address : emp.getAddress()) {
		            address.setEmployee(emp);
		        }
		    }
		  
		 employeeRepo.save(emp);
		return "New Employee has been added successfully";
	}

	@Override
	public Employee getByEmpId(String empid) {
		// TODO Auto-generated method stub
		 Optional<Employee> empOptional = employeeRepo.findByEmpId(empid);
		 
		 if(empOptional.isEmpty()) {
			 throw new NoSuchElementException("EMP_NOT_FOUND", "This element is not present in our database: " + empid);
			    
		
		 
	}
		 Employee emp = empOptional.get();
		 return emp;
	}
	
}
