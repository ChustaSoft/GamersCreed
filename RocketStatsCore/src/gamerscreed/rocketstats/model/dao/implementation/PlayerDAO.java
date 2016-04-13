package gamerscreed.rocketstats.model.dao.implementation;

import javax.persistence.TypedQuery;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.dto.Player;

public class PlayerDAO extends AbstractDAOLayer<Player> {

	public Player getByUsername(String aUserName){
		TypedQuery<Player> query = this.entityManager.createNamedQuery("Player.findByUsername", Player.class);
		query.setParameter("username", aUserName);
		
		return query.getSingleResult();
	}
}
