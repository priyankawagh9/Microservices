package com.microservices.spring.eurekaClient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.spring.eurekaClient.model.Result;
import java.lang.String;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
	List<Result> findByStudentName(String studentname);
	
	@Query("select r from Result r where r.standard = :standard and r.studentName = :studentName")
	List<Result> findByStandardAndStudentName(@Param("standard") int standard, 
												@Param("studentName") String studentName);
}
