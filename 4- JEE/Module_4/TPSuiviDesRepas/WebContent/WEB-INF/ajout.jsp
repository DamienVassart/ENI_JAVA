<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.javaee.suividesrepas.messages.LecteurMessage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un repas</title>
</head>
<body>
	<h1>Ajouter un repas</h1>
	<%
		List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
		if(listeCodesErreur != null) {
	%>
			<p>Erreur: le repas n'a pas pu être ajouté</p>
	<%
		}
		for(int codeErreur : listeCodesErreur) {
	%>
			<p><%=LecteurMessage.getMessageErreur(codeErreur) %></p>
	<%
		}
	%>
	
	<form action="<%=request.getContextPath() %>/ServletAjoutRepas" method="post">
		<label for="date_repas">Date: </label>
		<input type="date" name="date_repas" id="date_repas">
		<label for="heure_repas">Heure: </label>
		<input type="time" name="heure_repas" id="heure_repas">
		<label for="liste_aliments">Repas: </label>
		<textarea name="liste_aliments" id="liste_aliments"></textarea>
		<input type="submit" value="Valider">
	</form>
	<button><a href="<%=request.getContextPath() %>/accueil">Annuler</a></button>
</body>
</html>