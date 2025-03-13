package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Personne;

public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String indexStr = request.getParameter("index");

		if (indexStr != null && !indexStr.isEmpty()) {
			int index = Integer.parseInt(indexStr);
			HttpSession session = request.getSession();
			List<Personne> personnes = (List<Personne>) session
					.getAttribute("personnes");

			if (personnes != null && index >= 0 && index < personnes.size()) {
				Personne personne = personnes.get(index);
				request.setAttribute("personne", personne);
				request.setAttribute("index", index);
				request.getRequestDispatcher("/Edit.jsp").forward(
						request, response);
				return;
			}
		}
		response.sendRedirect("AjoutServlet");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String indexStr = request.getParameter("index");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String sexe = request.getParameter("sexe");
		String codePostalStr = request.getParameter("codePostal");

		if (indexStr != null && !indexStr.isEmpty() && nom != null
				&& !nom.isEmpty() && prenom != null && !prenom.isEmpty()
				&& sexe != null && !sexe.isEmpty() && codePostalStr != null
				&& !codePostalStr.isEmpty()) {
			int index = Integer.parseInt(indexStr);
			int codePostal = Integer.parseInt(codePostalStr);
			HttpSession session = request.getSession();
			List<Personne> personnes = (List<Personne>) session
					.getAttribute("personnes");

			if (personnes != null && index >= 0 && index < personnes.size()) {
				Personne personne = personnes.get(index);
				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setSexe(sexe);
				personne.setCodePostal(codePostal);
				session.setAttribute("personnes", personnes);
			}

		}
		response.sendRedirect("AjoutServlet");
	}
}