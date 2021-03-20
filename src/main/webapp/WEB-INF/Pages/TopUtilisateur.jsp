<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des idées</title>
<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
<%@include file="commons/menu.jsp" %>

<h1>Top Brain! </h1>

<table>
 <c:forEach var="i" items="${listIdee}" >
    <tr>
    	 <td><c:out value="${i.utilisateur.mail}"></c:out></td>
	     <td><c:out value="${i.description}"></c:out></td>
	     <td><c:out value="${i.date}"></c:out></td>
    </tr>
 </c:forEach>
 </table>

<a class="waves-effect waves-light btn" href="Idees?action=create">Ajouter votre commentaire! </a>

</div>

</body>
</html>