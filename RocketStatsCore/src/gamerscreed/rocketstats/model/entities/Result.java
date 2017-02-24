package gamerscreed.rocketstats.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the results database table.
 * 
 */
@Entity
@Table(name="results")
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int assits;

	private int goals;

	private byte mvp;

	private int points;

	private int safes;

	private int shots;

	private byte winner;

	//bi-directional many-to-one association to MatchResultPlayer
	@OneToMany(mappedBy="result")
	private List<MatchResultPlayer> matchResultPlayers;

	public Result() {
		this.assits = 0;
		this.goals = 0;
		this.mvp = 0;
		this.points = 0;
		this.safes = 0;
		this.shots = 0;
		this.winner = 0;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAssits() {
		return this.assits;
	}

	public void setAssits(int assits) {
		this.assits = assits;
	}

	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public byte getMvp() {
		return this.mvp;
	}

	public void setMvp(byte mvp) {
		this.mvp = mvp;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getSafes() {
		return this.safes;
	}

	public void setSafes(int safes) {
		this.safes = safes;
	}

	public int getShots() {
		return this.shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	public boolean isWinner() {
		if(this.winner == 0)
			return false;
		else return true;
	}

	public void setWinner(boolean isWinner) {
		if(isWinner)
			this.winner = (byte) 1;
		else
			this.winner = 0;
	}

	public List<MatchResultPlayer> getMatchResultPlayers() {
		return this.matchResultPlayers;
	}

	public void setMatchResultPlayers(List<MatchResultPlayer> matchResultPlayers) {
		this.matchResultPlayers = matchResultPlayers;
	}

	public MatchResultPlayer addMatchResultPlayer(MatchResultPlayer matchResultPlayer) {
		getMatchResultPlayers().add(matchResultPlayer);
		matchResultPlayer.setResult(this);

		return matchResultPlayer;
	}

	public MatchResultPlayer removeMatchResultPlayer(MatchResultPlayer matchResultPlayer) {
		getMatchResultPlayers().remove(matchResultPlayer);
		matchResultPlayer.setResult(null);

		return matchResultPlayer;
	}

}