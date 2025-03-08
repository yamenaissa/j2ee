package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Edit
 */
public class Edit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        ArrayList<Produit> produits = (ArrayList<Produit>)session.getAttribute("produits");
        
        if(produits == null) {
            response.sendRedirect("Saisir");
            return;
        }
        
        // Get the index of the product to edit
        int index = Integer.parseInt(request.getParameter("index"));
        
        if(index >= 0 && index < produits.size()) {
            Produit produit = produits.get(index);
            
            // Display edit form
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modifier un produit</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h2>Modifier un produit</h2>");
            out.println("<form action='Edit' method='post'>");
            out.println("<input type='hidden' name='index' value='" + index + "'>");
            out.println("<div>");
            out.println("<label>Intitule: </label>");
            out.println("<input type='text' name='intitule' value='" + produit.getIntitule() + "'>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Prix: </label>");
            out.println("<input type='text' name='prix' value='" + produit.getPrix() + "'>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Quantite: </label>");
            out.println("<input type='text' name='qt' value='" + produit.getQt() + "'>");
            out.println("</div>");
            out.println("<div>");
            out.println("<input type='submit' value='Enregistrer'>");
            out.println("<input type='button' value='Annuler' onclick='window.location.href=\"Saisir\"'>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            response.sendRedirect("Saisir");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        ArrayList<Produit> produits = (ArrayList<Produit>)session.getAttribute("produits");
        
        if(produits == null) {
            response.sendRedirect("Saisir");
            return;
        }
        
        // Get the index of the product to edit
        int index = Integer.parseInt(request.getParameter("index"));
        
        if(index >= 0 && index < produits.size()) {
            // Update the product
            String intitule = request.getParameter("intitule");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int qt = Integer.parseInt(request.getParameter("qt"));
            
            Produit produit = produits.get(index);
            produit.setIntitule(intitule);
            produit.setPrix(prix);
            produit.setQt(qt);
            
            // Redirect back to the product list
            response.sendRedirect("Saisir");
        } else {
            response.sendRedirect("Saisir");
        }
    }
}