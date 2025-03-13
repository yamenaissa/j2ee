package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Personne;

public final class Edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Éditer une personne</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        .container {\r\n");
      out.write("            width: 50%;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-group {\r\n");
      out.write("            margin-bottom: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        label {\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("        input, select {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        .btn {\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            background-color: #4CAF50;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            margin-right: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .btn-cancel {\r\n");
      out.write("            background-color: #f44336;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>Éditer une personne</h1>\r\n");
      out.write("        \r\n");
      out.write("        ");

        Personne personne = (Personne) request.getAttribute("personne");
        int index = (Integer) request.getAttribute("index");
        
        if (personne != null) {
        
      out.write("\r\n");
      out.write("        <form action=\"Edit\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"index\" value=\"");
      out.print( index );
      out.write("\">\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"nom\">Nom:</label>\r\n");
      out.write("                <input type=\"text\" id=\"nom\" name=\"nom\" value=\"");
      out.print( personne.getNom() );
      out.write("\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"prenom\">Prénom:</label>\r\n");
      out.write("                <input type=\"text\" id=\"prenom\" name=\"prenom\" value=\"");
      out.print( personne.getPrenom() );
      out.write("\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"sexe\">Sexe:</label>\r\n");
      out.write("                <select id=\"sexe\" name=\"sexe\">\r\n");
      out.write("                    <option value=\"Feminin\" ");
      out.print( "Feminin".equals(personne.getSexe()) ? "selected" : "" );
      out.write(">Feminin</option>\r\n");
      out.write("                    <option value=\"Masculin\" ");
      out.print( "Masculin".equals(personne.getSexe()) ? "selected" : "" );
      out.write(">Masculin</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"codePostal\">Code Postal:</label>\r\n");
      out.write("                <input type=\"number\" id=\"codePostal\" name=\"codePostal\" value=\"");
      out.print( personne.getCodePostal() );
      out.write("\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <input type=\"submit\" value=\"Enregistrer\" class=\"btn\">\r\n");
      out.write("                <a href=\"AjoutServlet\" class=\"btn btn-cancel\">Annuler</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("        <p>Personne non trouvée.</p>\r\n");
      out.write("        <a href=\"AjoutServlet\">Retour à la liste</a>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
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
