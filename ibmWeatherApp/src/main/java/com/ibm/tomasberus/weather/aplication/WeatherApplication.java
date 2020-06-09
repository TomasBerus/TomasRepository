package com.ibm.tomasberus.weather.aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.ibm.tomasberus.weather.service.WeatherService;

@SpringBootApplication(scanBasePackages = { "com" })
@EnableAutoConfiguration
@EntityScan(basePackages = { "com" })
@EnableJpaRepositories(basePackages = { "com" })
public class WeatherApplication implements CommandLineRunner {

	@Autowired
	WeatherService weatherService;

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);

	}

	public void run(String... args) throws Exception {
		
		

	}
		
}
