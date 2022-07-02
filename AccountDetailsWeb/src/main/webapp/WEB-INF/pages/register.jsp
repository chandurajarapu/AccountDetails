<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <head>
     <%@ page isELIgnored="false" %>
</head>
<a href="${pageContext.request.contextPath}">Go Home</a>
<form:form modelAttribute="registerDetails" action="${pageContext.request.contextPath}/login/save-login-details">
	<table  align='center'>
				<tr><td>Enter First Name</td><td><form:input path="firstName" /> </td></tr>
				<tr><td>Enter Last Name</td><td><form:input path="lastName" /> </td></tr>
				<tr><td>Enter Middle Name</td><td><form:input path="middileName" /> </td></tr>
				<tr><td>Enter User Name</td><td><form:input path="userName" /> </td></tr>
				<tr><td>Enter Aadhar Number</td><td><form:input path="aadharNumber" /> </td></tr>
				<tr><td>Enter Pan Number</td><td><form:input path="panNumber" /> </td></tr>
				<tr><td>Enter Mobile Number</td><td><form:input path="mobileNumber" /> </td></tr>
				<tr><td>Enter Email Address</td><td><form:input path="emailAddress" /></td></tr>
				<tr><td><a href="${pageContext.request.contextPath}/login">Login(If already registred)</a></td><td><input value="Login Register" type="submit"/></td></tr>
		</table>

</form:form>

<c:if test="${resp.statusCode ne '200'}">
	<h4 align='center' style="color: red;">${resp.statusMessage}</h4>
</c:if>