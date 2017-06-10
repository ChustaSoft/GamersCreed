<%@include file="base/BaseHeaderView.jsp"%>

<body>

	<div class="container" id=mainViewContainer>
		<div class="row" id="pwd-container">
			<div class="col-md-4"></div>

			<div class="col-md-4">
				<section class="login-form">
					<form:form id="loginForm" method="post" action="login" modelAttribute="loginViewBean">
						<form:label path="userName">Enter your user-name</form:label>
						<form:input id="userName" name="userName" path="userName" class="form-control input-lg" />
						<form:label path="userPassword">Please enter your password</form:label>
						<form:password id="userPassword" name="userPassword" path="userPassword" class="form-control input-lg" />
						<input type="submit" value="Entrar" class="btn btn-lg btn-primary btn-block" />
					</form:form>					
				</section>
			</div>

			<div class="col-md-4"></div>

		</div>
		
		<%@include file="base/BaseFooterView.jsp"%>
	</div>

</body>

</html>
