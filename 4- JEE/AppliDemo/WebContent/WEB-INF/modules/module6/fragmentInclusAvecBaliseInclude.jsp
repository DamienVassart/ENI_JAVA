<h3>Voici les informations lues dans le fichier fragemntInclusAvecBaliseInclude.jsp</h3>

<p>
	<%
		String bonjour = "bonjour tout le monde";
	%>
	<%= bonjour %>
</p>

<p>
	Lecture du paramètre "parametre" : <%=request.getParameter("parametre") %>
</p>

<p>
	Lecture de l'attribut "attribut" : <%=request.getAttribute("attribut") %>
</p>