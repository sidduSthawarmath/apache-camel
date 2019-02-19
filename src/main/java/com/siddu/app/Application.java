package com.siddu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.siddu.config.CsvFileProcessor;
import com.siddu.config.StudentFieldSetMapper;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.siddu")
@EntityScan("com.siddu")
@EnableJpaRepositories("com.siddu")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CsvFileProcessor csvFileProcessor() {
		return new CsvFileProcessor();
	}

	@Bean
	public StudentFieldSetMapper studentFieldSetMapper() {
		return new StudentFieldSetMapper();
	}

}
