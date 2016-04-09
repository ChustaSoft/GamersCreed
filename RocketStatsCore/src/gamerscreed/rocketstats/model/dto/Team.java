package gamerscreed.rocketstats.model.dto;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the teams database table.
 * 
 */
@Entity
@Table(name="teams")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="teamLocal")
	private List<Match> matchesLocal;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="teamVisitant")
	private List<Match> matchesVisitant;
	
	//bi-directional many-to-many association to Player
	@ManyToMany
	@JoinTable(
		name="teams_players"
		, joinColumns={
			@JoinColumn(name="id_team")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_player")
			}
		)
	private List<Player> players;

	public Team() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Match> getMatches() {
		List<Match> tmpAllMatches = new ArrayList<Match>();
		tmpAllMatches.addAll(matchesLocal);
		tmpAllMatches.addAll(matchesVisitant);
		
		return tmpAllMatches;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}