package com.codequality.sample.sydneyzamoranos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.codequality.sample.sydneyzamoranos.todo.*")
@EnableJpaRepositories(basePackages = "com.codequality.sample.sydneyzamoranos.todo.*")
@EntityScan(basePackages = "com.codequality.sample.sydneyzamoranos.todo.*")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
