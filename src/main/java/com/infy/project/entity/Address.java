package com.infy.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long  Id;
	
	@Column(name = "address_id")
	private String addressId;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pin")
	private String pin;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	
	@ManyToOne
	@JoinColumn(name = "employee_id",  referencedColumnName = "emp_id") 
	@JsonBackReference 
	private Employee employee;
	

}

// one to one
// one to many 
//many to one
