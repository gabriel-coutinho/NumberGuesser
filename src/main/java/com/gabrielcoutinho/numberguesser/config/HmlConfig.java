package com.gabrielcoutinho.numberguesser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabrielcoutinho.numberguesser.services.DBService;

@Configuration
@Profile("hml")
public class HmlConfig {
	
	@Autowired
	private DBService dBService;

	@Bean
	public boolean instantiateDatabase() {
		dBService.instantiateHmlDatabase();
		return true;
	}

}
