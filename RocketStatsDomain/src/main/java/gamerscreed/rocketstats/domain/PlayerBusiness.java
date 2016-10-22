package gamerscreed.rocketstats.domain;

import java.util.List;

import gamerscreed.rocketstats.model.dto.Player;

public interface PlayerBusiness {
	
	public Player getPlayer();
	
	public Player updatePlayer();
	
	public boolean removePlayer();
	
	public List<Player> getAllPlayers();
	
}
