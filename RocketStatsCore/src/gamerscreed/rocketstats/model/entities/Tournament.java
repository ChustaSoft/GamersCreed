package gamerscreed.rocketstats.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import gamerscreed.rocketstats.model.dao.annotations.AtLeastOneNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tournaments database table.
 * 
 */
@Entity
@Table(name="tournaments")
@NamedQuery(name="Tournament.findAll", query="SELECT t FROM Tournament t")
public class Tournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Match
	@AtLeastOneNotNull
	@OneToMany(mappedBy="tournament")
	private List<Match> matches;

	//uni-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="id_winner")
	private Player winner;

	public Tournament() { }
	
	public Tournament(Date aStartDate){
		startDate = aStartDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Match> getMatches() {
		if(this.matches == null)
			this.matches = new ArrayList<Match>();
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setTournament(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setTournament(null);

		return match;
	}

	public Player getWinner() {
		return this.winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

}