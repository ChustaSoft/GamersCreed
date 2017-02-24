package gamerscreed.rocketstats.model.dto;

import gamerscreed.rocketstats.model.entities.Player;

public class PlayerDto {

	private String username;
	
	private String usertoken;

	
	public PlayerDto() { }
	
	public PlayerDto(Player aPlayer) {
		this.username = aPlayer.getUsername();
		this.usertoken = aPlayer.getToken();
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return usertoken;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.usertoken = token;
	}
	
}
