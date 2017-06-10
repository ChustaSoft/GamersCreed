package gamerscreed.rocketstats.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamerscreed.rocketstats.domain.implementation.PlayerBusinessLayer;
import gamerscreed.rocketstats.model.beans.PlayerViewBean;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.services.PlayerManagementService;

@RestController
@RequestMapping(value = "/players")
public class PlayerManagementServiceRest implements PlayerManagementService {

	@Autowired
	private PlayerBusinessLayer _playerBusinessLayer;
	
	@Override	
    public PlayerViewBean getPlayer(int anId){

		return new PlayerViewBean();
	}

	@Override
	@RequestMapping(method = RequestMethod.POST,  value = "/list")
	public List<PlayerViewBean> getAllPlayers() 
	{
		List<PlayerViewBean> tCastedPlayerViewBeanList = new ArrayList<PlayerViewBean>();
		
		for(Player iPlayer : _playerBusinessLayer.getAllPlayers())		
			tCastedPlayerViewBeanList.add(new PlayerViewBean(iPlayer));		
		
		return tCastedPlayerViewBeanList;
	}

}