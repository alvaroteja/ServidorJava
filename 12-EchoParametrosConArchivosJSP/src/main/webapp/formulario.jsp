<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="paqueteClases.Scriptlets ,paqueteClases.Datos"%>


<%
// Variables recuperadas
String nombre = (String) request.getAttribute("nombre");
nombre = nombre != null ? nombre : "";

String clave = (String) request.getAttribute("clave");
clave = clave != null ? clave : "";

String genero = (String) request.getAttribute("genero");
String generoMasculino = genero != null && genero.equals("masculino") ? "checked" : "";
String generoFemenino = genero != null && genero.equals("femenino") ? "checked" : "";

String FechaNacimiento = (String) request.getAttribute("FechaNacimiento");
FechaNacimiento = FechaNacimiento != null ? FechaNacimiento : "";

String selectorSimple = (String) request.getAttribute("selectorSimple");
selectorSimple = selectorSimple != null ? selectorSimple : "";

String[] pais = (String[]) request.getAttribute("pais");
pais = pais != null ? pais : new String[0];


String acepto = (String) request.getAttribute("acepto");
acepto = acepto != null && acepto.equals("on") ? "checked" : "";

String comentario = (String) request.getAttribute("comentario");
comentario = comentario != null ? comentario : "";

String oculto = (String) request.getAttribute("oculto");
oculto = oculto != null ? oculto : "";

String[] colores = (String []) request.getAttribute("colores");
colores = colores != null ? colores : new String[0];

String nombreValidacion = (String) request.getAttribute("nombreValidacion");
String claveValidacion = (String) request.getAttribute("claveValidacion");
String generoValidacion = (String) request.getAttribute("generoValidacion");
String FechaNacimientoValidacion = (String) request.getAttribute("FechaNacimientoValidacion");
String selectorSimpleValidacion = (String) request.getAttribute("selectorSimpleValidacion");
String paisValidacion = (String) request.getAttribute("paisValidacion");
String aceptoValidacion = (String) request.getAttribute("aceptoValidacion");
String comentarioValidacion = (String) request.getAttribute("comentarioValidacion");
String ocultoValidacion = (String) request.getAttribute("ocultoValidacion");
String coloresValidacion= (String) request.getAttribute("coloresValidacion");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	width: 100vw;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}

form {
	background-color: white;
	box-shadow: 0 0 15px 5px rgba(0, 0, 0, 0.2);
	padding: 40px;
	border-radius: 10px;
	text-align: center;
	font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
		sans-serif;
}

form>* {
	margin-top: 20px;
}

label {
	display: inline-block;
	font-weight: bold;
}
</style>
</head>
<body>
	<form action="FormularioServlet" method="post">
		<label>Nombre:</label>
		<input type="text" name="nombre" value="<%=nombre%>" /> <br />
		<label>Clave:</label>
		<input type="password" name="clave" value="<%=clave%>" /> <br />
		<label>Genero:</label>
		<label>Masculino:</label>
		<input type="radio" name="genero" value="masculino" <%=generoMasculino%> />
		<label>Femenino:</label>
		<input type="radio" name="genero" value="femenino" <%=generoFemenino%> /> <br />
		<label>Fecha de nacimiento (YYYY-MM-DD):</label>
		<input type="date" name="FechaNacimiento" value="<%=FechaNacimiento%>"> <br />
		<label>Selector simple:</label>
		<!-- <select name="selectorSimple" >
			<option value="Espana" >Espana</option>
			<option value="Francia" >Francia</option>
			<option value="Italia" >Italia</option>
		</select> -->
		<%=Scriptlets.generaSelectSimple("selectorSimple", Datos.arrayValoresYEtiquetasSimple, selectorSimple)%>
		<br />
		<label>Paises:</label>
		<br />
		<!--  <select name="pais" id="pais" multiple>
			<option value="Portugal">Portugal</option>
			<option value="Espana">Espa???a</option>
			<option value="Francia">Francia</option>
			<option value="Italia">Italia</option>
		</select> -->
		<%=Scriptlets.generaSelectMultiple("pais", Datos.arrayValoresYEtiquetasMultiple, pais, 3)%>
		<br />
		<label>Acepto:</label>
		<input type="checkbox" name="acepto" <%=acepto%> /> <br />
		<label>Comentario:</label>
		<textarea name="comentario" placeholder="texto de ejemplo"><%=comentario%></textarea>
		<input type="hidden" name="oculto" value="aa" /><br />
		<!-- <label class="margen">colores:</label>
		<br />
		<label>amarillo:</label>
		<input type="checkbox" name="colores" value="amarillo" />
		<label>rojo:</label>
		<input type="checkbox" name="colores" value="rojo" />
		<label>verde:</label>
		<input type="checkbox" name="colores" value="verde" />
		<label>azul:</label>
		<input type="checkbox" name="colores" value="azul" /> -->
		<%=Scriptlets.generaArrayCajasChequeo("colores", Datos.arrayColores,colores)%>
		<br /> <input type="submit" />
	</form>
</body>
</html>
