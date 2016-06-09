package gamerscreed.rocketstats.model.dao.implementation;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.dto.Result;

public class ResultDAO extends AbstractDAOLayer<Result> {

	@Override
	public Result getById(int anId) {
		return this.entityManager.find(Result.class, anId);
	}

}
