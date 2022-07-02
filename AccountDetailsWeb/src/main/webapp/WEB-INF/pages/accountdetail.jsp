<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <head>
     <%@ page isELIgnored="false" %>
</head>

<a href="${pageContext.request.contextPath}">Go Home</a>
<form:form modelAttribute="accountDetails" action="${pageContext.request.contextPath}/account-details/save-account-details">
	<table  align='center'>
				<tr><td>Enter Aadhar Number</td><td><form:input path="aadharNumber" /> </td></tr>
				<tr><td>Enter Account Type</td><td><form:input path="accountType" /> </td></tr>
				<tr><td>Enter Amount</td><td><form:input path="amount" /> </td></tr>
				<tr><td></td><td><input value="Save Account Details" type="submit"/></td></tr>
		</table>

</form:form>

<c:if test="${resp.statusCode ne '200'}">
	<h4 align='center' style="color: red;">${resp.statusMessage}</h4>
</c:if>