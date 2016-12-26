$(document).ready(function (){
		
	$('#rsModalUpdateMatch').on('show.bs.modal', function (event) {
		  var tMatchModel = getMatchModelFromStringData($(event.relatedTarget).data('element')); 
		  		  
		  setDynamicModalViewFromModel(tMatchModel);
	});
	
	$("#rsSubmitUpdateMatch").click(function(){
		var tMatchToSend = getMatchFromUpdateContainer();
	});
	
});

function getMatchModelFromStringData(aDataElement){
	var tSplittedData = aDataElement.split(";");	
	var tMatch = new Match();
	
	tMatch.setId(tSplittedData[0].split(":")[1]);
	
	var tLocalPlayers = tSplittedData[1].split(":")[1].split(",");
	var tVisitantPlayers = tSplittedData[2].split(":")[1].split(",");
	tMatch.setLocalPlayers(getPlayerObjectDataArray(tLocalPlayers));		
	tMatch.setVisitantPlayers(getPlayerObjectDataArray(tVisitantPlayers));
	
	return tMatch;
};

function setDynamicModalViewFromModel(aMatchModel){
	$("#rsModalUpdateMatch").attr("match-id" , aMatchModel.getId());
	
	$("#rsUpdateMatchFormLocalTable").empty();
	$("#rsUpdateMatchFormLocalTable").append(generateHeaderForUpdateMatchModal("Local"));
	$.each(aMatchModel.getLocalPlayers(), function(index, iPlayer){
		
		$("#rsUpdateMatchFormLocalTable").append(generateRowForPlayerToUpdateMatch(iPlayer));		
	});
	$("#rsUpdateMatchFormVisitorsTable").empty();
	$("#rsUpdateMatchFormVisitorsTable").append(generateHeaderForUpdateMatchModal("Visitor"));
	$.each(aMatchModel.getVisitantPlayers(), function(index, iPlayer){
		$("#rsUpdateMatchFormVisitorsTable").append(generateRowForPlayerToUpdateMatch(iPlayer));	
	});	
};

function getPlayerObjectDataArray(aArrayPlayers){
	var tPlayerStatisticObjets = new Array();
	var tPlayerStatistic;
	$.each(aArrayPlayers, function(index, iPlayer){
		tPlayerStatistic = new MatchPlayerStatistic();
		tPlayerStatistic.construct(iPlayer);
		tPlayerStatisticObjets.push(tPlayerStatistic);
	});
	
	return tPlayerStatisticObjets;
};

function generateRowForPlayerToUpdateMatch(aPlayer){
	var tRow = $("<tr></tr>");
	tRow.attr("player-id", aPlayer.getPlayerId());
	tRow.append($("<td></td>").html(aPlayer.getUserName()));
	tRow.append($("<td></td>").html("<input type='checkbox' id='winner' />"));
	tRow.append($("<td></td>").html("<input type='checkbox' id='mvp' />"));
	tRow.append($("<td></td>").html("<input type='number' min='0' value='0' step='10' id='matchPoints' />"));
	tRow.append($("<td></td>").html("<input type='number' min='0' value='0' step='1' id='goals' />"));
	tRow.append($("<td></td>").html("<input type='number' min='0' value='0' step='1' id='safes' />"));
	tRow.append($("<td></td>").html("<input type='number' min='0' value='0' step='1' id='shots' />"));
	
	return tRow;
};

function generateHeaderForUpdateMatchModal(aPlayerPositionLabel){
	return "<thead>" +
				"<tr><th colspan='7'>" + aPlayerPositionLabel + "</th></tr><tr><th>Player</th><th>Winner</th><th>MVP</th><th>Points</th><th>Goals</th><th>Safes</th><th>Shots</th></tr>" +
		   "</thead>";	
};

function getMatchFromUpdateContainer(){
	//TODO Obtener un Match, necesitamos el ID del partido, y recorrer filas (establecerles una clase para buscarlas seria muy útil
	
	var tMatch = new Match();
	tMatch.setId($("#rsModalUpdateMatch").attr("match-id"));
//	var count = $('#rsUpdateMatchFormLocalTable').get(0).rows;
	$.each($("#rsUpdateMatchFormLocalTable").find('> tbody > tr'), function(index, iPlayerRow){
		var tTest = iPlayerRow.cells;
		var tTest1 = iPlayerRow.cells[1].innerHTML;
		debugger;
	});	
};