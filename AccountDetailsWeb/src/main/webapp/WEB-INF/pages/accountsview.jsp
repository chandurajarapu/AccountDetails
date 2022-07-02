<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <%@ page isELIgnored="false" %>
    <style>
		table {
			border-collapse: collapse;
			width: 100%;
		}
		
		th, td {
			text-align: left;
			padding: 8px;
		}
		
		tr:nth-child(even) {
			background-color: #f2f2f2
		}
		
		th {
			background-color: #04AA6D;
			color: white;
		}
	</style>
</head>	


<div style="text-align: left">
		Welcome <b style="color: green;">${userName} </b>
</div>

<div style="text-align: right;">
	<a href="${pageContext.request.contextPath}">Log Out</a>
</div>

<div>
		<c:if test="${resp.statusCode eq '200' }">
			<table>
				<tr><th>Account Name</th><th>Account Type</th> <th>Account Balence</th> </tr>
				<c:forEach var="accountDetails" items="${resp.response}">
						<tr><td>${accountDetails.accountName}</td><td>${accountDetails.accountType}</td><td>${accountDetails.amount}</td></tr>
				</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${resp.statusCode ne '200' }">
			<p style="color: red">${resp.statusMessage}</p>
		</c:if>
		
		
		

</div>



