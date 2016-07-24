package com.ac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages={"com.ac.controller"})
@EnableAutoConfiguration
@Import(WebConfig.class)
public class MyRoomApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(MyRoomApplication.class);
	}

	public static void main(String[] args) {
		System.getenv("JDBC_DATABASE_URL");
		SpringApplication.run(MyRoomApplication.class, args);
	}

	

}
