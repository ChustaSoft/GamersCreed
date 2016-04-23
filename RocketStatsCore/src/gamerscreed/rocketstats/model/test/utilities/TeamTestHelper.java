package gamerscreed.rocketstats.model.test.utilities;

import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.dto.Player;
import gamerscreed.rocketstats.model.dto.Team;

public class TeamTestHelper {
	
	PlayerTestHelper playerTestHelper = null;
	PlayerDAO playerTestDao = null;
	
	public TeamTestHelper() {
		playerTestHelper = new PlayerTestHelper();
		playerTestDao = new PlayerDAO();
	}
	
	public Team getTeamOK(){
		Player tmpPlayer = playerTestHelper.getPlayerOK();
		playerTestDao.saveEntity(tmpPlayer);
		playerTestDao = new PlayerDAO();
		tmpPlayer = playerTestDao.getByUsername(PlayerTestHelper.TEST_USERNAME);
		
		Team testTeam = new Team();
		testTeam.addPlayer(tmpPlayer);
		
		return testTeam;		
	}
	
	public Team getTeamKO_WithoutPlayers(){
		return new Team();
	}

}
