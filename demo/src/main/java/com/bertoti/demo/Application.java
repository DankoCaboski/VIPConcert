package com.bertoti.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bertoti.demo.models.User;
import com.bertoti.demo.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		inicializacao.seed();
		System.out.println("Server is runing");

		Collection<User> users = new ArrayList<>();
		User user = new User();
		user.setName("teste");
		user.setPassword("teste");
		users.add(user);

		User userAdm = new User();
		userAdm.setName("admin");
		userAdm.setPassword("admin");
		users.add(userAdm);

		UserRepository.users.addAll(users);
	}
}
