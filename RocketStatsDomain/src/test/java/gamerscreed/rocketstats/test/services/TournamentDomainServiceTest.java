package gamerscreed.rocketstats.test.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gamerscreed.rocketstats.domain.TournamentBusiness;
import gamerscreed.rocketstats.domain.implementation.TournamentBusinessLayer;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.entities.Tournament;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TournamentBusinessLayer.class})
public class TournamentDomainServiceTest {

	@Autowired
	private TournamentBusiness _tournamentBussinesUnderTest;
	
	@Test
	public void test_tournament_generation()
	{
		List<Player> testPlayers = generateMockedPlayersList();
				
		Tournament tournament = _tournamentBussinesUnderTest.generateTournament(testPlayers, Calendar.getInstance().getTime());
		
		//TODO Assert equals
		
	}	
	
	private List<Player> generateMockedPlayersList()
	{
		List<Player> testPlayers = new ArrayList<Player>();
		
		for(int i = 1; i <= 6; i++)
		{
			testPlayers.add(new Player(i, "P" + i, "TEST PLAYER" + i));
		}
		return testPlayers;
	}
	
}
