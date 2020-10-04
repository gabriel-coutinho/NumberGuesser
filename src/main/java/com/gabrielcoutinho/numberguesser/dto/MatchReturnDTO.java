package com.gabrielcoutinho.numberguesser.dto;

import java.io.Serializable;

import com.gabrielcoutinho.numberguesser.domain.Match;

public class MatchReturnDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String player;
	private Integer attemptsNum;
	private Integer matchNum;
	private String time;
	
	public MatchReturnDTO() {
	}
	
	public MatchReturnDTO(Match obj) {
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
