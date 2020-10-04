package com.gabrielcoutinho.numberguesser.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gabrielcoutinho.numberguesser.domain.Match;
import com.gabrielcoutinho.numberguesser.dto.MatchDTO;
import com.gabrielcoutinho.numberguesser.repositories.MatchRepository;
import com.gabrielcoutinho.numberguesser.services.exceptions.ObjectNotFoundException;

@Service
public class MatchService {
	
	private List<Match> currentsMatchs = new ArrayList<>();

	@Autowired
	private MatchRepository repo;

	public Match matchById(Integer id) {
		Optional<Match> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Match.class.getName()));
	}
	
	public List<Match> finish() {
		List<Match> result = currentsMatchs;
		currentsMatchs = new ArrayList<>();
		return result;
	}

	public Match insert(Match obj) {
		Match match = repo.save(obj);
		currentsMatchs.add(match);
		return match;
	}
	
	public Page<Match> getRank(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy.split(","));
		return repo.findAll(pageRequest);
	}

	public Match fromDto(MatchDTO objDto) {
		return new Match(objDto.getPlayer(), objDto.getAttemptsNum(),  objDto.getMatchNum(), objDto.getTime());
	}

}
