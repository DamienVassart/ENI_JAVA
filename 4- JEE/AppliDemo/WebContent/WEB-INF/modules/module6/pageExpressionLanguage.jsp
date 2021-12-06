<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page affichant une voiture</title>
</head>
<body>
	<h1>Page affichant une voiture avec l'Expression Language si elle a été créée</h1>
	
	<a href="">Rafraîchir</a>
	
	<ul>
		<li>
			Marque: ${requestScope['voiture'].marque} <!-- ou ${requestScope.voiture.marque} ou ${voiture.marque} -->
		</li>
		<li>
			Modèle: ${requestScope.voiture.modele}
		</li>
		<li>
			Immatriculation: ${voiture.immatriculation} 
		</li>
		<li>
			Kilométrage: ${voiture.kilometrage} 
		</li>
	</ul>
	
	<a href="demonstrations/demonstration3.html">Retour</a>
</body>
</html>