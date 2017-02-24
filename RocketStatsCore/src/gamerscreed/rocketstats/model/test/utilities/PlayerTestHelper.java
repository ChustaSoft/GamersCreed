package gamerscreed.rocketstats.model.test.utilities;

import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.dao.implementation.RoleDAO;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.entities.Role;
import gamerscreed.rocketstats.utilities.enums.RoleDefinition;

public class PlayerTestHelper {
	
	//Public static attributes
	public static String TEST_USERNAME1 = "TESTUSER1";
	public static String TEST_USERNAME2 = "TESTUSER2";
	//
	
	
	//Attributes
	private PlayerDAO testPlayerDao =  new PlayerDAO();;
	private RoleDAO testRoleDao = new RoleDAO();
	//
	
	
	//Public methods
	public Player getPlayerOK(String aName){
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
		
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setName("TEST PLAYER");
		testPlayer.setToken("PWD123456");
		testPlayer.setUsername(aName);
		
		return testPlayer;
	}
	
	public Player getPlayerKO_BadUsername(){
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
		
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setToken("PWD123456");
		testPlayer.setUsername("TEST USERNAME");
		
		return testPlayer;
	}
	
	public Player getPlayerKO_BadPassword(String aName){
		Role tmpRole = testRoleDao.getRoleByRoleName(RoleDefinition.ESTANDARD);
		
		Player testPlayer = new Player();
		testPlayer.setRole(tmpRole);
		testPlayer.setToken("PWD");
		testPlayer.setUsername(aName);
		
		return testPlayer;
	}
	
	public Player getPlayerKO_WithoutRole(String aName){
		Player testPlayer = new Player();
		testPlayer.setName("TEST PLAYER");
		testPlayer.setUsername(aName);
		
		return testPlayer;
	}

	public boolean saveTestPlayer(Player aTestPlayer) {
		return testPlayerDao.saveEntity(aTestPlayer);
	}
	
	public boolean updateTestEntity(Player aTestPlayer){
		return testPlayerDao.updateEntity(aTestPlayer);
	}
	
	public Player getTestPlayerByUserame(String anUsername){
		return testPlayerDao.getByUsername(anUsername);
	}

	public Player getTestPlayerById(int anId){
		return testPlayerDao.getById(anId);
	}
	
	public boolean removeTestPlayer(Player aPlayer){
		return testPlayerDao.removeEntity(aPlayer);
	}
	//
	
}
