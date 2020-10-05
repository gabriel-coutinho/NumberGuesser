package com.gabrielcoutinho.numberguesser.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gabrielcoutinho.numberguesser.domain.Match;
import com.gabrielcoutinho.numberguesser.domain.Rank;
import com.gabrielcoutinho.numberguesser.dto.MatchNewDTO;
import com.gabrielcoutinho.numberguesser.repositories.MatchRepository;
import com.gabrielcoutinho.numberguesser.repositories.RankRepository;
import com.gabrielcoutinho.numberguesser.services.exceptions.ObjectNotFoundException;

@Service
public class MatchService {
	
	@Autowired
	private MatchRepository matchRepo;

	@Autowired
	private RankRepository rankRepo;

	public Match matchById(Integer id) {
		Optional<Match> obj = matchRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Match.class.getName()));
	}
	
	public Page<Match> finishPlayer(String player, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy.split(","));
		Match bestMatch= matchRepo.getBestMatchs(player).get(0);
		Rank rank = new Rank();
		rank.setMatch(bestMatch);
		bestMatch.setRank(rank);
		rankRepo.save(rank);
		matchRepo.save(bestMatch);
		return matchRepo.getMatchsByName(player, pageRequest);
	}

	public Match insert(Match obj) {
		return matchRepo.save(obj);
	}
	
	public boolean playerUnavailable(String player) {
		return !matchRepo.getPlayer(player).isEmpty();
	}

	public Page<Match> getRank(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy.split(","));
		List<Integer> idsRank = rankRepo.findAll().stream().map(obj -> obj.getMatch().getId()).collect(Collectors.toList());
		return matchRepo.getRank(idsRank, pageRequest);
	}

	public Match fromNewDto(MatchNewDTO objDto) {
		return new Match(objDto.getPlayer(), objDto.getAttemptsNum(),  objDto.getMatchNum(), objDto.getTimeStart(), objDto.getTimeFinish());
	}

}
