package com.gabrielcoutinho.numberguesser;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielcoutinho.numberguesser.domain.Match;
import com.gabrielcoutinho.numberguesser.repositories.MatchRepository;

@SpringBootApplication
public class NumberguesserApplication implements CommandLineRunner{

	@Autowired
	private MatchRepository partidaRepository;

	public static void main(String[] args) {
		SpringApplication.run(NumberguesserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Match m1 = new Match("Gabriel", 8, 1, 12L);
		Match m2 = new Match("Lucas", 16, 1, 15L);
		Match m3 = new Match("Zé Carlos", 22, 1, 25L);
		Match m4 = new Match("Junior", 15, 1, 19L);
		Match m5 = new Match("Rafael", 9, 1, 10L);
		Match m6 = new Match("Marcos", 8, 1, 10L);
		Match m7 = new Match("Pedro", 8, 1, 19L);
		Match m8 = new Match("Guilherme", 9, 1, 16L);
		Match m9 = new Match("Guilherme", 16, 2, 10L);
		Match m10 = new Match("Guilherme", 24, 3, 35L);
		
		partidaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10));
	}

}
