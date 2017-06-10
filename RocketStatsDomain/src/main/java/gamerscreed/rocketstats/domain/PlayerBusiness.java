package gamerscreed.rocketstats.domain;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import gamerscreed.rocketstats.model.entities.Player;

public interface PlayerBusiness extends UserDetailsService {
	
	public Player updatePlayer();
	
	public boolean removePlayer();
	
	public List<Player> getAllPlayers();
	
	public List<Player> getPlayersByIds(List<Integer> aPlayerIds);
	
}
