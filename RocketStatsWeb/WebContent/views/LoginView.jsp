<%@include file="base/BaseHeaderView.jsp"%>

<body>

	<form:form id="loginForm" method="post" action="login" modelAttribute="loginViewBean">
		<form:label path="userName">Enter your user-name</form:label>
		<form:input id="userName" name="userName" path="userName" />
		<br />
		<form:label path="userPassword">Please enter your password</form:label>
		<form:password id="userPassword" name="userPassword" path="userPassword" />
		<br />
		<input type="submit" value="Submit" />
	</form:form>

	<%@include file="base/BaseFooterView.jsp"%>
		
</body>

</html>
