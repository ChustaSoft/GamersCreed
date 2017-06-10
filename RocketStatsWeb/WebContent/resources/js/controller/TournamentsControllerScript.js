$(document).ready(function (){
	
	updateNavigationBar();
	
	setUpModalEvent()
		
	setUpdateMatchClick()
	
});


function updateNavigationBar(){
	$('.nav li').eq(0).removeClass("active");
	$('.nav li').eq(1).addClass("active");	
};

function setDynamicModalViewFromModel(aMatchModel){
	$("#rsModalUpdateMatch").attr("match-id" , aMatchModel.matchId);
	
	$("#rsUpdateMatchFormLocalTable").empty();
	$("#rsUpdateMatchFormLocalTable").append(generateHeaderForUpdateMatchModal("Local"));
	$.each(aMatchModel.localPlayersStatistics, function(index, iPlayer){
		$("#rsUpdateMatchFormLocalTable").append(generateRowForPlayerToUpdateMatch(iPlayer));		
	});

	$("#rsUpdateMatchFormVisitorsTable").empty();
	$("#rsUpdateMatchFormVisitorsTable").append(generateHeaderForUpdateMatchModal("Visitor"));
	$.each(aMatchModel.visitantPlayersStatistics, function(index, iPlayer){
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
	tRow.attr("player-id", aPlayer.playerId);
	tRow.append($("<td></td>").html(aPlayer.userName));
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
	tMatch.matchId = $("#rsModalUpdateMatch").attr("match-id");
	
	$.each($("#rsUpdateMatchFormLocalTable").find("tbody>tr"), function(index, iPlayerRow){
		tMatch.localPlayersStatistics.push(getPlayerStatisticUpdateFromRow(iPlayerRow));
	});
	$.each($("#rsUpdateMatchFormVisitorsTable").find("tbody>tr"), function(index, iPlayerRow){
		tMatch.visitantPlayersStatistics.push(getPlayerStatisticUpdateFromRow(iPlayerRow));
	});
	
	return tMatch;
};

function getPlayerStatisticUpdateFromRow(aPlayerStatisticRow){
	var tPlayerStatistic = new MatchPlayerStatistic();
	
	tPlayerStatistic.playerId = $(aPlayerStatisticRow).attr('player-id');
	tPlayerStatistic.userName = $(aPlayerStatisticRow).find("td").eq(0).html();
	tPlayerStatistic.matchPoints = $(aPlayerStatisticRow).find("td").eq(3).find("input").val();
	tPlayerStatistic.goals = $(aPlayerStatisticRow).find("td").eq(4).find("input").val();
	tPlayerStatistic.safes = $(aPlayerStatisticRow).find("td").eq(5).find("input").val();
	tPlayerStatistic.shots = $(aPlayerStatisticRow).find("td").eq(6).find("input").val();
	tPlayerStatistic.mvp = $(aPlayerStatisticRow).find("td").eq(2).find("input").is(':checked');
	tPlayerStatistic.winner = $(aPlayerStatisticRow).find("td").eq(1).find("input").is(':checked');
	
	return tPlayerStatistic;
};

function updateMatch(){
	var tMatchToSend = getMatchFromUpdateContainer();
	
	$.ajax({ 
	    url: "tournaments",    
	    type:"POST", 
	    contentType: "application/json;",
	    data : JSON.stringify(tMatchToSend),
	    async: true,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
		
		},
		error : function(e) {
		
		},
		done : function(e) {
		
		}
	});
};

function setUpdateMatchClick(){
	$("#rsSubmitUpdateMatch").click(function(){
		updateMatch();
	});
};

function setUpModalEvent(){
	$('#rsModalUpdateMatch').on('show.bs.modal', function (event) {
		var tMatchId = $(event.relatedTarget).data('element');
		
		$.ajax({
			type : "POST",			
			url : "tournaments",
			data : {
				matchId : tMatchId
			},
			dataType: "json",
			success : function(aRetrivedMatchModel) {
				setDynamicModalViewFromModel(aRetrivedMatchModel);
			},
			error : function(e) {
				debugger;
			}			
		});		  
	});	
};