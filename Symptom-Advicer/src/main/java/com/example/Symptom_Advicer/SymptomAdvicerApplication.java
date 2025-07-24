package com.example.Symptom_Advicer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.example.Symptom_Advicer.repository")
public class SymptomAdvicerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SymptomAdvicerApplication.class, args);
	}
}
