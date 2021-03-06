package gamerscreed.rocketstats.model.test.utilities;

import gamerscreed.rocketstats.model.dao.implementation.MatchDAO;
import gamerscreed.rocketstats.model.dao.implementation.MatchResultPlayerDAO;
import gamerscreed.rocketstats.model.dao.implementation.MatchTypeDAO;
import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.dao.implementation.TeamDAO;
import gamerscreed.rocketstats.model.dao.implementation.TournamentDAO;
import gamerscreed.rocketstats.model.entities.Match;
import gamerscreed.rocketstats.model.entities.MatchResultPlayer;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.entities.Result;

public class MatchTestHelper {
	
	private MatchTypeDAO matchTypeDao = new MatchTypeDAO();
	private MatchResultPlayerDAO matchResultPlayer = new MatchResultPlayerDAO();
	private TeamDAO teamDao = new TeamDAO();
	private TournamentDAO tournamentDAO = new TournamentDAO();
	private MatchDAO matchDao = new MatchDAO();
	private PlayerDAO playerDao = new PlayerDAO();
	
	public Match getMatch_OK(){
		
		Match testMatch = new Match();
		
		testMatch.setMatchType(matchTypeDao.getById(1));
		
		testMatch.setTeamLocal(teamDao.getById(1));
		testMatch.setTeamVisitant(teamDao.getById(1));
		
		testMatch.setTournament(tournamentDAO.getById(1));
						
		return testMatch;
	}
	
	public MatchResultPlayer getMatchResultPlayer_OK(){
		Match testMatch = matchDao.getById(1);
		
		Result testResult = new Result();
		testResult.setWinner(true);
		testResult.setGoals(2);
		
		Player testPlayer = playerDao.getById(1);
		
		MatchResultPlayer testResultForMatchAndPlayer = new MatchResultPlayer();		
		testResultForMatchAndPlayer.setMatch(testMatch);
		testResultForMatchAndPlayer.setPlayer(testPlayer);
		testResultForMatchAndPlayer.setAuditUser(testPlayer);
		testResultForMatchAndPlayer.setResult(testResult);
		
		return testResultForMatchAndPlayer;
	}
	
	public MatchResultPlayer getMatchResultPlayer_KO(){
		return new MatchResultPlayer();
	}
	
	public Match getMatch_KO(){		
		return new Match();
	}
	
	public Match getPersistedMatch_OK(){
		return matchDao.getById(1);
	}
	
	public boolean saveTestMatch(Match aMatch){
		return matchDao.saveEntity(aMatch);
	}
	
	public boolean saveTestMatchResultPlayer(MatchResultPlayer aMatchResultPlayer){
		return matchResultPlayer.saveEntity(aMatchResultPlayer);
	}
}
