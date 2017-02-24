package gamerscreed.rocketstats.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the match_result_player database table.
 * 
 */
@Entity
@Table(name="match_result_player")
@NamedQuery(name="MatchResultPlayer.findAll", query="SELECT m FROM MatchResultPlayer m")
public class MatchResultPlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatchResultPlayerPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_date")
	private Date auditDate;

	@Column(name="audit_public_ip")
	private String auditPublicIp;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@NotNull
	@JoinColumn(name="id_match", insertable=false, updatable=false)
	private Match match;

	//bi-directional many-to-one association to Result
	@ManyToOne
	@NotNull
	@JoinColumn(name="id_result", insertable=false, updatable=false)
	private Result result;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@NotNull
	@JoinColumn(name="id_player", insertable=false, updatable=false)
	private Player player;

	//uni-directional many-to-one association to Player
	@ManyToOne
	@NotNull
	@JoinColumn(name="audit_user_id")
	private Player auditUser;

	public MatchResultPlayer() {
	}

	public MatchResultPlayerPK getId() {
		return this.id;
	}

	public void setId(MatchResultPlayerPK id) {
		this.id = id;
	}

	public Date getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditPublicIp() {
		return this.auditPublicIp;
	}

	public void setAuditPublicIp(String auditPublicIp) {
		this.auditPublicIp = auditPublicIp;
	}

	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Result getResult() {
		return this.result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getAuditUser() {
		return this.auditUser;
	}

	public void setAuditUser(Player auditUser) {
		this.auditUser = auditUser;
	}

}