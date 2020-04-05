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
import org.springframework.web.bind.annotation.RequestParam;
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
	public Optional<Result> getResultsById(@PathVariable("id") int studentId) {
		return resultService.findResultsById(studentId);
	}
	
	@GetMapping("/getResultByName/{name}")
	public List<Result> getResultByName(@PathVariable("name")String studentName) {
		return resultService.findResultByName(studentName);
	}
	
	@PutMapping("/updateResult")
	public Result updateResults(@RequestBody Result result) {
		return resultService.updateResults(result);
	}
	
	@DeleteMapping("/deleteResult/{id}")
	public Optional<Result> deleteResults(@PathVariable("id") int studentId) {
		return resultService.delete(studentId);
	}
	
	@GetMapping("/getResultForStandardAndStudentName")
	public List<Result> getResultForStandardAndStudentName(@RequestParam("standard") int standard,
															@RequestParam("studentName") String studentName) {
		return resultService.findResultByStandardStudentName(standard, studentName);
	}
	
}
