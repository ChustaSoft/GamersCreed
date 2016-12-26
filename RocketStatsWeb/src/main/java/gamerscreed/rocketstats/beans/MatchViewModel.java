package gamerscreed.rocketstats.beans;

import java.util.HashMap;
import java.util.Map;

public class MatchViewModel {

	private int matchId;
	private Map<Integer, MatchPlayerStatisticViewBean> localPlayersStatistics;
	private Map<Integer, MatchPlayerStatisticViewBean> visitantPlayersStatistics;
	private int goalsLocal;
	private int goalsVisitor;
	
	
	public MatchViewModel(){
		localPlayersStatistics = new HashMap<Integer, MatchPlayerStatisticViewBean>();
		visitantPlayersStatistics = new HashMap<Integer, MatchPlayerStatisticViewBean>();
		goalsLocal = 0;
		goalsVisitor = 0;
	}
	

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	
	public Map<Integer, MatchPlayerStatisticViewBean> getLocalPlayersStatistics() {
		return localPlayersStatistics;
	}
	
	public void setLocalPlayersStatistics(Map<Integer, MatchPlayerStatisticViewBean> localPlayersStatistics) {
		this.localPlayersStatistics = localPlayersStatistics;
	}
	
	public Map<Integer, MatchPlayerStatisticViewBean> getVisitantPlayersStatistics() {
		return visitantPlayersStatistics;
	}
	
	public void setVisitantPlayersStatistics(Map<Integer, MatchPlayerStatisticViewBean> visitantPlayersStatistics) {
		this.visitantPlayersStatistics = visitantPlayersStatistics;
	}

	public int getGoalsLocal() {
		return goalsLocal;
	}

	public void setGoalsLocal(int goalsLocal) {
		this.goalsLocal = goalsLocal;
	}

	public int getGoalsVisitor() {
		return goalsVisitor;
	}

	public void setGoalsVisitor(int goalsVisitor) {
		this.goalsVisitor = goalsVisitor;
	}

	@Override
	public String toString() {
		StringBuilder tmpLocalPlayers = new StringBuilder(), tmpVisitanPlayers = new StringBuilder();
		for(Map.Entry<Integer, MatchPlayerStatisticViewBean> iLocalPlayerStatistic : getLocalPlayersStatistics().entrySet()) {
			tmpLocalPlayers.append(iLocalPlayerStatistic.toString() + ",");
		}		
		tmpLocalPlayers.replace(tmpLocalPlayers.length() -1, tmpLocalPlayers.length(), "");
		
		for(Map.Entry<Integer, MatchPlayerStatisticViewBean> iVisitantPlayerStatistic : getVisitantPlayersStatistics().entrySet()) {
			tmpVisitanPlayers.append(iVisitantPlayerStatistic.toString() + ",");
		}	
		tmpVisitanPlayers.replace(tmpVisitanPlayers.length() -1, tmpVisitanPlayers.length(), "");
		
		return "ID:" + matchId + ";LocalPlayers:" + tmpLocalPlayers.toString() + ";VisitantPlayers:" + tmpVisitanPlayers.toString() + ";GL:" + goalsLocal + ";GV:" + goalsVisitor;
	}	
	
}
