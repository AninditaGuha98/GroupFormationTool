package com.example.Milestone1Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Milestone1TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Milestone1TestApplication.class, args);
	}

}
