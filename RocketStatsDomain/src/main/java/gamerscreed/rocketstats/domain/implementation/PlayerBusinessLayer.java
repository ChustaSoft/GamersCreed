package gamerscreed.rocketstats.domain.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import gamerscreed.rocketstats.domain.PlayerBusiness;
import gamerscreed.rocketstats.model.dao.implementation.PlayerDAO;
import gamerscreed.rocketstats.model.entities.Player;

@Service
public class PlayerBusinessLayer implements PlayerBusiness {

	private PlayerDAO playerDao;
	
	public PlayerBusinessLayer(){
		playerDao = new PlayerDAO();
	}
	
	@Override
	public Player getByUsernameAndToken(String aUsername, String aPassword) {
		Player tmpPlayerEntity = playerDao.getByUsernameAndToken(aUsername, aUsername);
	
		//TODO: En este punto, la capa de negocio debe aplicar el nivel de seguridad del usuario
		
		return tmpPlayerEntity;
	}

	@Override
	public Player updatePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePlayer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayersByIds(List<Integer> aPlayerIds) {

		return playerDao.getPlayersByIds(aPlayerIds);
	}

}
