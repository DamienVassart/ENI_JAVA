<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Une page affichant du texte</title>
</head>
<body>
	<%
		if(session.getAttribute("couleurTexte") != null) {
			String couleurTexte = (String) session.getAttribute("couleurTexte");
	%>
	<h1>Titre</h1>
	
	<p style="color:<%=couleurTexte %>;">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	</p>
	<%
		}
	%>
	
	<a href="<%=request.getContextPath() %>/ServletPreferencesDUsage">Retour</a>
</body>
</html>