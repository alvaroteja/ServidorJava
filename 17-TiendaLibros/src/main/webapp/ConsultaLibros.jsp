<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
ServletContext context = config.getServletContext();
%>
<!DOCTYPE html>
<html>
<head>
<title>TiendaLibros</title>
</head>
<body>
	<h2>Tienda Libros</h2>
	<form method="post" action="ConsultaServlet">
		<b>Elige un autor:</b> <input type="checkbox" name="autor" value="Alvaro Garcia">Alvaro Garcia <input type="checkbox" name="autor"
			value="Aleksa Vukotic">Aleksa Vukotic <input type="checkbox" name="autor" value="Giulio Zambon">Giulio Zambon <input type="submit"
			value="Buscar">
	</form>
	<%
	Integer contador = (Integer) context.getAttribute("contador");
	out.println("<p>==== " + contador.intValue() + " peticiones *.jsp===</p>");

	out.println("</body></html>");
	%>
</body>
</html>