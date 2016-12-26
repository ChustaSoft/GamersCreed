function Match(){
	
	this.id;
	this.localPlayers = new Array();
	this.visitantPlayers = new Array();

	this.setId = function(id) { this.id = id; };
	this.setLocalPlayers = function(localPlayers) { this.localPlayers = localPlayers; };
	this.setVisitantPlayers = function(visitantPlayers) { this.visitantPlayers = visitantPlayers; };
	
	this.getId = function() { return this.id; };
	this.getLocalPlayers = function() { return this.localPlayers; };
	this.getVisitantPlayers = function() { return this.visitantPlayers; };
	
};