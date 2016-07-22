package com.ac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ac.controller", "com.ac.model", "com.ac.repository" })
public class MyRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRoomApplication.class, args);
	}

}
