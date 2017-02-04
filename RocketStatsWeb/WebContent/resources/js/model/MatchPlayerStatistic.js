function MatchPlayerStatistic(){
	
	this.playerId;
	this.userName;
	this.matchPoints;
	this.goals;
	this.safes;
	this.shots;
	this.mvp;
	this.winner;
	
	
	this.construct = function(objectStringData){
		var tmpSplittedData = objectStringData.split("-");
		
		this.playerId = tmpSplittedData[0].split("=")[1];
		this.userName = tmpSplittedData[1];
		this.goals = tmpSplittedData[2];
		this.safes = tmpSplittedData[3];
		this.shots = tmpSplittedData[4];
		this.mvp = tmpSplittedData[5];
		this.winner = tmpSplittedData[6];
	};
	
	
	this.setPlayerId = function(playerId){ this.playerId = playerId };
	this.setUserName= function(userName){ this.userName = userName };
	this.setMatchPoints = function(matchPoints){ this.matchPoints = matchPoints };
	this.setGoals = function(goals){ this.goals = goals };
	this.setSafes = function(safes){ this.safes = safes };
	this.setShots = function(shots){ this.shots = shots };
	this.setMvp = function(mvp){ this.mvp = mvp };
	this.setWinner = function(winner){ this.winner = winner };
	
	
	this.getPlayerId = function(){ return this.playerId;	};
	this.getUserName = function(){ return this.userName;	};
	this.getMatchPoints = function(){ return this.matchPoints; };
	this.getGoals = function(){ return this.goals; };
	this.getSafes = function(){ return this.safes; };
	this.getShots = function(){ return this.shots; };
	this.isMvp = function(){ return this.mvp; };
	this.isWinner = function(){ return this.winner; };
	
};