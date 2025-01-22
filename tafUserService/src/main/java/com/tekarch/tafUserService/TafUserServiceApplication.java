package com.tekarch.tafUserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TafUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TafUserServiceApplication.class, args);
	}

}
