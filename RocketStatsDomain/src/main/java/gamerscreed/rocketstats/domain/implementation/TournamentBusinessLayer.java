package gamerscreed.rocketstats.domain.implementation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import gamerscreed.rocketstats.domain.TournamentBusiness;
import gamerscreed.rocketstats.model.entities.Match;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.entities.Team;
import gamerscreed.rocketstats.model.entities.Tournament;
import gamerscreed.rocketstats.model.helpers.BasicMatchInfo;

@Service
public class TournamentBusinessLayer implements TournamentBusiness{
	
	@Override
	public Tournament generateTournament(List<Player> aPlayerList, Date aBeginDate) 
	{
		Tournament tGeneratedTournament = new Tournament(aBeginDate);				
		BasicMatchInfo tMatchInfo = new BasicMatchInfo(aPlayerList.size());

		if(tMatchInfo.getTopPlayerForTeam() > 0){
			Map<Integer, Team> tPossibleTeamsForCombination = getInitializedHashMapForTeams(tMatchInfo.getPossibleCombinations());				
			
			for(int iCounterTeam = 0; iCounterTeam < tMatchInfo.getPlayersInMatch(); iCounterTeam++)
			{
				for(int iCounterPlayer = 0; iCounterPlayer < tMatchInfo.getIterationsForPlayer(); iCounterPlayer++)
				{
					int iIndex = getIndex(iCounterTeam, iCounterPlayer, tMatchInfo.getTopPlayerForTeam(), tMatchInfo.getPossibleCombinations());
					tPossibleTeamsForCombination.get(iIndex).addPlayer(aPlayerList.get(iCounterTeam));						
				}						
			}					
						
				for(Team iTeamLocal : tPossibleTeamsForCombination.values())
				{
					for(Team iTeamVisitant : tPossibleTeamsForCombination.values())
					{
						if(!iTeamVisitant.equals(iTeamLocal))
						{
							Match iNewMatch = new Match();
							iNewMatch.setTeamLocal(iTeamLocal);
							iNewMatch.setTeamVisitant(iTeamVisitant);
							if(!tGeneratedTournament.getMatches().contains(iNewMatch))
								tGeneratedTournament.getMatches().add(iNewMatch);
						}						
					}
				}	
				System.out.println("Hola");
		}
		
		return tGeneratedTournament;
	}
	
	private int getIndex(int aCounterTeam, int aCounterPlayer, int aPlayersInMatch, int aPossibleCombinations) {
		int i = aCounterTeam, j = aCounterPlayer;
		if(aCounterTeam >= aPlayersInMatch){
			i = i - aPlayersInMatch;
			j += 10;
		}
		if((j + i) >= aPossibleCombinations)
		{
			j = j + i - aPossibleCombinations;
			i = 0;
		}
		return i + j;
	}

	private Map<Integer, Team> getInitializedHashMapForTeams(int aTeamCombinations)
	{
		Map<Integer, Team> tPossibleTeamsForCombination = new HashMap<Integer, Team>();
		for(int i = 0; i < aTeamCombinations; i++)
		{
			tPossibleTeamsForCombination.put(i, new Team());
		}
		return tPossibleTeamsForCombination;
	}	

}
