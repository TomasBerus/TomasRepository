package com.ibm.tomasberus.weather.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan({ "com.ibm.tomasberus.weather" })
@EntityScan(basePackages = { "com" })
@EnableScheduling
public class AppConfiguration {

}
