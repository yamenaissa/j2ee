package monocontrole;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Verification1
 */
public class Verification1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     String nom = request.getParameter("nom");
	     String prenom = request.getParameter("prenom");
	     String login = request.getParameter("login");
	     String mp = request.getParameter("mp");
	     if (login.equals("admin") && mp.equals("password")) { 
	            out.println("<html><body>");
	            out.println("<h1>you did it mr, " + nom + " " + prenom + "!</h1>");
	            out.println("</body></html>");
	        }else{
	    	out.println("<html><body>");
	    	out.println("you failed try another ");
	    	out.println("</body></html>");
	    }
	}

}
