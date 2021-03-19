<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
<%@include file="commons/menu.jsp" %>

<h1>Top idée </h1>

<form action="Utulisateur" method="post">
	<label for="utulisateur">adresse mail :</label> <input type="text"  name="utulisateurMail">
	<label for="password">mot de passe :</label> <input type="text"  name="password">
	<input type="submit" value="Valider" />
 </form>
</div>
</body>
</html>