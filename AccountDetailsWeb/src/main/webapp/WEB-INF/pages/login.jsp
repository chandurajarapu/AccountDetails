<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <head>
     <%@ page isELIgnored="false" %>
</head>

<div style="text-align: left;">
	<a href="${pageContext.request.contextPath}">Go Home</a>
</div>
<form:form modelAttribute="loginDetails" action="${pageContext.request.contextPath}/login/get-login-details-by-username-password">
	<table  align='center'>
				<tr><td>Enter User Name</td><td><form:input path="userName" /> </td></tr>
				<tr><td>Enter User Password</td><td><form:password path="userPassword" /></td></tr>
				<%-- <tr><td>Enter User Password</td><td><form:select path="firstName" value="">
					<c:forEach var="state" items="${stateNames}">
						<form:option value="${state}"/>
					</c:forEach>
				</form:select></td></tr> --%>
				<tr><td><a href="${pageContext.request.contextPath}/forgotpassword">Forgot password ?</a></td><td><input value="Login" type="submit"/></td></tr>
		</table>

</form:form>

<c:if test="${resp.statusCode ne '200'}">
	<h4 align='center' style="color: red;">${resp.statusMessage}</h4>
</c:if>

