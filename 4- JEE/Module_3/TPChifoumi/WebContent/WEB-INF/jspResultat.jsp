<%@ page import="fr.eni.tp.module3.bo.ChoixPossibles" %>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="jspErreur.jsp"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat</title>
</head>
<body>
	<%
		int choixJoueur = (int)request.getAttribute("choixJoueur");
		int choixMachine = (int)request.getAttribute("choixMachine");
		int resultat = (int)request.getAttribute("resultat");
		String[] libelles = {"CHI", "FOU", "MI"};
	%>
	
	<h1>Résultat</h1>
	
	<p>Votre choix: <%=libelles[choixJoueur - 1] %></p>
	<p>Le choix de la machine: <%=libelles[choixMachine - 1] %></p>
	<p>
		Résultat: <%=request.getAttribute("resultat") %>
		<%
			if(resultat == 0)
				out.write("Egalité !");
			else if(resultat == 1 || resultat == -2)
				out.write("Vous avez gagné !");
			else if(resultat == -1 || resultat == 2)
				out.write("Vous avez perdu !");
		%>
	</p>
	
	<a href="<%=request.getContextPath()%>/jouer">Rejouer</a>
</body>
</html>