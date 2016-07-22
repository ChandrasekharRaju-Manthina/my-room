package com.ac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ac.controller", "com.ac.model", "com.ac.repository" })
@Configuration
@EnableAutoConfiguration
public class MyRoomApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyRoomApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyRoomApplication.class);
	}

}
