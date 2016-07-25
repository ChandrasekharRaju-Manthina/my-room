package com.ac.config;

import com.ac.model.Expense;
import com.ac.repository.ExpenseRepository;
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
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ac.controller", "com.ac.model", "com.ac.repository"})
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

            Expense expense2 = new Expense();
            expense2.setOwner("Chandra");
            expense2.setSpentDate(LocalDate.now());
            expense2.setCost(new BigDecimal("300"));
            expeenseRepository.save(expense2);
        };
    }

    @Profile("local")
    @Bean(destroyMethod = "shutdown")
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyRoomApplication.class, args);
    }

}
