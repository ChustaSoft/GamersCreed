package gamerscreed.rocketstats.services.implementation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.dto.Player;
import gamerscreed.rocketstats.services.PlayerManagementService;

@RestController
public class PlayerManagementServiceRest implements PlayerManagementService {

	PlayerDAO playerDao = new PlayerDAO();
	
    @RequestMapping("/")
    public String index() {
        return "Hello - RocketStats";
    }

	@Override
	@RequestMapping("/login")
	public Player loginPlayer(@RequestParam(value="username") String aUsername, @RequestParam(value="usertoken") String aToken){
		return  playerDao.getByUsernameAndToken(aUsername, aToken);
	}

}