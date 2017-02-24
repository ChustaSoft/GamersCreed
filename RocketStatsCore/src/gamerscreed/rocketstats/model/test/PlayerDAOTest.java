package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.test.interfaces.CoreDaoTestInterface;
import gamerscreed.rocketstats.model.test.utilities.PlayerTestHelper;

public class PlayerDAOTest implements CoreDaoTestInterface<Player>{

	
	private PlayerTestHelper testPlayerHelper = null;
		
	
	@Before
	public void initTestClass(){
		testPlayerHelper = new PlayerTestHelper();
	}
	
	@After
	public void endTestClass(){	}
	
	
	@Test
	public void savingRightPlayer() {
		Player testPlayer = testPlayerHelper.getPlayerOK(PlayerTestHelper.TEST_USERNAME1);
		
		assertEquals("Inserting right Player", true, testPlayerHelper.saveTestPlayer(testPlayer));
	}
	
	@Test
	public void savingPlayerWithoutRole() {		
		Player testPlayer = testPlayerHelper.getPlayerKO_WithoutRole(PlayerTestHelper.TEST_USERNAME1);
		
		assertEquals("Inserting wrong Player", false, testPlayerHelper.saveTestPlayer(testPlayer));
	}
	
	@Test
	public void savingWrongPlayer_BadPassword() {		
		Player testPlayer = testPlayerHelper.getPlayerKO_BadPassword(PlayerTestHelper.TEST_USERNAME1);
		
		assertEquals("Inserting wrong Player", false, testPlayerHelper.saveTestPlayer(testPlayer));
	}
	
	@Test
	public void savingWrongPlayer_BadUsername() {		
		Player testPlayer = testPlayerHelper.getPlayerKO_BadUsername();
		
		assertEquals("Inserting wrong Player", false, testPlayerHelper.saveTestPlayer(testPlayer));
	}
	
	@Test
	public void updatingRightPlayer() {		
		Player testPlayer = testPlayerHelper.getTestPlayerByUserame(PlayerTestHelper.TEST_USERNAME1);
		String tmpUpdatedName = "UPDATED NAME";
		
		testPlayer.setName(tmpUpdatedName);
		
		boolean tmpSaved = testPlayerHelper.updateTestEntity(testPlayer);
		boolean isWellUpdated = testPlayerHelper.getTestPlayerByUserame(tmpUpdatedName).getName().equals(tmpUpdatedName);
		
		assertEquals("Updating right player", true, (tmpSaved && isWellUpdated));
	}
	
	@Test
	public void updatingWrongPlayer() {		
		Player testPlayer = testPlayerHelper.getTestPlayerByUserame(PlayerTestHelper.TEST_USERNAME1);
		String tmpUpdatedPwd = "";
		
		testPlayer.setToken(tmpUpdatedPwd);
		
		assertEquals("Updating wrong player", false, testPlayerHelper.updateTestEntity(testPlayer));
	}
	
	@Test
	public void removingPlayer() {
		Player testPlayer = testPlayerHelper.getTestPlayerByUserame(PlayerTestHelper.TEST_USERNAME1);
		
		assertEquals("Updating wright player", true, testPlayerHelper.removeTestPlayer(testPlayer));
	}

}
