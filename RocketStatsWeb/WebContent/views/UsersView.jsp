<%@include file="base/BaseHeaderView.jsp"%>

<body>
	<header>
		<div class="container-fluid">
			<h1>Vista de usuarios</h1>			
		</div>
		
	<%@include file="base/MenuHeader.jsp"%>
	</header>
	
	<div class="container rsPlayerControls">
		<button type="button" id="rsSelectPlayersShow" class="btn btn-primary btn-md pull-right" >Generate tournament</button>	
		<button type="button" id="rsAddPlayer" class="btn btn-primary btn-md pull-right" data-toggle="modal" data-target="#rsModalAddPlayer">Add player</button>
	</div>
	
	<div class="container" id="rsPlayerTable">
		<table class="table table-hover">
			<thead>
				<tr>					
					<th>User</th>
					<th>Full name</th>
					<th>Role</th>
					<th class="rsHiddenSelection">Select</th>
				</tr>
			</thead>
			<sTag:if test="${not empty playerList}">
				<sTag:forEach var="iPlayer" items="${playerList}">
					<tr class="rsPlayerRow" id ="rowPlayer_${iPlayer.getUserId()}">						
						<td>${iPlayer.getUserName()}</td>
						<td>${iPlayer.getFullName()}</td>
						<td>${iPlayer.getRoleName()}</td>
						<td class="rsHiddenSelection"><input type="checkbox" /></td>
					</tr>
				</sTag:forEach>
			</sTag:if>
		</table>
		
		<button class="btn btn-warning rsHiddenSelection pull-right" id="rsGenerateTournament">Generate</button>	
	</div>

	<div class="modal fade" id="rsModalAddPlayer" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Add new player</h4>
				</div>
				<div class="modal-body">

					<form:form id="rsAddPlayerForm" method="post" action="users" modelAttribute="playerViewBean">
						<form:label path="userName" class="form-control-label">Username:</form:label>
						<form:input path="userName" id="userName" class="form-control" name="userName" />
						<br />
						<form:label path="fullName" class="form-control-label">Full Name:</form:label>
						<form:input path="fullName" id="fullName" class="form-control" name="fullName" />
						<br />
						<input class="btn btn-primary" type="submit" value="Add" />
					</form:form>

				</div>
			</div>
		</div>
	</div>

<%@include file="base/BaseFooterView.jsp"%>
<script type="text/javascript" src="resources/js/controller/UsersControllerScript.js"></script>
		
</body>

</html>