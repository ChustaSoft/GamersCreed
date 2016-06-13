package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.dao.implementation.TeamDAO;
import gamerscreed.rocketstats.model.dto.Team;
import gamerscreed.rocketstats.model.test.interfaces.CoreDaoTestInterface;
import gamerscreed.rocketstats.model.test.utilities.PlayerTestHelper;
import gamerscreed.rocketstats.model.test.utilities.TeamTestHelper;

public class TeamDAOTest implements CoreDaoTestInterface<Team>{
	
	
	private static Validator VALIDATOR;
	
	TeamTestHelper teamTestHelper = null;
	TeamDAO teamDaoTest = null;

	
	@Before
	public void initTestClass() {
		teamDaoTest = new TeamDAO();
		teamTestHelper = new TeamTestHelper();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		VALIDATOR = factory.getValidator();
	}

	@After
	public void endTestClass() {
		
	}
	

	@Test
	public void savingRightTeam() {
		Team testTeam = teamTestHelper.getTeamOK(PlayerTestHelper.TEST_USERNAME1);
		
		Set<ConstraintViolation<Team>> constraintViolations = VALIDATOR.validate(testTeam);
		
		assertEquals(0, constraintViolations.size());
				
		assertEquals("Inserting right Team", true, teamDaoTest.saveEntity(testTeam));
	}

	@Test
	public void savingWrongTeam() {
		Team testTeam = teamTestHelper.getTeamKO_WithoutPlayers();
		
		Set<ConstraintViolation<Team>> constraintViolations = VALIDATOR.validate(testTeam);
		
		assertEquals(1, constraintViolations.size());
		
		assertEquals("Inserting empty Team", false, teamDaoTest.saveEntity(testTeam));
	}

}
