package gamerscreed.rocketstats.model.dao.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import gamerscreed.rocketstats.model.dao.annotations.AtLeastOneNotNull;

public class AtLeastOneNotNullValidator implements ConstraintValidator<AtLeastOneNotNull, List<?>> {

	@Override
	public void initialize(AtLeastOneNotNull constraint) {

	}

	@Override
	public boolean isValid(List<?> aCollection, ConstraintValidatorContext aConstraintValidatorContext) {
		if(aCollection == null || aCollection.isEmpty())
			return false;
		else
			return true;
	}
}
