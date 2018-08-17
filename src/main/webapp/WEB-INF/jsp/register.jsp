<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="email">email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>   
				<td>
                <form:errors  path="email" cssClass = "error"/>
            </td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
					<td>
                <form:errors  path="password" cssClass = "error"/>
            </td>
			</tr>
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input path="firstname" name="firstname"
						id="firstname" /></td>
						<td>
                <form:errors  path="firstname" cssClass = "error"/>
            </td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" /></td>
			<td>
                <form:errors  path="lastname" cssClass = "error"/>
            </td>
			</tr>
			<tr>
				<td><form:label path="mobile">Phone</form:label></td>
				<td><form:input path="mobile" name="mobile" id="mobile" /></td>
				<td>
                <form:errors  path="mobile" cssClass = "error"/>
            </td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="/AppRegistration/">Login</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>