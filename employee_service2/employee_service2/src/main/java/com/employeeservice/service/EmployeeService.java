package com.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employeeservice.feignclient.AddressClient;
import com.employeeservice.model.Employee;
import com.employeeservice.repo.EmployeeRepo;
import com.employeeservice.response.AddressResponse;
import com.employeeservice.response.EmployeeResponse;

@Service
public class EmployeeService {
     
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private AddressClient addressClient;
	
//	@Autowired
  private RestTemplate restTemplate;
	

	
	public EmployeeResponse getEmployeeDetailsById(int id)	
	
	{
	   Employee emp=employeeRepo.findById(id).get();
	   EmployeeResponse employeeResponse = modelMapper.map(emp, EmployeeResponse.class);
	   
	   AddressResponse addressResponse=addressClient.getAddressByEmployeeId(id);
			                   
	 employeeResponse.setAddressResponse(addressResponse);
	   return employeeResponse;
	}
}
