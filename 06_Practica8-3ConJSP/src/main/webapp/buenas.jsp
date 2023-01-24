<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String bgColor = request.getParameter("bgColor");
boolean hayColor;
if (bgColor != null)
	hayColor = true;
else {
	hayColor = false;
	bgColor = "WHITE";
}
%>
</head>
<body BGCOLOR="<%=bgColor%>">
	<div class="content">
		<b>Bienvenido al curso</b>
		<p>
			Hoy es
			<%=Calendar.getInstance().getTime()%>
		</p>
		<%
		String saludo;
		int horaDelDia = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (horaDelDia < 12) {
			saludo = "Buenos dias!";
		} else if (horaDelDia >= 12 && horaDelDia < 21) {
			saludo = "Buenos tardes!";
		} else {
			saludo = "Buenos noches!";
		}
		%>
		<p><%=saludo%></p>
		<h1>Ejemplo de expresiones JSP</H1>
		<ul>
			<li>Fecha actual: <%=new java.util.Date()%>
			<li>Nombre del host: <%=request.getRemoteHost()%>
			<li>ID de la sesi´on: <%=session.getId()%>
			<li>El par´ametro es: <%=request.getParameter("nombre")%>
		</ul>

	</div>

	<h1>Ejemplo de scriptlets JSP</h1>
	<%
	if (hayColor)
		out.println("Se ha utilizado el color: " + bgColor);
	else
		out.println("Se ha utilizado el color por defecto: WHITE");
	%>
</body>
</html>