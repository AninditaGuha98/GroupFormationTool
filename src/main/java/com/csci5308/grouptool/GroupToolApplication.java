package com.csci5308.grouptool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GroupToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupToolApplication.class, args);
    }

}
