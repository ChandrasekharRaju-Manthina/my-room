package com.ac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ac.controller", "com.ac.repository" })
@EnableAutoConfiguration
@Import(WebConfig.class)
public class MyRoomApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyRoomApplication.class);
	}

	// @Bean
	// CommandLineRunner init(final ExpenseRepository expeenseRepository) {
	// return new CommandLineRunner() {
	// @Override
	// public void run(String... strings) throws Exception {
	// Expense expense = new Expense();
	// expense.setOwner("Anil");
	// expense.setSpentDate(LocalDate.now());
	// expense.setCost(new BigDecimal("250"));
	//
	// expeenseRepository.save(expense);
	// }
	// };
	//
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyRoomApplication.class, args);
	}

}
