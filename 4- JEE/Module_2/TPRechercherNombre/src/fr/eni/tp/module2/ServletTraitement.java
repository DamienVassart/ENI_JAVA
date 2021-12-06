package fr.eni.tp.module2;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTraitement
 */
@WebServlet(
		urlPatterns="/ServletTraitement",
		initParams= {
				@WebInitParam(description="Valeur min", name="min", value="0"),
				@WebInitParam(description="Valeur max", name="max", value="10")
		}
		
)
public class ServletTraitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int random;
	private int min = 0;
	private int max = 10;
	
	private boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	@Override
	public void init() throws ServletException {
		String nouveauMin = this.getInitParameter("min");
		if(nouveauMin != null && !nouveauMin.equals("")) {
			if(isNumeric(nouveauMin))
				this.min = Integer.parseInt(nouveauMin);
		}
		
		String nouveauMax = this.getInitParameter("max");
		if(nouveauMax != null && !nouveauMax.equals("")) {
			if(isNumeric(nouveauMax))
				this.max = Integer.parseInt(nouveauMax);
		}
		
		this.random = new Random().nextInt(this.max - this.min +1) + this.min;
		super.init();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tentative = request.getParameter("nombre");
		String redirectURL = tentative.equals(String.valueOf(this.random)) ? "succes.html" : "echec.html";
		
		response.sendRedirect(redirectURL);
	}

}
