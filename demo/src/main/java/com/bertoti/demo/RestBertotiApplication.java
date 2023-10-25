package com.bertoti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestBertotiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestBertotiApplication.class, args);
		System.out.println("Server runing");
	}
}
