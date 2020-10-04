package com.gabrielcoutinho.numberguesser.resources;

import java.net.URI;
import java.util.List;

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
import com.gabrielcoutinho.numberguesser.dto.MatchDTO;
import com.gabrielcoutinho.numberguesser.services.MatchService;

@RestController
@RequestMapping(value="/matchs")
public class MatchResource {
	
	@Autowired
	private MatchService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Match obj = service.matchById(id);
		MatchDTO matchDto = new MatchDTO(obj);
		return ResponseEntity.ok(matchDto);
	}
	
	@RequestMapping(value="/finish", method=RequestMethod.GET)
	public ResponseEntity<?> finish() {
		List<Match> obj = service.finish();
		return ResponseEntity.ok(obj);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody MatchDTO objDto) {
		Match obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/rank", method=RequestMethod.GET)
	public ResponseEntity<Page<MatchDTO>> getRank(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="attemptsNum,time") String orderBy,
			@RequestParam(value="direction", defaultValue="DESC") String direction
			) {
		Page<Match> rank = service.getRank(page, linesPerPage, orderBy, direction);
		Page<MatchDTO> rankDto = rank.map(obj -> new MatchDTO(obj));
		return ResponseEntity.ok().body(rankDto);
	}
}
