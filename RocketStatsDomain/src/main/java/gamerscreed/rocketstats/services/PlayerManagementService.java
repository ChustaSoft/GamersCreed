package gamerscreed.rocketstats.services;

import org.springframework.web.bind.annotation.RequestParam;

import gamerscreed.rocketstats.model.dto.Player;

public interface PlayerManagementService {

	public Player loginPlayer(@RequestParam(value="username") String aUsername, @RequestParam(value="usertoken") String aToken);
	
}