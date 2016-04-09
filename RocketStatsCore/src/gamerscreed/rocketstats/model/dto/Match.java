package gamerscreed.rocketstats.model.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@Table(name="matches")
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_played")
	private Date datePlayed;

	//bi-directional many-to-one association to MatchResultPlayer
	@OneToMany(mappedBy="match")
	private List<MatchResultPlayer> matchResultPlayers;

	//bi-directional many-to-one association to MatchType
	@ManyToOne
	@JoinColumn(name="id_type")
	private MatchType matchType;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="id_team_a")
	private Team teamLocal;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="id_team_b")
	private Team teamVisitant;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="id_tournament")
	private Tournament tournament;

	public Match() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatePlayed() {
		return this.datePlayed;
	}

	public void setDatePlayed(Date datePlayed) {
		this.datePlayed = datePlayed;
	}

	public List<MatchResultPlayer> getMatchResultPlayers() {
		return this.matchResultPlayers;
	}

	public void setMatchResultPlayers(List<MatchResultPlayer> matchResultPlayers) {
		this.matchResultPlayers = matchResultPlayers;
	}

	public MatchResultPlayer addMatchResultPlayer(MatchResultPlayer matchResultPlayer) {
		getMatchResultPlayers().add(matchResultPlayer);
		matchResultPlayer.setMatch(this);

		return matchResultPlayer;
	}

	public MatchResultPlayer removeMatchResultPlayer(MatchResultPlayer matchResultPlayer) {
		getMatchResultPlayers().remove(matchResultPlayer);
		matchResultPlayer.setMatch(null);

		return matchResultPlayer;
	}

	public MatchType getMatchType() {
		return this.matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	public Team getTeamLocal() {
		return this.teamLocal;
	}

	public void setTeamLocal(Team teamLocal) {
		this.teamLocal = teamLocal;
	}

	public Team getTeamVisitant() {
		return this.teamVisitant;
	}

	public void setTeamVisitant(Team teamVisitant) {
		this.teamVisitant = teamVisitant;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}