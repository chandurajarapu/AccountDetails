<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <head>
     <%@ page isELIgnored="false" %>
</head>


<a href="${pageContext.request.contextPath}">Log Out</a>

<p style="color: green;">${resp.statusMessage}</p>
<h3 style="color: blue;">${userName}</h3>