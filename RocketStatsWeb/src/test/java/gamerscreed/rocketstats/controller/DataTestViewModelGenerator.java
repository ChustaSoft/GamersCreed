package gamerscreed.rocketstats.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gamerscreed.rocketstats.beans.MatchPlayerStatisticViewBean;
import gamerscreed.rocketstats.beans.MatchViewModel;
import gamerscreed.rocketstats.beans.PlayerStatisticGridViewModel;
import gamerscreed.rocketstats.beans.PlayerViewBean;
import gamerscreed.rocketstats.beans.TournamentViewBean;
import gamerscreed.rocketstats.components.UserSessionObject;

public class DataTestViewModelGenerator {

	public static UserSessionObject getTestUserSessionObject(){
		UserSessionObject testPlayer = new UserSessionObject();
		testPlayer.setUserName("XAVI");
		testPlayer.setSessionId(java.util.UUID.randomUUID());
		
		return testPlayer;
	}
	
	public static List<PlayerViewBean> getTestPlayerArray(){
		List<PlayerViewBean> tmpPlayerList = new ArrayList<PlayerViewBean>();
		
		PlayerViewBean tmpTestBean = new PlayerViewBean();
		tmpTestBean.setFullName("XAVI RUEDA");
		tmpTestBean.setUserId(1);
		tmpTestBean.setRoleName("JEFE");
		tmpTestBean.setUserName("XELIT3");
		tmpPlayerList.add(tmpTestBean);
		
		tmpTestBean = new PlayerViewBean();
		tmpTestBean.setFullName("NOELIA MOLINA");
		tmpTestBean.setUserId(2);
		tmpTestBean.setRoleName("PRIMERA DAMA");
		tmpTestBean.setUserName("LUNARIS");
		tmpPlayerList.add(tmpTestBean);
		
		tmpTestBean = new PlayerViewBean();
		tmpTestBean.setFullName("ORLANDO MANJARREZ");
		tmpTestBean.setUserId(3);
		tmpTestBean.setRoleName("PRINGAO");
		tmpTestBean.setUserName("ORLA");
		tmpPlayerList.add(tmpTestBean);
		
		return tmpPlayerList;
	}
		
	public static TournamentViewBean getTestTournamentView(){
		TournamentViewBean testViewBean = new TournamentViewBean();
		
		testViewBean.dateStarted = new Date();
		
		PlayerStatisticGridViewModel testGridViewBean = new PlayerStatisticGridViewModel();
		testGridViewBean.setPosition(1);
		testGridViewBean.setUserName("Xelit3");
		testGridViewBean.setGoalsFor(10);
		testGridViewBean.setGoalsAgainst(2);
		testGridViewBean.setMatchesLost(2);
		testGridViewBean.setMatchesWon(5);
		testGridViewBean.setPoints(22);
		
		testViewBean.getPlayerStatisticGridViewModelList().add(testGridViewBean);
		
		testGridViewBean = new PlayerStatisticGridViewModel();
		testGridViewBean.setPosition(2);
		testGridViewBean.setUserName("Noelia");
		testGridViewBean.setGoalsFor(12);
		testGridViewBean.setGoalsAgainst(15);
		testGridViewBean.setMatchesLost(10);
		testGridViewBean.setMatchesWon(0);
		testGridViewBean.setPoints(0);
		
		testViewBean.getPlayerStatisticGridViewModelList().add(testGridViewBean);
		
		MatchViewModel tmpMatchViewModel = new MatchViewModel();
		MatchPlayerStatisticViewBean tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchViewModel.setMatchId(1);
		tmpMatchPlayerStatisticViewBean.setPlayerId(1);
		tmpMatchPlayerStatisticViewBean.setUserName("Xelit3");
		tmpMatchViewModel.getLocalPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchPlayerStatisticViewBean.setPlayerId(2);
		tmpMatchPlayerStatisticViewBean.setUserName("Noelia");
		tmpMatchViewModel.getVisitantPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		
		testViewBean.getUndoneMatchViewModelList().put(tmpMatchViewModel.getMatchId(), tmpMatchViewModel);
		
		tmpMatchViewModel = new MatchViewModel();
		tmpMatchViewModel.setMatchId(2);
		tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchPlayerStatisticViewBean.setPlayerId(1);
		tmpMatchPlayerStatisticViewBean.setUserName("Xelit3");
		tmpMatchViewModel.getLocalPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchPlayerStatisticViewBean.setPlayerId(2);
		tmpMatchPlayerStatisticViewBean.setUserName("Noelia");
		tmpMatchViewModel.getVisitantPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		tmpMatchViewModel.setGoalsLocal(5);
		tmpMatchViewModel.setGoalsVisitor(2);
		testViewBean.getDoneMatchViewModelList().put(tmpMatchViewModel.getMatchId(), tmpMatchViewModel);
		
		tmpMatchViewModel = new MatchViewModel();
		tmpMatchViewModel.setMatchId(3);
		tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchPlayerStatisticViewBean.setPlayerId(2);
		tmpMatchPlayerStatisticViewBean.setUserName("Noelia");
		tmpMatchViewModel.getLocalPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchPlayerStatisticViewBean.setPlayerId(1);
		tmpMatchPlayerStatisticViewBean.setUserName("Xelit3");
		tmpMatchViewModel.getLocalPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchPlayerStatisticViewBean.setPlayerId(3);
		tmpMatchPlayerStatisticViewBean.setUserName("Raul");
		tmpMatchViewModel.getVisitantPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		tmpMatchPlayerStatisticViewBean = new MatchPlayerStatisticViewBean();
		tmpMatchPlayerStatisticViewBean.setPlayerId(1);
		tmpMatchPlayerStatisticViewBean.setUserName("Angel");
		tmpMatchViewModel.getVisitantPlayersStatistics().add(tmpMatchPlayerStatisticViewBean);
		tmpMatchViewModel.setGoalsLocal(0);
		tmpMatchViewModel.setGoalsVisitor(7);
		testViewBean.getDoneMatchViewModelList().put(tmpMatchViewModel.getMatchId(), tmpMatchViewModel);
		
		return testViewBean;
	}	
	
}
