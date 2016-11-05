package gamerscreed.rocketstats.services;

import org.springframework.web.bind.annotation.RequestParam;

import gamerscreed.profiler.structures.DataSender;

public interface PlayerManagementService {

	public DataSender loginPlayer(@RequestParam(value="dataObject") DataSender aData);
	
}