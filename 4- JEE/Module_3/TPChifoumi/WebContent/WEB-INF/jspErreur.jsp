<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur</title>
</head>
<body>
	<h1>Erreur: </h1>
	<p>
		(<%= exception %>) - <%= exception.getMessage() %>
	</p>
</body>
</html>