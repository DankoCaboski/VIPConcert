package com.bertoti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bertoti.demo.infra.dataSeeder.DataSeeder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		DataSeeder.seedAll();
		System.out.println("Server is runing");


	}
}
