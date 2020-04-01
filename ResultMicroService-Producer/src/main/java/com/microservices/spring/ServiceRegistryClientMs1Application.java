package com.microservices.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableEurekaClient
@EnableSwagger2
public class ServiceRegistryClientMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryClientMs1Application.class, args);
	}

}
