package com.microservices.spring.eurekaClient.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int studentId;
	int standard;
	String studentName;
	int physicsMarks;
	int chemistryMarks;
	int mathsMarks;
	float percentage;
	String result;
}
