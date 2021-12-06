package fr.eni.javaee.module5;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletManipulationCookie
 */
@WebServlet("/modules/module5/ServletManipulationCookie")
public class ServletManipulationCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletManipulationCookie() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // Permettra d'afficher une information dans le navigateur
		Cookie[] cookies = request.getCookies(); // On initialise un tableau de Cookies: la méthode getCookies récupère les cookies renvoyés par le navigateur sur le serveur 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		if(cookies==null)
		{
			out.println("Il n'y a pas de cookie.");
			out.println("C'est peut-être le premier passage de l'utilisateur.");
			out.println("Ou le fait qu'il n'accepte pas les cookies.");
			out.println("Date : " + sdf.format(new Date()));
			
			out.println();
			out.println("Voici les cookies nouvellement créés :");
			
			/*
			 * On crée 3 cookies
			 */
			for(int i=0;i<3;i++)
			{
				Random rd = new Random();
				Cookie unCookie = new Cookie("unNom_"+rd.nextInt(1000), "uneValeur_"+rd.nextInt(1000)); // clé = unNom_xxx | valeur = uneValeur_yyy où 0 ≤ (xxx et yyy) < 1000 
				unCookie.setMaxAge(rd.nextInt(10)); // durée de vie entre 0 et 9 secondes
				response.addCookie(unCookie); // on ajoute le cookie à la réponse
				out.println(unCookie.getName()+"="+unCookie.getValue()+", durée="+unCookie.getMaxAge()+" secondes.");
			}
		}
		else
		{
			out.println("Voici les cookies qui transitent entre le navigateur du client et le serveur :");
			for(Cookie unCookie:cookies)
			{
				out.println(unCookie.getName()+"="+unCookie.getValue());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
