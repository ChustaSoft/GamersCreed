package gamerscreed.rocketstats.services.implementation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gamerscreed.profiler.structures.DataSender;
import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
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
	public DataSender loginPlayer(@RequestParam(value="username") String aUsername, @RequestParam(value="usertoken") String aToken){
		DataSender tmpDataSender = new DataSender();
		
		tmpDataSender.setDataObject(playerDao.getByUsernameAndToken(aUsername, aToken));
		
		return  tmpDataSender;
	}

}