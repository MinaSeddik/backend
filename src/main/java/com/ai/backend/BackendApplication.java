package com.ai.backend;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner test(DataSource dataSource) {
		return args -> {
			try (var connection = dataSource.getConnection()) {
				System.out.println("Connected to: " + connection.getMetaData().getURL());
			}
		};
	}

}
