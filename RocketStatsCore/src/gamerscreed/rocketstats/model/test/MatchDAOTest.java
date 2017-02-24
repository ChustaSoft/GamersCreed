package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.entities.Match;
import gamerscreed.rocketstats.model.test.interfaces.CoreDaoTestInterface;
import gamerscreed.rocketstats.model.test.utilities.MatchTestHelper;

public class MatchDAOTest implements CoreDaoTestInterface<Match>{
	
	MatchTestHelper matchTestHelper = null;
		
	@Before
	public void initTestClass(){
		matchTestHelper = new MatchTestHelper();		
	}
	
	@After
	public void endTestClass(){
		
	}
	

	@Test
	public void savingRightMatch() {
		Match testMatch = matchTestHelper.getMatch_OK();
			
		boolean tmpResponse = matchTestHelper.saveTestMatch(testMatch);
		
		assertEquals("Saving right Match", true, tmpResponse);
	}
	
	@Test
	public void savingWrongMatch() {		
		Match testMatch = matchTestHelper.getMatch_KO();
		
		boolean tmpResponse = matchTestHelper.saveTestMatch(testMatch);
		
		assertEquals("Saving wrong Match", false, tmpResponse);
	}
	
	@Test
	public void updatingRightMatch() {		
		Match testMatch = matchTestHelper.getPersistedMatch_OK();
		testMatch.setDatePlayed(Calendar.getInstance().getTime());
		
		boolean tmpResponse = matchTestHelper.saveTestMatch(testMatch);
		
		assertEquals("Updating right Match", true, tmpResponse);
	}
	
	@Test
	public void updatingWrongMatch() {		
		Match testMatch = matchTestHelper.getPersistedMatch_OK();
		
		testMatch.setTeamLocal(null);
		testMatch.setTeamVisitant(null);
		
		boolean tmpResponse = matchTestHelper.saveTestMatch(testMatch);
		
		assertEquals("Updating wrong Match", false, tmpResponse);
	}

}
