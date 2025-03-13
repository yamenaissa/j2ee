package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import models.Personne;

public final class Affichage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Affichage des personnes</title>\r\n");
      out.write("<style>\r\n");
      out.write("table {\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\twidth: 80%;\r\n");
      out.write("\tmargin: 20px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th,td {\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\tbackground-color: #f2f2f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tpadding: 5px 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-link {\r\n");
      out.write("\tmargin-right: 10px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: blue;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".delete-link {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<h1>Liste des personnes saisies</h1>\r\n");
      out.write("\r\n");

	List<Personne> personnes = (List<Personne>) session
			.getAttribute("personnes");
	if (personnes != null && !personnes.isEmpty()) {

      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Nom</th>\r\n");
      out.write("\t\t<th>Prénom</th>\r\n");
      out.write("\t\t<th>Sexe</th>\r\n");
      out.write("\t\t<th>Code Postal</th>\r\n");
      out.write("\t\t<th>Actions</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

		for (int i = 0; i < personnes.size(); i++) {
				Personne p = personnes.get(i);
	
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>");
      out.print(p.getNom());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(p.getPrenom());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(p.getSexe());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(p.getCodePostal());
      out.write("</td>\r\n");
      out.write("\t\t<td><a href=\"Edit?index=");
      out.print(i);
      out.write("\" class=\"action-link\">Modifier</a>\r\n");
      out.write("\t\t<a href=\"Delete?index=");
      out.print(i);
      out.write("\"class=\"action-link delete-link\">Supprimer</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("</table>\r\n");

	} else {

      out.write("\r\n");
      out.write("<p>Aucune personne n'a été saisie.</p>\r\n");

	}

      out.write(" <a href=\"SaisiePersonne.html\" class=\"button\">Ajouter une\r\n");
      out.write("nouvelle personne</a></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
