package com.infy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.project.entity.Employee;
import com.infy.project.service.EmployeeService;

@RestController
public class EmployeeDetailsController {
	
	@Autowired
	private EmployeeService employeeService;
	
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
		
		return ResponseEntity.ok(emp);
	}

}
