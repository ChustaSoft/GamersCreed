package gamerscreed.rocketstats.services.implementation;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import gamerscreed.profiler.structures.DataSender;
import gamerscreed.rocketstats.domain.PlayerBusiness;
import gamerscreed.rocketstats.domain.TournamentBusiness;
import gamerscreed.rocketstats.model.beans.TournamentViewBean;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.entities.Tournament;
import gamerscreed.rocketstats.services.TournamentManagementService;

public class TournamentManagementServiceRest implements TournamentManagementService {

	@Autowired
	private PlayerBusiness _playerBusinessLayer;
	@Autowired
	private TournamentBusiness _tournamentBusinessLayer; 
	
	@Override
	public DataSender<TournamentViewBean> updateMatch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataSender<TournamentViewBean> showTournamentStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataSender<TournamentViewBean> generateTournament(@RequestBody DataSender<List<Integer>> aDataRetrived) {
		DataSender<TournamentViewBean> tDataSenderObj = new DataSender<TournamentViewBean>(); 
		
		try{
			List<Integer> tPlayerIds =  aDataRetrived.getDataObject();
			List<Player> tPlayerList = _playerBusinessLayer.getPlayersByIds(tPlayerIds);
			
			Tournament tGeneratedTournament = _tournamentBusinessLayer.generateTournament(tPlayerList, Calendar.getInstance().getTime());
			
			if(tGeneratedTournament.getId() > 0){
				tDataSenderObj.setSuccess(true);
				tDataSenderObj.setOperationMessage("Tournament generated");
			}
			else{
				tDataSenderObj.setSuccess(false);
				tDataSenderObj.setOperationMessage("Error generating tournament");
			}
		}
		catch(Exception e){
			tDataSenderObj.setOperationMessage("Error generating tournament : " + e.getMessage());
		}	
		
		return tDataSenderObj;
	}

}
