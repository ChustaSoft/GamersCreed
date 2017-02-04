$(document).ready(function (){
	$('.nav li').eq(0).removeClass("active");
	$('.nav li').eq(1).removeClass("active");
	$('.nav li').eq(2).addClass("active");	
		
	$('#rsModalUpdateMatch').on('show.bs.modal', function (event) {
		  var tMatchModel = getMatchModelFromStringData($(event.relatedTarget).data('element')); 
		  		  
		  setDynamicModalViewFromModel(tMatchModel);
	});
	
	$("#rsSubmitUpdateMatch").click(function(){
		var tMatchToSend = getMatchFromUpdateContainer();
		
		updateMatch(tMatchToSend);
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
	tRow.append($("<td></td>").html("<input type='checkbox' />"));
	tRow.append($("<td></td>").html("<input type='checkbox' />"));
	tRow.append($("<td></td>").html("<input type='number' min='0' value='0' step='10' />"));
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
	var tMatch = new Match();
	tMatch.setId($("#rsModalUpdateMatch").attr("match-id"));
	
	$.each($("#rsUpdateMatchFormLocalTable").find("tbody>tr"), function(index, iPlayerRow){
		tMatch.getLocalPlayers().push(getPlayerStatisticUpdateFromRow(iPlayerRow));
	});
	$.each($("#rsUpdateMatchFormVisitorsTable").find("tbody>tr"), function(index, iPlayerRow){
		tMatch.getVisitantPlayers().push(getPlayerStatisticUpdateFromRow(iPlayerRow));
	});
	
	return tMatch;
};

function getPlayerStatisticUpdateFromRow(aPlayerStatisticRow){
	var tPlayerStatistic = new MatchPlayerStatistic();
	
	tPlayerStatistic.setPlayerId($(aPlayerStatisticRow).attr('player-id'));
	tPlayerStatistic.setUserName($(aPlayerStatisticRow).find("td").eq(0).html());
	tPlayerStatistic.setMatchPoints($(aPlayerStatisticRow).find("td").eq(3).find("input").val());
	tPlayerStatistic.setGoals($(aPlayerStatisticRow).find("td").eq(4).find("input").val());
	tPlayerStatistic.setSafes($(aPlayerStatisticRow).find("td").eq(5).find("input").val());
	tPlayerStatistic.setShots($(aPlayerStatisticRow).find("td").eq(6).find("input").val());
	tPlayerStatistic.setMvp($(aPlayerStatisticRow).find("td").eq(2).find("input").is(':checked'));
	tPlayerStatistic.setWinner($(aPlayerStatisticRow).find("td").eq(1).find("input").is(':checked'));
	
	return tPlayerStatistic;
};

function updateMatch(aMatch){
	var x = JSON.stringify(aMatch);
	$.ajax({ 
	    url: "tournaments",    
	    type:"POST", 
	    contentType: "application/json;",
	    data : JSON.stringify(aMatch),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			alert("ok");
		},
		error : function(e) {
			alert("bad");
		},
		done : function(e) {
			alert("done");
		}
	});
};