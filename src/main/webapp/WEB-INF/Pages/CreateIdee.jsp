<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cr�ation d'id�e</title>
<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
<%@include file="commons/menu.jsp" %>

<h1>Cr�e votre propre id�e</h1>
	<form action="Idee?actionPost=cree" method="post">
	<input type="text" name="description" placeholder="Description"/>
	<input type="text"name="image" placeholder="url de l'image"/>
	<input type="text" name="categorie" placeholder="rentrez la cat�gorie"/>
	<br>
	<button class="btn waves-effect waves-light right" type="submit">Valider!</button>
	</form>
</div>
</body>
</html>