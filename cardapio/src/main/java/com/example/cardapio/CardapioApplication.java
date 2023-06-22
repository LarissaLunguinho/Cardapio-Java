package com.example.cardapio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CardapioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardapioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
		return (args) -> {
			int rowCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM foods", Integer.class);
			System.out.println("Connection to the database established successfully!");
			System.out.println("Number of rows in the table: " + rowCount);
		};
	}

}
