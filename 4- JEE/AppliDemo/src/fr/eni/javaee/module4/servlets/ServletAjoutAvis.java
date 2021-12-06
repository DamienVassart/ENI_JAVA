package fr.eni.javaee.module4.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.module4.BusinessException;
import fr.eni.javaee.module4.bll.AvisManager;
import fr.eni.javaee.module4.bo.Avis;

/**
 * Servlet implementation class ServletAjoutAvis
 */
@WebServlet("/modules/module4/ServletAjoutAvis")
public class ServletAjoutAvis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutAvis() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
     * Redirige vers la JSP qui contient le formulaire d'ajout d'avis
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module4/demonstrations/ajoutAvis.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * Est appelée quand on soumet un avis depuis la JSP d'ajout d'avis
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String description;
		int note;
		try
		{
			/*
			 * Récupération de la saisie de l'utilisateur (description et note)
			 * -> On essaye de convertir la note en entier
			 */
			description = request.getParameter("description");
			note= Integer.parseInt(request.getParameter("note"));
			/*
			 * Appel à la couche BLL
			 */
			AvisManager avisManager = new AvisManager();
			Avis avis = avisManager.ajouter(description, note);
			
			/*
			 * Si tout s'est bien passé, la requête génère un nouvel avis, qui sera transféré dans la réponse
			 */
			request.setAttribute("avis", avis);
		}
		catch(NumberFormatException e) // en cas d'erreur au niveau de la note (si la valeur de celle-ci n'est pas de type numérique)
		{
			List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_AVIS_NOTE_ERREUR);
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			
		} catch (BusinessException e) { // en cas d'erreur dans l'appel aux couches sous-jacentes (BLL et DAL)
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur()); // on récupère les erreurs générées dans la BLL et/ou dans la DAL
		}
		
		/*
		 * On appelle la JSP d'ajout d'avis pour afficher le résultat du traitement de la requête
		 * -> L'avis si succès
		 * -> Le message d'erreur le cas échéant
		 */
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module4/demonstrations/ajoutAvis.jsp");
		rd.forward(request, response); // transmission du résultat de la requête (succès ou erreur/exception)
	}

}
