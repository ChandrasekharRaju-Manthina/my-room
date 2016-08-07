package com.ac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ac.controller", "com.ac.model", 
		"com.ac.repository", "com.ac.service" })
@EnableAutoConfiguration 
@EnableJpaRepositories("com.ac.repository")
@EntityScan("com.ac.model")
public class MyRoomApplication extends SpringBootServletInitializer {

	@Profile("local")
	@Bean(destroyMethod = "shutdown")
	public EmbeddedDatabase dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MyRoomApplication.class, args);
	}

}
