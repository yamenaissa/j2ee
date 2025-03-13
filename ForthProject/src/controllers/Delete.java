package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Personne;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {String indexStr = request.getParameter("index");
		if (indexStr != null && !indexStr.isEmpty()) {
				int index = Integer.parseInt(indexStr);
				HttpSession session = request.getSession();
				List<Personne> personnes = (List<Personne>) session.getAttribute("personnes");

				if (personnes != null && index >= 0 && index < personnes.size()) {
					personnes.remove(index);
					session.setAttribute("personnes", personnes);
				}
		}
		response.sendRedirect("AjoutServlet");
	}
}