package fr.eni.javaee.preferencesdusage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletPreferencesDUsage
 */
@WebServlet("/ServletPreferencesDUsage")
public class ServletPreferencesDUsage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookieCompteur = null;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("cookieCompteur")) {
					cookieCompteur = c;
					int compteur = Integer.parseInt(cookieCompteur.getValue()) + 1;
					cookieCompteur.setValue(String.valueOf(compteur));
					break; // pas la peine de continuer à parcourir le tableau si on a trouvé le bon cookie...
				}
			}
		}
		
		if(cookieCompteur == null)
			cookieCompteur = new Cookie("cookieCompteur", "1");
		cookieCompteur.setMaxAge(Integer.MAX_VALUE);
		
		response.addCookie(cookieCompteur);
		request.setAttribute("cookieCompteur", cookieCompteur);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("couleurTexte", request.getParameter("couleur-texte"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/content.jsp");
		rd.forward(request, response);
	}

}
