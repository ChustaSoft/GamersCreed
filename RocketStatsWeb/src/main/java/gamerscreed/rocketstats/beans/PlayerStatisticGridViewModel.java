package gamerscreed.rocketstats.beans;

public class PlayerStatisticGridViewModel {

	private String userName;
	private int position;
	private int matchesWon;
	private int matchesLost;
	private int goalsFor;
	private int goalsAgainst;
	private int points;
	
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getMatchesWon() {
		return matchesWon;
	}
	
	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}
	
	public int getMatchesLost() {
		return matchesLost;
	}
	
	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}
	
	public int getGoalsFor() {
		return goalsFor;
	}
	
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}
	
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
}
