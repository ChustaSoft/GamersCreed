<%@include file="base/BaseHeaderView.jsp"%>

<body>
	<header>
		<div class="container-fluid">
			<h1>Tournaments</h1>			
		</div>
		
	<%@include file="base/MenuHeader.jsp"%>
	</header>
		
	<div class="container" id="rsPlayerTable">
		<h2 class="text-primary">Classification <span class="small">Tournament started on : ${tournamentViewBean.getFormattedDateStarted()}</span></h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Position</th>
					<th>Player</th>
					<th>Won</th>
					<th>Lost</th>
					<th>Goals for</th>
					<th>Goals against</th>
					<th>Points</th>
				</tr>
			</thead>
			<sTag:if test="${not empty tournamentViewBean.getPlayerStatisticGridViewModelList()}">
				<sTag:forEach var="iPlayerStatistic" items="${tournamentViewBean.getPlayerStatisticGridViewModelList()}">
					<tr>
						<td>${iPlayerStatistic.getPosition()}</td>
						<td>${iPlayerStatistic.getUserName()}</td>
						<td>${iPlayerStatistic.getMatchesWon()}</td>
						<td>${iPlayerStatistic.getMatchesLost()}</td>
						<td>${iPlayerStatistic.getGoalsFor()}</td>
						<td>${iPlayerStatistic.getGoalsAgainst()}</td>
						<td>${iPlayerStatistic.getPoints()}</td>
					</tr>
				</sTag:forEach>
			</sTag:if>
		</table>
	</div>
	
	<div class="container col-md-offset-2">
        <div class="col-md-4">
        	<h2 class="text-primary">Pending <span class="small">Matches to play</span></h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Local</th>
						<th class="text-right">Visitor</th>								
					</tr>
				</thead>
				<sTag:if test="${not empty tournamentViewBean.getUndoneMatchViewModelList()}">
					<sTag:forEach var="iPendingMatch" items="${tournamentViewBean.getUndoneMatchViewModelList()}">
						<tr class="rsTrPendingGame" data-toggle="modal" data-target="#rsModalUpdateMatch" data-element="${iPendingMatch.value}">
							<td>
								<ul class="list-group">
									<sTag:forEach var="iPlayerLocal" items="${iPendingMatch.value.getLocalPlayersStatistics()}">
										<li class="list-group-item">${iPlayerLocal.value.getUserName()}</li>									
									</sTag:forEach>
								</ul>
								<div class="text-center lead">-</div>
							</td>
							<td>
								<ul class="list-group">
									<sTag:forEach var="iPlayerVisitant" items="${iPendingMatch.value.getVisitantPlayersStatistics()}">
										<li class="list-group-item text-right">${iPlayerVisitant.value.getUserName()}</li>
									</sTag:forEach>
								</ul>								
								<div class="text-center lead">-</div>
							</td>
						</tr>
					</sTag:forEach>
				</sTag:if>
			</table>				
        </div>
        
        <div class="col-md-4">	
        <h2 class="text-primary">Results <span class="small">Matches already played</span></h2>            
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Local</th>
						<th class="text-right">Visitor</th>								
					</tr>
				</thead>
				<sTag:if test="${not empty tournamentViewBean.getDoneMatchViewModelList()}">
					<sTag:forEach var="iDoneMatch" items="${tournamentViewBean.getDoneMatchViewModelList()}">
						<tr id="#rsTrDoneGame${iDoneMatch.value.getMatchId()}" >
							<td>
								<ul class="list-group">
									<sTag:forEach var="iPlayerLocal" items="${iDoneMatch.value.getLocalPlayersStatistics()}">
										<li class="list-group-item">${iPlayerLocal.value.getUserName()}</li>
									</sTag:forEach>
								</ul>										
								<div class="text-center lead">${iDoneMatch.value.getGoalsLocal()}</div>									
							</td>
							<td>
								<ul class="list-group">
									<sTag:forEach var="iPlayerVisitant" items="${iDoneMatch.value.getVisitantPlayersStatistics()}">
										<li class="list-group-item text-right">${iPlayerVisitant.value.getUserName()}</li>																			
									</sTag:forEach>
								</ul>
								<div class="text-center lead">${iDoneMatch.value.getGoalsVisitor()}</div>									
							</td>
						</tr>
					</sTag:forEach>
				</sTag:if>
			</table>	
		</div>        	    
	</div>

	<div class="modal fade" id="rsModalUpdateMatch" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Set match result</h4>
				</div>
				<div class="modal-body">
					<div id="rsUpdateMatchContainer">
						<table class="table table-bordered" id="rsUpdateMatchFormLocalTable">
						
						</table>
						<table class="table table-bordered" id="rsUpdateMatchFormVisitorsTable">
						
						</table>
						<button class="btn btn-primary" id="rsSubmitUpdateMatch">Update</button>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="base/BaseFooterView.jsp"%>
<script type="text/javascript" src="resources/js/controller/TournamentsControllerScript.js"></script>
<script type="text/javascript" src="resources/js/model/MatchPlayerStatistic.js"></script>
<script type="text/javascript" src="resources/js/model/Match.js"></script>
		
</body>

</html>