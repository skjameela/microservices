package com.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.response.EmployeeResponse;
import com.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {
    
	@Autowired
	private EmployeeService  employeeService;
	

	
	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable ("id") int id)
	{
//		String address=restTemplate.getForObject("http://localhost:8080/address",String.class);
//		return "Name : Jameela "+address;	
		
		EmployeeResponse employeeResponse=employeeService.getEmployeeDetailsById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}

}
