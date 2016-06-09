package gamerscreed.rocketstats.model.dao.implementation;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.dto.Team;

public class TeamDAO extends AbstractDAOLayer<Team> {

	@Override
	public Team getById(int anId) {
		return this.entityManager.find(Team.class, anId);
	}

}
