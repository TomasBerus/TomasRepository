package com.ibm.tomasberus.ibmCurrencyConverter.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan({ "com" })
@EntityScan(basePackages = { "com" })
@EnableScheduling
@EnableAsync
public class AppConfiguration {

}
