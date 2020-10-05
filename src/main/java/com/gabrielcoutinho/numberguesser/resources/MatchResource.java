package com.gabrielcoutinho.numberguesser.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabrielcoutinho.numberguesser.domain.Match;
import com.gabrielcoutinho.numberguesser.dto.MatchNewDTO;
import com.gabrielcoutinho.numberguesser.dto.MatchReturnDTO;
import com.gabrielcoutinho.numberguesser.services.MatchService;

@RestController
@RequestMapping(value="/matchs")
public class MatchResource {
	
	@Autowired
	private MatchService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Match obj = service.matchById(id);
		MatchReturnDTO matchDto = new MatchReturnDTO(obj);
		return ResponseEntity.ok(matchDto);
	}
	
	@RequestMapping(value="/unavailable", method=RequestMethod.GET)
	public ResponseEntity<?> isUnavailable(@RequestParam(value="player") String player) {
		System.out.println(player);
		boolean isUnavailable = service.playerUnavailable(player);
		return ResponseEntity.ok().body(isUnavailable);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody MatchNewDTO objDto) {
		Match obj = service.fromNewDto(objDto);
		obj = service.insert(obj);
		MatchReturnDTO matchDto = new MatchReturnDTO(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(matchDto);
	}
	
	@RequestMapping(value="/finish", method=RequestMethod.GET)
	public ResponseEntity<?> finish(@RequestParam(value="player") String player,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="attemptsNum,timeStart") String orderBy,
			@RequestParam(value="direction", defaultValue="DESC") String direction
			) {
		Page<Match> playerMatchs = service.finishPlayer(player, page, linesPerPage, orderBy, direction);
		Page<MatchReturnDTO> playerMatchsDto = playerMatchs.map(obj -> new MatchReturnDTO(obj));
		return ResponseEntity.ok(playerMatchsDto);
	}
	
	@RequestMapping(value="/rank", method=RequestMethod.GET)
	public ResponseEntity<Page<MatchReturnDTO>> getRank(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="attemptsNum,timeStart") String orderBy,
			@RequestParam(value="direction", defaultValue="DESC") String direction
			) {
		Page<Match> rank = service.getRank(page, linesPerPage, orderBy, direction);
		Page<MatchReturnDTO> rankDto = rank.map(obj -> new MatchReturnDTO(obj));
		return ResponseEntity.ok(rankDto);
	}
}
