package gamerscreed.rocketstats.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import gamerscreed.profiler.structures.DataSender;
import gamerscreed.rocketstats.model.beans.TournamentViewBean;

public interface TournamentManagementService {

	public DataSender<TournamentViewBean> updateMatch();
	
	public DataSender<TournamentViewBean> showTournamentStatistics();
	
	public DataSender<TournamentViewBean> generateTournament(@RequestBody DataSender<List<Integer>> aDataRetrived);
		
}
