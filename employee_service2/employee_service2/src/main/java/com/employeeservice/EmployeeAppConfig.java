package com.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {

  @Value("${addressservice.base.url}")
  private String addressBaseUrl;
  
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
	
	@Bean
	public WebClient webClient()
	{
		return WebClient
				.builder()
				.baseUrl(addressBaseUrl)
				.build();
	}
	
}
