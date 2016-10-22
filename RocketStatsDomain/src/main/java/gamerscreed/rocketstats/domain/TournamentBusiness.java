package gamerscreed.rocketstats.domain;

import java.util.Date;
import java.util.List;

import gamerscreed.rocketstats.model.dto.Player;
import gamerscreed.rocketstats.model.dto.Tournament;

public interface TournamentBusiness {

	Tournament generateTournament(List<Player> aPlayerList, Date aBeginDate);
	
}
