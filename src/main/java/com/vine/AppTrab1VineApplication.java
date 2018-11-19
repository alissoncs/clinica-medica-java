package com.vine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppTrab1VineApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppTrab1VineApplication.class, args); 
	}
}
