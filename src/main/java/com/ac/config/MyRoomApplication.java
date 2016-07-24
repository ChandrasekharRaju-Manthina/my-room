package com.ac.config;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ac.model.Expense;
import com.ac.repository.ExpenseRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ac.controller", "com.ac.model", "com.ac.repository" })
@EnableAutoConfiguration
@EnableJpaRepositories("com.ac.repository")
@EntityScan("com.ac.model")
@Import(WebConfig.class)
public class MyRoomApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyRoomApplication.class);
	}

	@Bean
	public CommandLineRunner init(ExpenseRepository expeenseRepository) {
		return (args) -> {
			Expense expense = new Expense();
			expense.setOwner("Anil");
			expense.setSpentDate(LocalDate.now());
			expense.setCost(new BigDecimal("250"));
			expeenseRepository.save(expense);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MyRoomApplication.class, args);
	}

}
