package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.dao.implementation.TournamentDAO;
import gamerscreed.rocketstats.model.dto.Tournament;
import gamerscreed.rocketstats.model.test.interfaces.CoreDaoTestInterface;
import gamerscreed.rocketstats.model.test.utilities.TournamentTestHelper;

public class TournamentDAOTest implements CoreDaoTestInterface<Tournament>{
	
	TournamentDAO tournamentDAO = null;
	TournamentTestHelper testTournametTestHelper = null;
	
	@Before
	public void initTestClass(){
		testTournametTestHelper = new TournamentTestHelper();
		tournamentDAO = new TournamentDAO();
	}
	
	@After
	public void endTestClass(){

	}

	@Test
	public void savingRightTournament() {		
		Tournament tmpTournament = testTournametTestHelper.getTournament_OK();
		
		assertEquals("Inserting right Tournament", true, tournamentDAO.saveEntity(tmpTournament));
	}
	
	@Test
	public void savingWrongTournament() {
		Tournament tmpTournament = testTournametTestHelper.getTournament_KO();
		
		assertEquals("Inserting wrong Tournament", false, tournamentDAO.saveEntity(tmpTournament));
	}	

}
