package gamerscreed.rocketstats.model.dao.implementation;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.entities.Tournament;

public class TournamentDAO extends AbstractDAOLayer<Tournament> {

	@Override
	public Tournament getById(int anId) {
		return this.entityManager.find(Tournament.class, anId);
	}

}
