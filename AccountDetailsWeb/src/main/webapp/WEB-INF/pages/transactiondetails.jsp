<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <head>
     <%@ page isELIgnored="false" %>
</head>

<a href="${pageContext.request.contextPath}">Go Home</a>
<form:form modelAttribute="transactionDetails" action="${pageContext.request.contextPath}/account-transaction-details/save-account-transaction-details">
	<table  align='center'>
				

				<tr><td>Enter Account Id</td><td><form:input path="accountId" /> </td></tr>
				<tr><td>Enter Transaction Type</td><td><form:input path="transactionType" /> </td></tr>
				<tr><td>Enter transaction Amount</td><td><form:input path="transactionAmount" /> </td></tr>
				<tr><td>Enter Transaction To </td><td><form:input path="transactionTo" /> </td></tr>
				<tr><td>Enter Transaction From </td><td><form:input path="transactionFrom" /> </td></tr>
				<tr><td></td><td><input value="Save Transaction Details" type="submit"/></td></tr>
		</table>

</form:form>

<c:if test="${resp.statusCode ne '200'}">
	<h4 align='center' style="color: red;">${resp.statusMessage}</h4>
</c:if>