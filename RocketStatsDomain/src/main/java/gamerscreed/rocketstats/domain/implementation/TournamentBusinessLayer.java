package gamerscreed.rocketstats.domain.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import gamerscreed.rocketstats.domain.TournamentBusiness;
import gamerscreed.rocketstats.model.dto.Player;
import gamerscreed.rocketstats.model.dto.Tournament;

@Service
public class TournamentBusinessLayer implements TournamentBusiness{

	@Override
	public Tournament generateTournament(List<Player> aPlayerList, Date aBeginDate) {
				return null;
	}

}
