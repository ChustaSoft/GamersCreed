package gamerscreed.rocketstats.model.dao.implementation;

import java.util.List;

import javax.persistence.TypedQuery;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.entities.Player;

public class PlayerDAO extends AbstractDAOLayer<Player> {

	public Player getByUsername(String aUserName)
	{
		TypedQuery<Player> query = this.entityManager.createNamedQuery("Player.findByUsername", Player.class);
		query.setParameter("username", aUserName);
		
		return query.getSingleResult();
	}
	
	public Player getByUsernameAndToken(String aUsername, String aToken)
	{
		TypedQuery<Player> query = this.entityManager.createNamedQuery("Player.findByUsernameAndToken", Player.class);
		query.setParameter("username", aUsername);
		query.setParameter("usertoken", aToken);
		
		return query.getSingleResult();
	}
	
	public List<Player> getPlayersByIds(List<Integer> aPlayersIdsList)
	{
		TypedQuery<Player> query = this.entityManager.createNamedQuery("Player.findByUserIds", Player.class);
		query.setParameter("idsList", aPlayersIdsList);
				
		return query.getResultList();		
	}

	@Override
	public Player getById(int anId) {
		return this.entityManager.find(Player.class, anId);
	}
	
}
