<%@include file="base/BaseHeaderView.jsp"%>

<body>
	<header>
		<div class="container-fluid">
			<h1>Home</h1>			
		</div>
		
	<%@include file="base/MenuHeader.jsp"%>
	</header>
	
	<p>
		Inicio de la web de RocketStats
		${userSession.getUserName()}
	</p>	

	<%@include file="base/BaseFooterView.jsp"%>
	<script type="text/javascript" src="resources/js/controller/HomeControllerScript.js"></script>
</body>

</html>