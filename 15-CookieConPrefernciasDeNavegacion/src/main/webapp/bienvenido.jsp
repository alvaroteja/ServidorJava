<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="Scriptlets.scriptlets1"%>
<%
//inicializo nombre a usuario e intento capturar nombre del objeto request si existe y no está vacío
String nombreUsuario = "usuario";
int contador = 1;
String checkBox = "espanol";

if (request.getSession(false) != null) {
	nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
	contador = (int) request.getSession().getAttribute("contador");
	checkBox = (String) request.getSession().getAttribute("checkBox");
}

%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="style2.css" />
</head>
<body>
	<div class="contenedor">
		<p>
			Bienvenido <strong><%=nombreUsuario%> </strong>
		</p>
		<form action="guardaCookie" method="post">
			<%=scriptlets1.crearRadioButton(checkBox)%>
			<input type="hidden" name="nombreUsuarioYContador" value="<%=nombreUsuario%>&<%=contador%>"> <input type="submit" value="Desconectar">
		</form>
		<p id="contador">
			Nº de visitas: <strong><%=contador%></strong>
		</p>
	</div>
</body>
</html>