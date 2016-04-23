package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.dto.Player;
import gamerscreed.rocketstats.model.test.utilities.PlayerTestHelper;

public class PlayerDAOTest {

	
	private PlayerTestHelper testPlayerHelper = null;
	private PlayerDAO testPlayerDao = null;
	
	
	@Before
	public void initTestClass(){
		testPlayerHelper = new PlayerTestHelper();
		testPlayerDao = new PlayerDAO();
	}
	
	@After
	public void endTestClass(){
		
	}
	
	
	@Test
	public void savingRightPlayer() {
		Player testPlayer = testPlayerHelper.getPlayerOK();
		
		assertEquals("Inserting right Player", true, testPlayerDao.saveEntity(testPlayer));
	}
	
	@Test
	public void savingPlayerWithoutRole() {		
		Player testPlayer = testPlayerHelper.getPlayerKO_WithoutRole();
		
		assertEquals("Inserting wrong Player", false, testPlayerDao.saveEntity(testPlayer));
	}
	
	@Test
	public void savingWrongPlayer_BadPassword() {		
		Player testPlayer = testPlayerHelper.getPlayerKO_BadPassword();
		
		assertEquals("Inserting wrong Player", false, testPlayerDao.saveEntity(testPlayer));
	}
	
	@Test
	public void savingWrongPlayer_BadUsername() {		
		Player testPlayer = testPlayerHelper.getPlayerKO_BadUsername();
		
		assertEquals("Inserting wrong Player", false, testPlayerDao.saveEntity(testPlayer));
	}
	
	@Test
	public void updatingRightPlayer() {		
		Player testPlayer = testPlayerDao.getByUsername(PlayerTestHelper.TEST_USERNAME);
		String tmpUpdatedName = "UPDATED NAME";
		
		testPlayer.setName(tmpUpdatedName);
		
		boolean tmpSaved = testPlayerDao.updateEntity(testPlayer);
		testPlayerDao = new PlayerDAO();
		boolean isWellUpdated = testPlayerDao.getByUsername("TESTUSER").getName().equals(tmpUpdatedName);
		
		assertEquals("Updating right player", true, (tmpSaved && isWellUpdated));
	}
	
	@Test
	public void updatingWrongPlayer() {		
		Player testPlayer = testPlayerDao.getByUsername(PlayerTestHelper.TEST_USERNAME);
		String tmpUpdatedPwd = "";
		
		testPlayer.setPassword(tmpUpdatedPwd);
		
		assertEquals("Updating wrong player", false, testPlayerDao.updateEntity(testPlayer));
	}
	
	@Test
	public void removingPlayer() {
		Player testPlayer = testPlayerDao.getByUsername(PlayerTestHelper.TEST_USERNAME);
		
		assertEquals("Updating wright player", true, testPlayerDao.removeEntity(testPlayer));
	}

}
