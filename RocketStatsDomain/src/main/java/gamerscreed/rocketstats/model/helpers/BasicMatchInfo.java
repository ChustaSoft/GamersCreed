package gamerscreed.rocketstats.model.helpers;

public class BasicMatchInfo {
	
	private int _playersCount;
	
	private int _possibleCombinations;
	
	private int _iterationsForPlayer;
	
	private int _topPlayerForTeam;

	
	public BasicMatchInfo(int aPlayersCount)
	{
		_playersCount = aPlayersCount;
		
		setTopPlayerForTeam();
		calculateCombinations();		
	}
	
	
	public int getMatchesToPlay() {
		return _possibleCombinations / 2;
	}
	
	public int getPlayersCount() {
		return _playersCount;
	}

	public int getPossibleCombinations() {
		return _possibleCombinations;
	}

	public int getIterationsForPlayer() {
		return _iterationsForPlayer;
	}

	public int getTopPlayerForTeam() {
		return _topPlayerForTeam;
	}
	
	public int getPlayersInMatch()
	{
		return _topPlayerForTeam * 2;
	}
	
	
	private void calculateCombinations()
	{
		int tPlayersMinusTypeCount = _playersCount - _topPlayerForTeam;
		int tPlayersFact = 1;
		int tMatchTypeFact = 1;
		int tPlayerMinusTypeFact = 1;
		
		for(int i= 1; i <= _playersCount; i++)
		{
			tPlayersFact *= i;
			if(i <= _topPlayerForTeam)
				tMatchTypeFact *= i;
			if(i <= tPlayersMinusTypeCount)
				tPlayerMinusTypeFact *= i;
		}			
		
		_possibleCombinations = tPlayersFact / (tMatchTypeFact * tPlayerMinusTypeFact);
		_iterationsForPlayer = ( _possibleCombinations - ( _playersCount % _topPlayerForTeam) ) / 2;		
	}
	
	private void setTopPlayerForTeam() 
	{
		if(_playersCount <= 3)
			_topPlayerForTeam = 1;
		if(_playersCount > 1 && _playersCount < 6)
			_topPlayerForTeam = 2;
		if(_playersCount >= 6)
			_topPlayerForTeam = 3;
		else
			_topPlayerForTeam = 0;
	}	

}
