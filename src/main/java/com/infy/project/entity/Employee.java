package com.infy.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infy.project.entity.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name =  "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-incremented primary key
    private Long  id;
	
	
	@Column(name = "emp_id",unique = true) // Maps to specific column in the table
	private String  empId;
	
	@Column(name = "name")
	private String  name;
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Address> address;
	
	

}
