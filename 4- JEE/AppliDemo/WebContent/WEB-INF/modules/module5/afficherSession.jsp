<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage du contenu de la session</title>
</head>
<body>
	<%
		if(session.getAttribute("compteurAcces")!=null)
		{
			int compteurAcces = (int)session.getAttribute("compteurAcces");
	%>
			<p>Nombre d'accès : <%=compteurAcces%></p> 
	<%
		}
		else
		{
	%>
			<p>Le compteur d'accès n'existe pas en session</p>
	<%
		}
	%>
	<p>
		Avec le lien suivant, le suivi de session n'est assuré que si les cookies sont autorisés :
		<a href="<%=request.getContextPath()%>/modules/module5/ServletManipulationSession">ServletManipulationSession (sans réécriture d'URL)</a>
	</p>
	<p>
		Avec le lien suivant, le suivi de session est assuré même si les cookies ne sont pas autorisés :
		<a href="<%=response.encodeURL(request.getContextPath()+"/modules/module5/ServletManipulationSession")%>">ServletManipulationSession (avec réécriture d'URL)</a>
	</p>
	<p>
		Voici l'URL réécrite :
		<%=response.encodeURL(request.getContextPath()+"/modules/module5/ServletManipulationSession")%>
	</p>
	<p>
		<a href="demonstrations/demonstration3.html">Retour à la page d'accueil de la démonstration</a>
	</p>
</body>
</html>     