package fr.eni.javaee.module4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTestPoolConnexion
 */
@WebServlet("/modules/module4/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			Context context = new InitialContext();
			
			/*
			 * 1- Recherche de la DataSource
			 */
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			
			/*
			 * 2- Demande de connexion
			 * La méthode getConnection met la demande en attente
			 * tant qu'il n'y a pas de connexions disponibles
			 * dans le pool
			 */
			Connection cnx = dataSource.getConnection();
			out.print("La connexion est " + (cnx.isClosed() ? "fermée" : "ouverte"));
			
			/*
			 * 3- Libérer la connexion quand on en n'a plus besoin
			 */
			cnx.close(); // La connexion n'est pas fermée, mais remise dans le pool
			
		} catch (NamingException | SQLException ex) {
			ex.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Un problème est survenu: " + ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
