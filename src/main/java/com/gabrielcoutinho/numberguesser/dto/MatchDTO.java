package com.gabrielcoutinho.numberguesser.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.gabrielcoutinho.numberguesser.domain.Match;

public class MatchDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String player;
	private Integer attemptsNum;
	private Integer matchNum;
	@Positive(message="Duração da partida não pode ser negativa")
	private Long time;
	
	public MatchDTO() {
	}
	
	public MatchDTO(Match obj) {
		this.player = obj.getPlayer();
		this.attemptsNum = obj.getAttemptsNum();
		this.matchNum = obj.getMatchNum();
		this.time = obj.getTime();
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Integer getAttemptsNum() {
		return attemptsNum;
	}

	public void setAttemptsNum(Integer attemptsNum) {
		this.attemptsNum = attemptsNum;
	}

	public Integer getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(Integer matchNum) {
		this.matchNum = matchNum;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
}
