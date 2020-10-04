package com.gabrielcoutinho.numberguesser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberguesserApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NumberguesserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
