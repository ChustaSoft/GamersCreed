package gamerscreed.rocketstats.model.test.utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import gamerscreed.rocketstats.model.dao.implementation.MatchDAO;
import gamerscreed.rocketstats.model.dao.implementation.TournamentDAO;
import gamerscreed.rocketstats.model.entities.Match;
import gamerscreed.rocketstats.model.entities.Tournament;

public class TournamentTestHelper {
	
	//Attributes
	TournamentDAO testTournamentDAO = null;
	MatchDAO testMJatchDao = new MatchDAO();
	
	//Public methods
	public Tournament getTournament_OK(){		
		Tournament testTournament = new Tournament();
		
		List<Match> tmpMatches = new ArrayList<Match>();
		for (int i = 0; i < 10; i++) {
			tmpMatches.add(new Match());			
		}
		testMJatchDao.saveEntities(tmpMatches);
		testTournament.getMatches().addAll(tmpMatches);
		
		Calendar tmpCal = Calendar.getInstance();
		testTournament.setStartDate(tmpCal.getTime());
		tmpCal.add(Calendar.MONTH, 1);
		testTournament.setEndDate(tmpCal.getTime());
		
		return testTournament;
	}
	
	public Tournament getTournament_KO(){
		return new Tournament();
	}
	
	public boolean saveTestTournament(Tournament aTournament){
		return testTournamentDAO.saveEntity(aTournament);
	}

}
