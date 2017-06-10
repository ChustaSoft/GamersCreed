package gamerscreed.rocketstats.domain.implementation;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gamerscreed.rocketstats.domain.PlayerBusiness;
import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.helpers.JwtUserFactory;

@Service
public class PlayerBusinessLayer implements PlayerBusiness {

	private PlayerDAO playerDao;
	
	public PlayerBusinessLayer(){
		playerDao = new PlayerDAO();
	}
	
	@Override
	public UserDetails loadUserByUsername(String aUsername) throws UsernameNotFoundException 
	{
		Player tPlayer = playerDao.getByUsername(aUsername);
		
		if(tPlayer == null)
			throw new UsernameNotFoundException(String.format("No user found with username: '%s'", aUsername));
		
		else
			return JwtUserFactory.create(tPlayer);		
	}
	

	@Override
	public Player updatePlayer() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePlayer() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Player> getAllPlayers() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayersByIds(List<Integer> aPlayerIds) 
	{
		return playerDao.getPlayersByIds(aPlayerIds);
	}

	

}
