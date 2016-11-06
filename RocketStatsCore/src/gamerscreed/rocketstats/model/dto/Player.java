package gamerscreed.rocketstats.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="players")
@NamedQueries({
	@NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
	@NamedQuery(name = "Player.findByUsername", query = "SELECT p FROM Player p WHERE p.username = :username"),
	@NamedQuery(name = "Player.findByUsernameAndToken", query = "SELECT p FROM Player p WHERE p.username = :username AND p.password = :usertoken")
})
public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	@Size(min = 6, max = 20)
	private String password;

	@Column(nullable=false)
	private String username;

	//bi-directional many-to-one association to MatchResultPlayer
	@OneToMany(mappedBy="player")
	private List<MatchResultPlayer> matchResultPlayers;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role", nullable=false)
	private Role role;

	//bi-directional many-to-many association to Team
	@ManyToMany(mappedBy="players")
	private List<Team> teams;

	public Player() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(!name.matches(".*\\d.*"))
			this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		if(!username.contains(" "))
			this.username = username;
	}

	public List<MatchResultPlayer> getMatchResultPlayers() {
		if(this.matchResultPlayers == null)
			this.matchResultPlayers = new ArrayList<MatchResultPlayer>();
		return this.matchResultPlayers;
	}

	public void setMatchResultPlayers(List<MatchResultPlayer> matchResultPlayers) {
		this.matchResultPlayers = matchResultPlayers;
	}

	public MatchResultPlayer addMatchResultPlayer(MatchResultPlayer matchResultPlayer) {
		getMatchResultPlayers().add(matchResultPlayer);
		matchResultPlayer.setPlayer(this);

		return matchResultPlayer;
	}

	public MatchResultPlayer removeMatchResultPlayer(MatchResultPlayer matchResultPlayer) {
		getMatchResultPlayers().remove(matchResultPlayer);
		matchResultPlayer.setPlayer(null);

		return matchResultPlayer;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}