package com.bertoti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bertoti.demo.infra.dataSeeder.DataSeeder;

@SpringBootApplication
public class app {

	public static void main(String[] args) {
		SpringApplication.run(app.class, args);
		DataSeeder.seedAll();
		System.out.println("Server is runing");
	}
}