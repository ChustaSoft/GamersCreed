package gamerscreed.rocketstats.model.dao.implementation;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.dto.Match;

public class MatchDAO extends AbstractDAOLayer<Match> {

	@Override
	public Match getById(int anId) {
		return this.entityManager.find(Match.class, anId);
	}

}
