package com.ibm.tomasberus.ibmCurrencyConverter.aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.tomasberus.ibmCurrencyConverter.service.CurrencyService;

@SpringBootApplication(scanBasePackages = { "com" })
@EnableAutoConfiguration
@EntityScan(basePackages = { "com" })
@EnableJpaRepositories(basePackages = { "com" })
public class IbmCurrencyConverterApplication {
	@Autowired
	CurrencyService currencyService;

	public static void main(String[] args) {
		SpringApplication.run(IbmCurrencyConverterApplication.class, args);

	}

	public void run(String... args) throws Exception {
		
	}

}
