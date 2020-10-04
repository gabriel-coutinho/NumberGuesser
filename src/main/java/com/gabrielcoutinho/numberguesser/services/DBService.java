package com.gabrielcoutinho.numberguesser.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcoutinho.numberguesser.domain.Match;
import com.gabrielcoutinho.numberguesser.repositories.MatchRepository;

@Service
public class DBService {
	
	@Autowired
	private MatchRepository partidaRepository;
	
	public void instantiateHmlDatabase() {
		Match m1 = new Match("Gabriel", 8, 1, 12L, 14L);
		Match m2 = new Match("Lucas", 16, 1, 15L, 19L);
		Match m3 = new Match("Zé Carlos", 22, 1, 25L, 29L);
		Match m4 = new Match("Junior", 15, 1, 19L, 25L);
		Match m5 = new Match("Rafael", 9, 1, 10L, 13L);
		Match m6 = new Match("Marcos", 8, 1, 10L, 45L);
		Match m7 = new Match("Pedro", 8, 1, 19L, 28L);
		Match m8 = new Match("Guilherme", 9, 1, 16L, 35L);
		Match m9 = new Match("Guilherme", 16, 2, 10L, 14L);
		Match m10 = new Match("Guilherme", 24, 3, 35L, 49L);
		
		partidaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10));
	}
}
