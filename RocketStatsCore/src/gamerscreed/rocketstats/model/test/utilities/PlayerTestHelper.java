package gamerscreed.rocketstats.model.test.utilities;

import gamerscreed.rocketstats.model.dao.implementation.RoleDAO;
import gamerscreed.rocketstats.model.dto.Player;
import gamerscreed.rocketstats.model.dto.Role;
import gamerscreed.rocketstats.utilities.enums.RoleDefinition;

public class PlayerTestHelper {
	
	
	private RoleDAO testRoleDao = null;
	public static String TEST_USERNAME = "TESTUSER";
	
	
	public PlayerTestHelper(){
		testRoleDao = new RoleDAO();
	}
	
	
	public Player getPlayerOK(){
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
		
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setName("TEST PLAYER");
		testPlayer.setPassword("PWD123456");
		testPlayer.setUsername(TEST_USERNAME);
		
		return testPlayer;
	}
	
	public Player getPlayerKO_BadUsername(){
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
		
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setPassword("PWD123456");
		testPlayer.setUsername("TEST USERNAME");
		
		return testPlayer;
	}
	
	public Player getPlayerKO_BadPassword(){
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
		
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setPassword("PWD");
		testPlayer.setUsername(TEST_USERNAME);
		
		return testPlayer;
	}
	
	public Player getPlayerKO_WithoutRole(){
		Player testPlayer = new Player();
		testPlayer.setName("TEST PLAYER");
		testPlayer.setUsername(TEST_USERNAME);
		
		return testPlayer;
	}

}
