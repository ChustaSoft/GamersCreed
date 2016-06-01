package gamerscreed.rocketstats.model.test.utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import gamerscreed.rocketstats.model.dao.implementation.MatchDAO;
import gamerscreed.rocketstats.model.dto.Match;
import gamerscreed.rocketstats.model.dto.Tournament;

public class TournamentTestHelper {
	
	MatchDAO matchDao = new MatchDAO();
	
	public Tournament getTournament_OK(){		
		Tournament testTournament = new Tournament();
		
		List<Match> tmpMatches = new ArrayList<Match>();
		for (int i = 0; i < 10; i++) {
			tmpMatches.add(new Match());			
		}
		matchDao.saveEntities(tmpMatches);
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

}
