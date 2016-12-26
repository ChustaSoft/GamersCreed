package gamerscreed.rocketstats.components;

import java.util.UUID;;

public class UserSessionObject {

	private String userName;
	private UUID sessionId;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UUID getSessionId() {
		return sessionId;
	}

	public void setSessionId(UUID sessionId) {
		this.sessionId = sessionId;
	}
	
}
