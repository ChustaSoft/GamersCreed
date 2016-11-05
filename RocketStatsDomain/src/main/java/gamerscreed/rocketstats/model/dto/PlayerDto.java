package gamerscreed.rocketstats.model.dto;

public class PlayerDto {

	private String username;
	
	private String password;

	
	public PlayerDto() { }
	
	public PlayerDto(Player aPlayer) {
		this.username = aPlayer.getUsername();
		this.password = aPlayer.getPassword();
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
