package gamerscreed.rocketstats.domain;

import java.util.Date;
import java.util.List;

import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.entities.Tournament;

public interface TournamentBusiness {

	Tournament generateTournament(List<Player> aPlayerList, Date aBeginDate);
	
}
