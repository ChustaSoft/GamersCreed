$(document).ready(function (){
	
	updateNavigationBar();
	
	setVisibilityForTournamentGenerationControls();
	
	setGenerateTournamentButtonClick();
});


function updateNavigationBar(){
	$('.nav li').eq(1).removeClass("active");
	$('.nav li').eq(0).addClass("active");
};

function setVisibilityForTournamentGenerationControls(){
	$("#rsSelectPlayersShow").click(function (){
		$(".rsHiddenSelection").css("visibility", "visible");
	});
};

function setGenerateTournamentButtonClick(){
	$("#rsGenerateTournament").click(function (){
		var arrayPlayersToGenerateTournament = new Array();
		
		for(var iRow = 0; iRow < $('.rsPlayerRow').length; iRow++)
		{
			if($('.rsPlayerRow').eq(iRow).find("input").is(":checked")){
				var tPlayerId = $('.rsPlayerRow').eq(iRow).attr('id').split("_")[1];				
				arrayPlayersToGenerateTournament.push(tPlayerId);
			}			
		}	
		
		$.ajax({
			type : "POST",			
			url : "users/newTournament",
			contentType: "application/json;",
			data : JSON.stringify(arrayPlayersToGenerateTournament),
			success : function(aRetrivedMatchModel) {
				debugger;
			},
			error : function(e) {
				debugger;
			}			
		});  

	});
};