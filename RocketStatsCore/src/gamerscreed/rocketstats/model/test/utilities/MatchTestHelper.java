package gamerscreed.rocketstats.model.test.utilities;

import gamerscreed.rocketstats.model.dao.implementation.MatchDAO;
import gamerscreed.rocketstats.model.dao.implementation.MatchTypeDAO;
import gamerscreed.rocketstats.model.dao.implementation.TeamDAO;
import gamerscreed.rocketstats.model.dao.implementation.TournamentDAO;
import gamerscreed.rocketstats.model.dto.Match;

public class MatchTestHelper {
	
	private MatchTypeDAO matchTypeDao = new MatchTypeDAO();
	private TeamDAO teamDao = new TeamDAO();
	private TournamentDAO tournamentDAO = new TournamentDAO();
	private MatchDAO matchDao = new MatchDAO();
	
	public Match getMatch_OK(){
		
		Match testMatch = new Match();
		
		testMatch.setMatchType(matchTypeDao.getById(1));
		
		testMatch.setTeamLocal(teamDao.getById(1));
		testMatch.setTeamVisitant(teamDao.getById(1));
		
		testMatch.setTournament(tournamentDAO.getById(1));
						
		return testMatch;
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
}
