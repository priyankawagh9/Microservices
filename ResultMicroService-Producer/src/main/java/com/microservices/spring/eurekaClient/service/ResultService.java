package com.microservices.spring.eurekaClient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.spring.eurekaClient.model.Result;
import com.microservices.spring.eurekaClient.repository.ResultRepository;

@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepository;
	
	public List<Result> findResults() {
		return resultRepository.findAll();
	}

	public Result save(Result result) {
		return resultRepository.save(result);
	}

	public Optional<Result> findResultsById(int studentId) {
		return resultRepository.findById(studentId);
	}

	public Result updateResults(Result result) {
		return resultRepository.save(result);
	}

	public Optional<Result> delete(int studentId) {
		if(resultRepository.existsById(studentId))
		{	
			Optional<Result> result = resultRepository.findById(studentId);
			resultRepository.deleteById(studentId);
			return result;
		}
		return null;
	}

	public List<Result> findResultByName(String studentName) {
		return resultRepository.findByStudentName(studentName);
	}

	public List<Result> findResultByStandardStudentName(int standard, String studentName) {
		return resultRepository.findByStandardAndStudentName(standard, studentName);
	}
	
}
