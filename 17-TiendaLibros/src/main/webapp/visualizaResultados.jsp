<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
<%
ResultSet rset = (ResultSet) request.getAttribute("rset");

ServletContext context = config.getServletContext();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int count = 0;
	while (rset.next()) {
		out.println("<p>" + rset.getString("autor") + ", " + rset.getString("titulo") + ", " + rset.getDouble("precio")
		+ "</p>");
		count++;
	}
	out.println("<p>==== " + count + " registros encontrados =====</p>");
	
	Integer contador = (Integer)context.getAttribute("contador");
	out.println("<p>==== " + contador.intValue() + " peticiones *.jsp===</p>");
	out.println("<a href='http://localhost:8080/17-TiendaLibros/ConsultaLibros.jsp'>Link</a>");
	out.println("</body></html>");
	
	%>
</body>
</html>