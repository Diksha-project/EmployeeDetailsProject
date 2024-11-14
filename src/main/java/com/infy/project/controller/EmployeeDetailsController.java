package com.infy.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.infy.project.custom.exception.NoSuchElementException;

import com.infy.project.entity.Employee;
import com.infy.project.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeDetailsController {
	
	@Autowired
	private EmployeeService employeeService;
	
//	https://covid-193.p.rapidapi.com/countries
	//https://weatherapi-com.p.rapidapi.com/current.json?q=53.1%2C-0.13
	
	@GetMapping("/")
	 String getHello(){
		

		 return "This  controller  code is from divyanshu to test git ";

		
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> showEmployeeDetails(){
	
		List<Employee> employees = employeeService.getEmployee();
		

		 return ResponseEntity.ok(employees);
		
	}
	
	
	@PostMapping("/")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
		
	System.out.println(	emp.getName());
		String str = employeeService.addEmployee(emp);
		return ResponseEntity.ok(str);
	}
	
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> findByEmployeeId(@PathVariable String empId){
		
		Employee emp = employeeService.getByEmpId(empId);
//		if(emp == null) {
//			throw new NoSuchElementException();
//		}
		
		return ResponseEntity.ok(emp);
	}

}
