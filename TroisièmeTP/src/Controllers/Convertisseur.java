package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Temperature;

/**
 * Servlet implementation class Convertisseur
 */
public class Convertisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Convertisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/convinput.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valCelsius=request.getParameter("celsius");
		if(valCelsius.isEmpty()){
			valCelsius="20";
		}
		 double celsius = Double.parseDouble(valCelsius);
         Temperature temp = new Temperature(celsius);
         request.setAttribute("celsius", temp.getCelsius());
         request.setAttribute("fahrenheit", temp.getFahrenheit());
         request.getRequestDispatcher("/WEB-INF/convoutput.jsp").forward(request, response);
	}

}
