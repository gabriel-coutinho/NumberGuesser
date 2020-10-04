package com.gabrielcoutinho.numberguesser.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String player;
	private Integer attemptsNum;
	private Integer matchNum;
	private Long time;
	
	public Match() {
	}

	public Match(String player, Integer attemptsNum, Integer matchNum, Long time) {
		super();
		this.player = player;
		this.attemptsNum = attemptsNum;
		this.matchNum = matchNum;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
