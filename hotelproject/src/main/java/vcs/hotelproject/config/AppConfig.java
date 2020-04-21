package vcs.hotelproject.config;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;

import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan

@ComponentScan("vcs")
@EntityScan(basePackages = {"vcs"})
public class AppConfig {
	@Bean
	public PhysicalNamingStrategy physical() {
	    return new PhysicalNamingStrategyStandardImpl();
	}
	
	}
    

  