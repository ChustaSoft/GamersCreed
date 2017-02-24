package gamerscreed.rocketstats.model.dao.implementation;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.entities.MatchResultPlayer;

public class MatchResultPlayerDAO extends AbstractDAOLayer<MatchResultPlayer> {

	@Override
	public MatchResultPlayer getById(int anId) {
		return this.entityManager.find(MatchResultPlayer.class, anId);
	}

}
