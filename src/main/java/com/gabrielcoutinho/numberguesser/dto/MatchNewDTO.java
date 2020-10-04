package com.gabrielcoutinho.numberguesser.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.gabrielcoutinho.numberguesser.domain.Match;

public class MatchNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String player;
	
	private Integer attemptsNum;
	private Integer matchNum;
	private Long timeStart;
	private Long timeFinish;
	
	public MatchNewDTO() {
	}
	
	public MatchNewDTO(Match obj) {
		this.player = obj.getPlayer();
		this.attemptsNum = obj.getAttemptsNum();
		this.matchNum = obj.getMatchNum();
		this.timeStart = obj.getTimeStart();
		this.timeFinish = obj.getTimeFinish();
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

	public Long getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Long timeStart) {
		this.timeStart = timeStart;
	}

	public Long getTimeFinish() {
		return timeFinish;
	}

	public void setTimeFinish(Long timeFinish) {
		this.timeFinish = timeFinish;
	}
}
