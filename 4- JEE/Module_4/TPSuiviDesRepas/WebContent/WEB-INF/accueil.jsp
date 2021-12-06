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
	<a href="<%=request.getContextPath() %>/ServletAjoutRepas">Ajouter un repas</a><br>
	<a href="<%=request.getContextPath() %>/ServletVisualisationRepas">Historique des repas</a>
</body>
</html>