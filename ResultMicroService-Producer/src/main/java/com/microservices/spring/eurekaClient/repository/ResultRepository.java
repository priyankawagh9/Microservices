package com.microservices.spring.eurekaClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.spring.eurekaClient.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
}
