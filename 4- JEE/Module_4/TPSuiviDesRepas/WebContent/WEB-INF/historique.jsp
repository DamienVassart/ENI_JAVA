<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.javaee.suividesrepas.messages.LecteurMessage" %>
<%@page import="fr.eni.javaee.suividesrepas.bo.Repas" %>
<%@page import="fr.eni.javaee.suividesrepas.bo.Aliment" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historique des repas</title>
</head>
<body>
	<h1>Historique</h1>
	
	<%
		List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
		if(listeCodesErreur != null) {
	%>
			<p>Erreur lors de la récupération des données</p>
	<%		
		}
		for(int codeErreur : listeCodesErreur) {
	%>
			<p><%=LecteurMessage.getMessageErreur(codeErreur) %></p>
	<%		
		}
		List<Repas> listeRepas = (List<Repas>) request.getAttribute("listeRepas");
		if(listeRepas != null && listeRepas.size() > 0) {
			for(Repas repas : listeRepas) {
	%>
				<span>Date: <%=repas.getDate() %></span>&nbsp;<span>Heure: <%=repas.getHeure() %></span>&nbsp;
				<span>
					<%
						for(Aliment aliment : repas.getListeAliments()) {
					%>
						<%=aliment.getNom() %>, &nbsp;
					<%
						}
					%>
				</span>
				<br>
	<%
			}
		}
	%>
	
	<a href="<%=request.getContextPath() %>/ServletAjoutRepas">Ajouter un repas</a>
	<a href="<%=request.getContextPath() %>/accueil">Accueil</a>
</body>
</html>