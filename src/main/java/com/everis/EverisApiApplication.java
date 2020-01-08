package com.everis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.everis.api","com.everis.dao","com.everis.service"})
public class EverisApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(EverisApiApplication.class, args);
	}
	
}