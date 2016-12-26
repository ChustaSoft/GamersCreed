function Player(){
	
	this.id;
	this.userName;

	
	this.setId = function(id) { this.id = id; };	
	this.setUsername = function(userName) { this.userName = userName; };
	
	this.getId = function() { return this.id; };
	this.getUsername = function() { return this.userName; };
	
};