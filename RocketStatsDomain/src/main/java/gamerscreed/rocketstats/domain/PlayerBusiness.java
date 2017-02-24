package gamerscreed.rocketstats.domain;

import java.util.List;

import gamerscreed.rocketstats.model.entities.Player;

public interface PlayerBusiness {
	
	public Player getByUsernameAndToken(String aUsername, String aPassword);
	
	public Player updatePlayer();
	
	public boolean removePlayer();
	
	public List<Player> getAllPlayers();
	
	public List<Player> getPlayersByIds(List<Integer> aPlayerIds);
	
}
