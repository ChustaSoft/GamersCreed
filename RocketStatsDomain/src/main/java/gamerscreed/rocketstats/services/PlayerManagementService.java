package gamerscreed.rocketstats.services;

import java.util.List;

import gamerscreed.rocketstats.model.beans.PlayerViewBean;

public interface PlayerManagementService {

//	public PlayerViewBean getPlayer(@RequestBody PlayerViewBean aData);

	public PlayerViewBean getPlayer(int anId);
	
	public List<PlayerViewBean> getAllPlayers();
	
}
