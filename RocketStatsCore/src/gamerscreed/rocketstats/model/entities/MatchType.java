package gamerscreed.rocketstats.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the match_types database table.
 * 
 */
@Entity
@Table(name="match_types")
@NamedQuery(name="MatchType.findAll", query="SELECT m FROM MatchType m")
public class MatchType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="matchType")
	private List<Match> matches;

	public MatchType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setMatchType(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setMatchType(null);

		return match;
	}

}