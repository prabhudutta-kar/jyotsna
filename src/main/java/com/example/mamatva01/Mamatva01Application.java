package com.example.mamatva01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Mamatva01Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Mamatva01Application.class);
	
	}

	public static void main(String[] args) {
		SpringApplication.run(Mamatva01Application.class, args);
	}

} 
//Hakuna mattata 