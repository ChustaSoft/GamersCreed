package gamerscreed.rocketstats.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.dto.Player;

public class PlayerDAOTest {

	private PlayerDAO testPlayerDao = null;
	
	@Before
	public void initTestClass(){
		testPlayerDao = new PlayerDAO();
	}
	
	@After
	public void endTestClass(){
		
	}
	
	@Test
	public void savingRightPlayer() {		
		Player testPlayer = new Player();
		testPlayer.setName("TEST-PLAYER");
		testPlayer.setPassword("PWD");
		testPlayer.setUsername("TEST USERNAME");
		
		assertEquals("Inserting OK Player", true, testPlayerDao.updateEntity(testPlayer));		
	}
	
	@Test
	public void savingWrongPlayer() {		
		
	}
	
	@Test
	public void updatingRightPlayer() {		
	
	}
	
	@Test
	public void updatingWrongPlayer() {		
		
	}
	
	@Test
	public void removingPlayer() {		
		
	}
	
	@Test
	public void gettingAllPlayers() {		
		
	}

}
