package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.dao.implementation.MatchDAO;
import gamerscreed.rocketstats.model.dto.Match;
import gamerscreed.rocketstats.model.test.utilities.MatchTestHelper;

public class MatchDAOTest {
	
	MatchTestHelper matchTestHelper = null;
	MatchDAO matchDao = null;	
	
	
	@Before
	public void initTestClass(){
		matchTestHelper = new MatchTestHelper();
		matchDao = new MatchDAO();
	}
	
	@After
	public void endTestClass(){
		
	}
	

	@Test
	public void savingRightMatch() {
		Match testMatch = matchTestHelper.getMatchOK();		
			
		boolean tmpResponse = matchDao.saveEntity(testMatch);
		
		assertEquals("Saving right Match", true, tmpResponse);
	}
	
	@Test
	public void savingWrongMatch() {		
		
	}
	
	@Test
	public void updatingRightMatch() {		
	
	}
	
	@Test
	public void updatingWrongMatch() {		
		
	}

}
