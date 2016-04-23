package gamerscreed.rocketstats.model.dao.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import gamerscreed.rocketstats.model.dao.validators.AtLeastOneNotNullValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AtLeastOneNotNullValidator.class)
public @interface AtLeastOneNotNull {
	
	String message() default "{[ERROR] Collection must have at least one element}";

	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}