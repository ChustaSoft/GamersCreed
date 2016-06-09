package gamerscreed.rocketstats.model.dao.implementation;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.dto.MatchType;

public class MatchTypeDAO extends AbstractDAOLayer<MatchType> {

	@Override
	public MatchType getById(int anId) {
		return this.entityManager.find(MatchType.class, anId);
	}

}
