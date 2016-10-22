package gamerscreed.rocketstats.services;

import gamerscreed.profiler.structures.DataSender;

public interface TournamentManagementService {

	public DataSender updateMatch();
	
	public DataSender showTournamentStatistics();
	
	public DataSender generateTournament();
		
}
