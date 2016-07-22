package com.ac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.sun.glass.ui.Application;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ac.controller", "com.ac.model",
		"com.ac.repository" })
@EnableAutoConfiguration
public class MyRoomApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(MyRoomApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MyRoomApplication.class, args);
	}

}
