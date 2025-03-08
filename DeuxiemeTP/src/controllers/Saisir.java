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
 * Servlet implementation class Saisir
 */
public class Saisir extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArrayList<Produit> produits = new ArrayList<Produit>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saisir() {
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
            produits = new ArrayList<Produit>();
            session.setAttribute("produits", produits);
        }
        
        // Display the list of products
        displayProductList(out, produits);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        ArrayList<Produit> produits = (ArrayList<Produit>)session.getAttribute("produits");
        
        if(produits == null) {
            produits = new ArrayList<Produit>();
            session.setAttribute("produits", produits);
        }
        
        String intitule = request.getParameter("intitule");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int qt = Integer.parseInt(request.getParameter("qt"));
        
        produits.add(new Produit(intitule, prix, qt));
        
        // Display the list of products
        displayProductList(out, produits);
    }
    
    // Helper method to display the product list with edit and delete links
    private void displayProductList(PrintWriter out, ArrayList<Produit> produits) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Liste des produits</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h2>Les produits</h2>");
        
        if (produits.isEmpty()) {
            out.println("<p>Aucun produit n'a été ajouté.</p>");
        } else {
            out.println("<table>");
            out.println("<tr><th>Intitule</th><th>Prix</th><th>Quantite</th><th>Actions</th></tr>");
            
            for(int i = 0; i < produits.size(); i++) {
                Produit p = produits.get(i);
                out.println("<tr>");
                out.println("<td>" + p.getIntitule() + "</td>");
                out.println("<td>" + p.getPrix() + " €</td>");
                out.println("<td>" + p.getQt() + "</td>");
                out.println("<td>");
                out.println("<a href='Edit?index=" + i + "'>Editer</a> | ");
                out.println("<a href='Delete?index=" + i + "'>Supprimer</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
        }
        
        out.println("<p><a href='SaisirProduit.html'>Ajouter un nouveau produit</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}