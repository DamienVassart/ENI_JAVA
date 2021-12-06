package fr.eni.javaee.suividesrepas.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bll.RepasManager;
import fr.eni.javaee.suividesrepas.bo.Repas;

/**
 * Servlet implementation class ServletVisualisationRepas
 */
@WebServlet("/ServletVisualisationRepas")
public class ServletVisualisationRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RepasManager repasManager = new RepasManager();
		try {
			List<Repas> listeRepas = repasManager.selectionnerTousLesRepas();
			request.setAttribute("listeRepas", listeRepas);
		} catch (BusinessException ex) {
			ex.printStackTrace();
			request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/historique.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
