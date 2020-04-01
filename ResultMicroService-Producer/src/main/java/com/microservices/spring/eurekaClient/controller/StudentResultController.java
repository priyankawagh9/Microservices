package com.microservices.spring.eurekaClient.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.spring.eurekaClient.model.Result;
import com.microservices.spring.eurekaClient.service.ResultService;

@RestController("/result")
public class StudentResultController {
	
	@Autowired
	private ResultService resultService;
	
	@GetMapping("/getResults")
	public List<Result> getResults() {
		return resultService.findResults();
	}
	
	@PostMapping("/setResult")
	public Result postResult(@RequestBody Result result) {
		return resultService.save(result);
	}
	
	@GetMapping("/getResult/{id}")
	public Optional<Result> getResultsById(@PathVariable int studentId) {
		return resultService.findResultsById(studentId);
	}
	
	@PutMapping("/updateResult")
	public Result updateResults(@RequestBody Result result) {
		return resultService.updateResults(result);
	}
	
	@DeleteMapping("/deleteResult/{id}")
	public Optional<Result> deleteResults(@PathVariable int studentId) {
		return resultService.delete(studentId);
	}
	
}
