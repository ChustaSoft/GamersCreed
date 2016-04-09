package gamerscreed.rocketstats.model.dto;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the match_result_player database table.
 * 
 */
@Embeddable
public class MatchResultPlayerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_match", insertable=false, updatable=false)
	private int idMatch;

	@Column(name="id_result", insertable=false, updatable=false)
	private int idResult;

	@Column(name="id_player", insertable=false, updatable=false)
	private int idPlayer;

	public MatchResultPlayerPK() {
	}
	public int getIdMatch() {
		return this.idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	public int getIdResult() {
		return this.idResult;
	}
	public void setIdResult(int idResult) {
		this.idResult = idResult;
	}
	public int getIdPlayer() {
		return this.idPlayer;
	}
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MatchResultPlayerPK)) {
			return false;
		}
		MatchResultPlayerPK castOther = (MatchResultPlayerPK)other;
		return 
			(this.idMatch == castOther.idMatch)
			&& (this.idResult == castOther.idResult)
			&& (this.idPlayer == castOther.idPlayer);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idMatch;
		hash = hash * prime + this.idResult;
		hash = hash * prime + this.idPlayer;
		
		return hash;
	}
}