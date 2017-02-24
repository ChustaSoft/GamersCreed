package gamerscreed.rocketstats.services;

import org.springframework.web.bind.annotation.RequestBody;

import gamerscreed.profiler.structures.DataSender;

public interface TournamentManagementService {

	public DataSender updateMatch();
	
	public DataSender showTournamentStatistics();
	
	public DataSender generateTournament(@RequestBody DataSender aDataRetrived);
		
}
