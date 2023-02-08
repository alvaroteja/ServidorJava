<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
<%
ResultSet rset = (ResultSet) request.getAttribute("rset");
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
	out.println("</body></html>");
	%>
</body>
</html>