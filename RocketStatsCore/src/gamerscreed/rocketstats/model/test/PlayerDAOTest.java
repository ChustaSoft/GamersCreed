package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.dao.implementation.RoleDAO;
import gamerscreed.rocketstats.model.dto.Player;
import gamerscreed.rocketstats.model.dto.Role;
import gamerscreed.rocketstats.utilities.enums.RoleDefinition;

public class PlayerDAOTest {

	private RoleDAO testRoleDao = null;
	private PlayerDAO testPlayerDao = null;
	
	@Before
	public void initTestClass(){
		testRoleDao = new RoleDAO();
		testPlayerDao = new PlayerDAO();
	}
	
	@After
	public void endTestClass(){
		
	}
	
	@Test
	public void savingRightPlayer() {
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
				
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setName("TEST PLAYER");
		testPlayer.setPassword("PWD123456");
		testPlayer.setUsername("TESTUSER");
		
		assertEquals("Inserting right Player", true, testPlayerDao.updateEntity(testPlayer));		
	}
	
	@Test
	public void savingPlayerWithoutRole() {		
		Player testPlayer = new Player();
		testPlayer.setName("TEST PLAYER");
		testPlayer.setUsername("TESTUSER");
		
		assertEquals("Inserting wrong Player", false, testPlayerDao.updateEntity(testPlayer));	
	}
	
	@Test
	public void savingWrongPlayer() {		
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
		
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setPassword("PWD");
		testPlayer.setUsername("TEST USERNAME");
		
		assertEquals("Inserting wrong Player", false, testPlayerDao.updateEntity(testPlayer));	
	}
	
	@Test
	public void updatingRightPlayer() {		
		Player testPlayer = testPlayerDao.getByUsername("TESTUSER");
		String tmpUpdatedName = "UPDATED NAME";
		
		testPlayer.setName(tmpUpdatedName);
		
		boolean tmpSaved = testPlayerDao.updateEntity(testPlayer);
		testPlayerDao = new PlayerDAO();
		boolean isWellUpdated = testPlayerDao.getByUsername("TESTUSER").getName().equals(tmpUpdatedName);
		
		assertEquals("Updating right player", true, (tmpSaved && isWellUpdated));
	}
	
	@Test
	public void updatingWrongPlayer() {		
		Player testPlayer = testPlayerDao.getByUsername("TESTUSER");
		String tmpUpdatedPwd = "";
		
		testPlayer.setPassword(tmpUpdatedPwd);
		
		assertEquals("Updating wrong player", false, testPlayerDao.updateEntity(testPlayer));
	}
	
	@Test
	public void removingPlayer() {
		Player testPlayer = testPlayerDao.getByUsername("TESTUSER");
		
		assertEquals("Updating wright player", true, testPlayerDao.removeEntity(testPlayer));
	}

}
