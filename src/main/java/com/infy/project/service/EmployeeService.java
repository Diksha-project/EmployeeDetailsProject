package com.infy.project.service;

import java.util.List;

import com.infy.project.entity.Employee;

 public interface EmployeeService {
	
	public List<Employee> getEmployee();
	public  String addEmployee(Employee emp);
    public Employee getByEmpId(String empid);
}
