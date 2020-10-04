package com.gabrielcoutinho.numberguesser.domain;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String player;
	
	@OneToOne(mappedBy = "match")
	private Rank rank;
	
	
	private Integer attemptsNum;
	private Integer matchNum;
	private Long timeStart;
	private Long timeFinish;
	private Long timeSecs;
	
	public Match() {
	}

	public Match(String player, Integer attemptsNum, Integer matchNum, Long timeStart, Long timeFinish) {
		super();
		this.player = player;
		this.attemptsNum = attemptsNum;
		this.matchNum = matchNum;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
		this.generateTimeSecs(timeStart, timeFinish);
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
	
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public void generateTimeSecs(Long timeStart, Long timeFinish) {
		Long diffLong = timeFinish - timeStart;
		this.timeSecs = TimeUnit.MILLISECONDS.toSeconds(diffLong);
		
	}
	
	public String getTime() {
		Long diffLong = timeFinish - timeStart;
		Long minutes = TimeUnit.MILLISECONDS.toMinutes(diffLong);
		Long seconds = TimeUnit.MILLISECONDS.toSeconds(diffLong) - (minutes * 60);
		
		StringBuilder diff = new StringBuilder();
		diff.append(minutes.toString()).append("m");
		diff.append(seconds.toString()).append("s");
		return diff.toString();
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

	public Long getTimeSecs() {
		return timeSecs;
	}
}
