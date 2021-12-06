package fr.eni.tp.module3;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTraitement
 */
@WebServlet("/ServletTraitement")
public class ServletTraitement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		runGame(request, response);
	}
	
	private void runGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String lectureChoixJoueur = request.getParameter("choix");
		int choixJoueur = 0;
			
		try {
			choixJoueur = Integer.parseInt(lectureChoixJoueur);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		
		int choixMachine = new Random().nextInt(3) + 1;
		int resultat = choixJoueur - choixMachine;
		
		request.setAttribute("choixJoueur", choixJoueur);
		request.setAttribute("choixMachine", choixMachine);
		request.setAttribute("resultat", resultat);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jspResultat.jsp");

		try {
			rd.forward(request, response);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

}
