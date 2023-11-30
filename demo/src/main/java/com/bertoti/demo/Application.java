package com.bertoti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Server is runing");
		User user = new User();
		user.setName("teste");
		user.setPassword("teste");
		UserRepository.users.add(user);
	}
}
