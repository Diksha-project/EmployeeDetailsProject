package com.infy.project.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.project.entity.Employee;
import com.infy.project.repo.EmployeeRepo;

@SpringBootTest
public class EmployeeServiceImplTest {
	
	
	@InjectMocks
	EmployeeServiceImpl empService;
	
	@Mock
	EmployeeRepo employeeRepo;
	
	
	
	@Test
    void getByEmpIdTest() {
	
		when(employeeRepo.findByEmpId("10001")).thenReturn(createEmployeeStub());
	  Employee empTested =   empService.getByEmpId("10001");
	  
	  assertEquals(empTested.getName(), "Sreeja");

    }

	private Optional<Employee> createEmployeeStub() {
		// TODO Auto-generated method stub
		
		Employee empStub = Employee.builder().empId("10001").name("Sreeja").build();
		return Optional.of(empStub);
	}
}
