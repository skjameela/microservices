package com.employeeservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employeeservice.response.AddressResponse;

//http://localhost:8080/address-app/api/address/1

@FeignClient(name="abc",url="http://localhost:8080/address-app/api")
public interface AddressClient {
	
	  @GetMapping("/address/{id}")
    AddressResponse  getAddressByEmployeeId(@PathVariable("id") int id);
 
}
