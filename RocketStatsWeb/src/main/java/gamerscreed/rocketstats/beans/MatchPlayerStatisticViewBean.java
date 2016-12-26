package gamerscreed.rocketstats.beans;

public class MatchPlayerStatisticViewBean {

	private int playerId;
	private String userName;
	private int goals;
	private int safes;
	private int shots;
	private boolean mvp;
	private boolean winner;
	
	
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getGoals() {
		return goals;
	}
	
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	public int getSafes() {
		return safes;
	}
	
	public void setSafes(int safes) {
		this.safes = safes;
	}
	
	public int getShots() {
		return shots;
	}
	
	public void setShots(int shots) {
		this.shots = shots;
	}
	
	public boolean isMvp() {
		return mvp;
	}
	
	public void isMvp(boolean mvp) {
		this.mvp = mvp;
	}
	
	public boolean isWinner() {
		return winner;
	}
	
	public void isWinner(boolean winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return playerId + "-" + userName + "-" + goals + "-" + safes + "-" + shots + "-" + mvp + "-" + winner;
	}
}