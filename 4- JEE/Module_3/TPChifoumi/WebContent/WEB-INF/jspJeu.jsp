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
<title>Jouer</title>
</head>
<body>
	<h1>Jouer</h1>
	<form action="<%=request.getContextPath()%>/ServletTraitement" method="post">
		<input type="radio" value="<%=ChoixPossibles.CHI%>" name="choix" id="choix<%=ChoixPossibles.CHI%>"><label for="choix<%=ChoixPossibles.CHI%>"> CHI</label>
		<input type="radio" value="<%=ChoixPossibles.FOU%>" name="choix" id="choix<%=ChoixPossibles.FOU%>"><label for="choix<%=ChoixPossibles.FOU%>"> FOU</label>
		<input type="radio" value="<%=ChoixPossibles.MI%>" name="choix" id="choix<%=ChoixPossibles.MI%>"><label for="choix<%=ChoixPossibles.MI%>"> MI</label>
		<input type="submit" value="Valider">
	</form>
</body>
</html>