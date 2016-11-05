<%@include file="base/BaseHeaderView.jsp"%>

<body>

	<form:form id="loginForm" method="post" action="login" modelAttribute="playerBean">

		<form:label path="username">Enter your user-name</form:label>
		<form:input id="username" name="username" path="username" />
		<br />
		<form:label path="username">Please enter your password</form:label>
		<form:password id="password" name="password" path="password" />
		<br />
		<input type="submit" value="Submit" />
	</form:form>

	<%@include file="base/BaseFooterView.jsp"%>
		
</body>

</html>
