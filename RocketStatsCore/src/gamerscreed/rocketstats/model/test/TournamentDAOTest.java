package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.entities.Tournament;
import gamerscreed.rocketstats.model.test.interfaces.CoreDaoTestInterface;
import gamerscreed.rocketstats.model.test.utilities.TournamentTestHelper;

public class TournamentDAOTest implements CoreDaoTestInterface<Tournament>{
	
	TournamentTestHelper testTournametTestHelper = null;
	
	@Before
	public void initTestClass(){
		testTournametTestHelper = new TournamentTestHelper();		
	}
	
	@After
	public void endTestClass(){	}

	@Test
	public void savingRightTournament() {		
		Tournament tmpTournament = testTournametTestHelper.getTournament_OK();
		
		assertEquals("Inserting right Tournament", true, testTournametTestHelper.saveTestTournament(tmpTournament));
	}
	
	@Test
	public void savingWrongTournament() {
		Tournament tmpTournament = testTournametTestHelper.getTournament_KO();
		
		assertEquals("Inserting wrong Tournament", false, testTournametTestHelper.saveTestTournament(tmpTournament));
	}	

}
