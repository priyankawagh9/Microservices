package com.microservices.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.spi.http.HttpHandler;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.microservices.spring.eurekaClient.model.Result;

@RestController
public class StudentController {
	
	//RestTemplate: getForEntity()  //Output: ResponseEntity.
	@GetMapping("/getResultsUsingGetForEntity")
	public List<Result> getResult() {
		String url="http://localhost:8082/getResults";
		RestTemplate restTemplate = new RestTemplate();	
		ResponseEntity<List> result = restTemplate.getForEntity(url, List.class); //getForEntity Method of RestTemplate
		return result.getBody();
	}
	
	//RestTemplate: getForEntity
	@GetMapping("/getResultforGivenStandardAndName/{standard}/{studentName}")
	public List<Result> getResultByStardardAndName(@PathVariable("standard") int standard,
													@PathVariable("studentName") String studentName) {
		//Build URL using URIBUILDER:
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port("8082")
				.path("/getResultForStandardAndStudentName")
				.queryParam("standard", standard)
				.queryParam("studentName", studentName)
				.build()
				.encode();		
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(uriComponents.toString(), List.class);
		return responseEntity.getBody();
	} 

	//RestTemplate: getForObject()  //Output: entity
	@GetMapping("/getResultUsingGetForObject/{id}")
	public Optional<Result> getResult(@PathVariable("id") int studentId) {
		String url = "http://localhost:8082/getResult/"+studentId;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, Optional.class); //getForObject 
	}
	
	//RestTemplate: exchange()  //output: ResponseEntity
	@GetMapping("/getResultUsingExchange/{studentName}")
	public List<Result> getResultByStudentName(@PathVariable("studentName") String studentName) {
		String url = "http://localhost:8082/getResultByName/"+studentName;
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity requestEntity = new HttpEntity<>("", httpHeaders);
		
		ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, List.class);
		return responseEntity.getBody();
	}
	

	
}
