package gamerscreed.rocketstats.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gamerscreed.profiler.structures.DataSender;
import gamerscreed.rocketstats.domain.implementation.PlayerBusinessLayer;
import gamerscreed.rocketstats.model.dto.PlayerDto;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.services.PlayerManagementService;

@RestController
@RequestMapping(value = "/players", consumes = "application/json", produces = "application/json")
public class PlayerManagementServiceRest implements PlayerManagementService {

	@Autowired
	private PlayerBusinessLayer playerBussinessLayer;
	
	@Override
	@RequestMapping(method = RequestMethod.POST,  value = "/login")
    public DataSender loginPlayer(@RequestParam(value="dataObject") DataSender aData){
		PlayerDto tmpPlayerDto = (PlayerDto) aData.getDataObject();
		Player tmpPlayerEntity = playerBussinessLayer.getByUsernameAndToken(tmpPlayerDto.getUsername(), tmpPlayerDto.getToken());
		
		if(tmpPlayerEntity != null){
			tmpPlayerDto = new PlayerDto(tmpPlayerEntity);
			aData.setSuccess(true);
			aData.setDataObject(tmpPlayerDto);			
		}
		else{
			aData.setSuccess(false);			
		}
		
		return  aData;
	}

}