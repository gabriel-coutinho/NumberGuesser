package com.gabrielcoutinho.numberguesser.dto;

import java.io.Serializable;

public class PlayerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String player;
	
	public PlayerDTO() {
	}

	public PlayerDTO(String player) {
		super();
		this.player = player;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}
