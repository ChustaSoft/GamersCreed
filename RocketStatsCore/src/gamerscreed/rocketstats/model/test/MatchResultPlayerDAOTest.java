package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.dto.MatchResultPlayer;
import gamerscreed.rocketstats.model.test.interfaces.CoreDaoTestInterface;
import gamerscreed.rocketstats.model.test.utilities.MatchTestHelper;

public class MatchResultPlayerDAOTest implements CoreDaoTestInterface<MatchResultPlayer>{

	private MatchTestHelper matchTestHelper;
	
	@Before
	public void initTestClass(){
		matchTestHelper = new MatchTestHelper();
	}
	
	@After
	public void endTestClass(){
		
	}
	
	@Test
	public void savingRightMatchResultPlayer() {		
		MatchResultPlayer testMatchResultPlayer = matchTestHelper.getMatchResultPlayer_OK();
		
		boolean tmpResponse = matchTestHelper.saveTestMatchResultPlayer(testMatchResultPlayer);
		
		assertEquals("Saving right MatchResultPlayer", true, tmpResponse);
	}
	
	@Test
	public void savingWrongMatchResultPlayer() {
		MatchResultPlayer testMatchResultPlayer = matchTestHelper.getMatchResultPlayer_KO();
		
		boolean tmpResponse = matchTestHelper.saveTestMatchResultPlayer(testMatchResultPlayer);
		
		assertEquals("Saving wrong MatchResultPlayer", false, tmpResponse);
		
	}

}
