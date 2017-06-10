package gamerscreed.rocketstats.model.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentViewBean {

	public Date dateStarted;
	public Date dateFinished;
	private List<PlayerStatisticGridViewModel> playerStatisticGridViewModelList;
	private Map<Integer, MatchViewModel> doneMatchViewModelList;
	private Map<Integer, MatchViewModel> undoneMatchViewModelList;
	

	public TournamentViewBean(){
		playerStatisticGridViewModelList = new ArrayList<PlayerStatisticGridViewModel>();
		doneMatchViewModelList = new HashMap<Integer, MatchViewModel>();
		undoneMatchViewModelList = new HashMap<Integer, MatchViewModel>();
	}
	
	
	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public List<PlayerStatisticGridViewModel> getPlayerStatisticGridViewModelList() {
		return playerStatisticGridViewModelList;
	}
	
	public void setPlayerStatisticGridViewModelList(ArrayList<PlayerStatisticGridViewModel> playerStatisticGridViewModelList) {
		this.playerStatisticGridViewModelList = playerStatisticGridViewModelList;
	}
	
	public Map<Integer, MatchViewModel> getDoneMatchViewModelList() {
		return doneMatchViewModelList;
	}
	
	public void setDoneMatchViewModelList(Map<Integer, MatchViewModel> doneMatchViewModelList) {
		this.doneMatchViewModelList = doneMatchViewModelList;
	}
	
	public Map<Integer, MatchViewModel> getUndoneMatchViewModelList() {
		return undoneMatchViewModelList;
	}
	
	public void setUndoneMatchViewModelList(Map<Integer, MatchViewModel> undoneMatchViewModelList) {
		this.undoneMatchViewModelList = undoneMatchViewModelList;
	}
	
}
