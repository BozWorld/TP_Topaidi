<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topaidi</title>
    <%@include file="commons/header.jsp" %>

</head>
<body>

<div class="container">
 <%@include file="commons/menu.jsp" %>
 <h1>Voici le fil d'idée! </h1> 
 

 <c:forEach var="i" items="${listIdee}" >
    	 <img width="500px" height="350px" src="<c:out value="${i.photo}"/>"> <br>
    	 <c:out value="${i.description}">Description : </c:out> <br>
    	 <c:out value="${i.date}"> Date de publication : </c:out> <br>
 </c:forEach>
</div>

</body>
</html>