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
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
        
        // Get the index of the product to delete
        int index = Integer.parseInt(request.getParameter("index"));
        
        if(index >= 0 && index < produits.size()) {
            Produit produit = produits.get(index);
            
            // Display confirmation page
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Supprimer un produit</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h2>Supprimer un produit</h2>");
            out.println("<p class=\"delete-warning\">Êtes-vous sûr de vouloir supprimer ce produit ?</p>");
            out.println("<div class=\"product-info\">");
            out.println("<p><strong>Intitule:</strong> " + produit.getIntitule() + "</p>");
            out.println("<p><strong>Prix:</strong> " + produit.getPrix() + " €</p>");
            out.println("<p><strong>Quantite:</strong> " + produit.getQt() + "</p>");
            out.println("</div>");
            out.println("<form action='Delete' method='post'>");
            out.println("<input type='hidden' name='index' value='" + index + "'>");
            out.println("<input type='submit' value='Confirmer'>");
            out.println("<input type='button' value='Annuler' onclick='window.location.href=\"Saisir\"'>");
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
        
        // Get the index of the product to delete
        int index = Integer.parseInt(request.getParameter("index"));
        
        if(index >= 0 && index < produits.size()) {
            // Remove the product
            produits.remove(index);
            
            // Redirect back to the product list
            response.sendRedirect("Saisir");
        } else {
            response.sendRedirect("Saisir");
        }
    }
}