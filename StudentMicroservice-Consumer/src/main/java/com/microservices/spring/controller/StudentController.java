package com.microservices.spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.spring.eurekaClient.model.Result;

@RestController
public class StudentController {
	
	@GetMapping("/getResults")
	public List<Result> getResult() {
		String url="http://localhost:8082/getResults";
		RestTemplate restTemplate = new RestTemplate();	
		ResponseEntity<List> result = restTemplate.getForEntity(url, List.class); //getForEntity Method of RestTemplate
		return result.getBody();
	}
	
	@GetMapping("/getResult/")
	
}
