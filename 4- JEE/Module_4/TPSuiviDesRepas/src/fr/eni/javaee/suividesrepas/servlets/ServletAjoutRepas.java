package fr.eni.javaee.suividesrepas.servlets;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bll.RepasManager;

/**
 * Servlet implementation class ServletAjoutRepas
 */
@WebServlet("/ServletAjoutRepas")
public class ServletAjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ajout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		LocalDate dateRepas = null;
		LocalTime heureRepas = null;
		List<String> listeAliments = null;
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		String lectureDateRepas = request.getParameter("date_repas");
		String lectureHeureRepas = request.getParameter("heure_repas");
		String lectureListeAliments = request.getParameter("liste_aliments");
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dateRepas = LocalDate.parse(lectureDateRepas, formatter);
		} catch (DateTimeException ex) {
			ex.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_DATE_REPAS_ERREUR);
		}
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			heureRepas = LocalTime.parse(lectureHeureRepas, formatter);
		} catch (DateTimeException ex) {
			ex.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_HEURE_REPAS_ERREUR);
		}
		
		if(lectureListeAliments == null || lectureListeAliments.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ALIMENTS_REPAS_ERREUR);
		} else {
			listeAliments = new ArrayList<String>();
			String[] aliments = lectureListeAliments.split(",");
			for(String aliment : aliments) {
				listeAliments.add(aliment);
			}
		}
		
		if(listeCodesErreur.size() > 0) {
			request.setAttribute("listeCodesErreur", listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ajout.jsp");
			rd.forward(request, response);
		} else {
			RepasManager repasManager = new RepasManager();
			try {
				repasManager.ajouter(dateRepas, heureRepas, listeAliments);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/historique.jsp");
				rd.forward(request, response);
			} catch (BusinessException ex) {
				request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
			}
		}
		
	}

}
