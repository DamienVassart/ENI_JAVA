package fr.eni.javaee.module5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLisantUnParametreDApplication
 */
@WebServlet("/modules/module5/ServletLisantUnParametreDApplication")
public class ServletLisantUnParametreDApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailAdmin = this.getServletContext().getInitParameter("EMAIL_ADMINISTRATEUR");
		PrintWriter out = response.getWriter();
		out.println("L'email de l'administrateur est: " + emailAdmin);
		out.println("L'information est accessible depuis toutes les servlets et JSP");
		out.println("Depuis une JSP, il faut écrire: application.getInitParameter(\"EMAIL_ADMINISTRATEUR\");");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
