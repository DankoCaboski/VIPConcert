package com.bertoti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bertoti.demo.inicializacao.inicializacao;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		inicializacao.seed();
		System.out.println("Server is runing");
	}
}
