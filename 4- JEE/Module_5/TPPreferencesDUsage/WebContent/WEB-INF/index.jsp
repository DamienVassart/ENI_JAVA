<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>Accueil</h1>
	
	<form action="<%=request.getContextPath() %>/ServletPreferencesDUsage" method="post">
		<select name="couleur-texte" id="couleur-texte">
			<option value="<%=application.getInitParameter("Noir") %>">Noir</option>
			<option value="<%=application.getInitParameter("Rouge") %>">Rouge</option>
			<option value="<%=application.getInitParameter("Vert") %>">Vert</option>
			<option value="<%=application.getInitParameter("Bleu") %>">Bleu</option>
		</select>
		<input type="submit" value="Valider">
	</form>
	
	<%
		Cookie cookieCompteur = (Cookie) request.getAttribute("cookieCompteur");
	%>
	
	<p>Vous êtes venu(e) <%=cookieCompteur.getValue() %> fois</p>
	
</body>
</html>