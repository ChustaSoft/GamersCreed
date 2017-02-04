package gamerscreed.rocketstats.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatchViewModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int matchId;
	private List<MatchPlayerStatisticViewBean> localPlayersStatistics;
	private List<MatchPlayerStatisticViewBean> visitantPlayersStatistics;
	private int goalsLocal;
	private int goalsVisitor;
	
	
	public MatchViewModel(){
		localPlayersStatistics = new ArrayList<MatchPlayerStatisticViewBean>();
		visitantPlayersStatistics = new ArrayList<MatchPlayerStatisticViewBean>();
		goalsLocal = 0;
		goalsVisitor = 0;
	}
	

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
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

	public List<MatchPlayerStatisticViewBean> getLocalPlayersStatistics() {
		return localPlayersStatistics;
	}


	public void setLocalPlayersStatistics(List<MatchPlayerStatisticViewBean> localPlayersStatistics) {
		this.localPlayersStatistics = localPlayersStatistics;
	}


	public List<MatchPlayerStatisticViewBean> getVisitantPlayersStatistics() {
		return visitantPlayersStatistics;
	}


	public void setVisitantPlayersStatistics(List<MatchPlayerStatisticViewBean> visitantPlayersStatistics) {
		this.visitantPlayersStatistics = visitantPlayersStatistics;
	}
	
}
