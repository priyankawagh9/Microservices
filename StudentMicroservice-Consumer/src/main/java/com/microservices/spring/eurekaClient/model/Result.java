package com.microservices.spring.eurekaClient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
	int studentId;
	int standard;
	String StudentName;
	int physicsMarks;
	int chemistryMarks;
	int mathsMarks;
	float percentage;
	String result;
}
