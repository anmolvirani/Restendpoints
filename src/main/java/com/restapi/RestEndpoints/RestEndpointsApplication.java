package com.restapi.RestEndpoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.restapi")
@SpringBootApplication
public class RestEndpointsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEndpointsApplication.class, args);
		
		
		
	}

}
