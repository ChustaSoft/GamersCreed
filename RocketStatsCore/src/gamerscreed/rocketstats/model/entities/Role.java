package gamerscreed.rocketstats.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import gamerscreed.rocketstats.utilities.enums.RoleDefinition;

import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQueries({
	@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
	@NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName")
})
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="role_description")
	private String roleDescription;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-one association to Player
	@OneToMany(mappedBy="role")
	private List<Player> players;

	public Role() {
	}

	public Role(RoleDefinition aRoleDef, String aRoleDescription) {
		this.setRoleName(aRoleDef.toString());
		this.setRoleDescription(aRoleDescription);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player addPlayer(Player player) {
		getPlayers().add(player);
		player.setRole(this);

		return player;
	}

	public Player removePlayer(Player player) {
		getPlayers().remove(player);
		player.setRole(null);

		return player;
	}

}