/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.4
 * Generated at: 2023-01-24 09:44:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class formulario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	width: 100vw;\r\n");
      out.write("	height: 100vh;\r\n");
      out.write("	display: flex;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form {\r\n");
      out.write("	background-color: white;\r\n");
      out.write("	box-shadow: 0 0 15px 5px rgba(0, 0, 0, 0.2);\r\n");
      out.write("	padding: 40px;\r\n");
      out.write("	border-radius: 10px;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	font-family: \"Gill Sans\", \"Gill Sans MT\", Calibri, \"Trebuchet MS\",\r\n");
      out.write("		sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form>* {\r\n");
      out.write("	margin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<form action=\"FormularioServlet\" method=\"post\">\r\n");
      out.write("		<label>Nombre:</label> <input type=\"text\" name=\"nombre\" /> <br /> <label>Clave:</label>\r\n");
      out.write("		<input type=\"password\" name=\"clave\" /> <br /> <label>Genero:</label>\r\n");
      out.write("		<label>Masculino:</label> <input type=\"radio\" name=\"genero\"\r\n");
      out.write("			value=\"masculino\" /> <label>Femenino:</label> <input type=\"radio\"\r\n");
      out.write("			name=\"genero\" value=\"femenino\" /> <br /> <label>Fecha de\r\n");
      out.write("			nacimiento (YYYY-MM-DD):</label> <input type=\"date\" name=\"FechaNacimiento\" />\r\n");
      out.write("		<br /> <label>Selector simple:</label> <select name=\"selectorSimple\">\r\n");
      out.write("			<option value=\"value1\">Value 1</option>\r\n");
      out.write("			<option value=\"value2\">Value 2</option>\r\n");
      out.write("			<option value=\"value3\">Value 3</option>\r\n");
      out.write("		</select> <br /> <label>Pa�s:</label> <br /> <select name=\"pais\" id=\"pais\"\r\n");
      out.write("			multiple>\r\n");
      out.write("			<option value=\"Portugal\">Portugal</option>\r\n");
      out.write("			<option value=\"Espana\">Espa�a</option>\r\n");
      out.write("			<option value=\"Francia\">Francia</option>\r\n");
      out.write("			<option value=\"Italia\">Italia</option>\r\n");
      out.write("		</select> <br /> <label>Acepto:</label> <input type=\"checkbox\" name=\"acepto\" />\r\n");
      out.write("		<br /> <label>Comentario:</label>\r\n");
      out.write("		<textarea name=\"comentario\">texto de ejemplo</textarea>\r\n");
      out.write("		<input type=\"hidden\" name=\"oculto\" value=\"aa\" /><br /> <label\r\n");
      out.write("			class=\"margen\">colores:</label> <br /> <label>amarillo:</label> <input\r\n");
      out.write("			type=\"checkbox\" name=\"colores\" value=\"amarillo\" /> <label>rojo:</label>\r\n");
      out.write("		<input type=\"checkbox\" name=\"colores\" value=\"rojo\" /> <label>verde:</label>\r\n");
      out.write("		<input type=\"checkbox\" name=\"colores\" value=\"verde\" /> <label>azul:</label>\r\n");
      out.write("		<input type=\"checkbox\" name=\"colores\" value=\"azul\" /> <br /> <input\r\n");
      out.write("			type=\"submit\" />\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}