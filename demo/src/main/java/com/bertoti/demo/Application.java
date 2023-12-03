package com.bertoti.demo;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.crypto.Data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bertoti.demo.infra.dataSeeder.DataSeeder;
import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		DataSeeder.seedAll();
		System.out.println("Server is runing");


	}
}
