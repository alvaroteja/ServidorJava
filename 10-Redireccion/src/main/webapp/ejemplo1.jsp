<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String mensaje = (String) request.getAttribute("mensaje"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.print(mensaje);%>
<h1>Hola soy el jsp</h1>
</body>
</html>
