<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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
		<label>Nombre:</label> <input type="text" name="nombre" /> <br /> <label>Clave:</label>
		<input type="password" name="clave" /> <br /> <label>Genero:</label>
		<label>Masculino:</label> <input type="radio" name="genero"
			value="masculino" /> <label>Femenino:</label> <input type="radio"
			name="genero" value="femenino" /> <br /> <label>Fecha de
			nacimiento (YYYY-MM-DD):</label> <input type="date" name="FechaNacimiento" />
		<br /> <label>Selector simple:</label> <select name="selectorSimple">
			<option value="value1">Value 1</option>
			<option value="value2">Value 2</option>
			<option value="value3">Value 3</option>
		</select> <br /> <label>Pa�s:</label> <br /> <select name="pais" id="pais"
			multiple>
			<option value="Portugal">Portugal</option>
			<option value="Espana">Espa�a</option>
			<option value="Francia">Francia</option>
			<option value="Italia">Italia</option>
		</select> <br /> <label>Acepto:</label> <input type="checkbox" name="acepto" />
		<br /> <label>Comentario:</label>
		<textarea name="comentario">texto de ejemplo</textarea>
		<input type="hidden" name="oculto" value="aa" /><br /> <label
			class="margen">colores:</label> <br /> <label>amarillo:</label> <input
			type="checkbox" name="colores" value="amarillo" /> <label>rojo:</label>
		<input type="checkbox" name="colores" value="rojo" /> <label>verde:</label>
		<input type="checkbox" name="colores" value="verde" /> <label>azul:</label>
		<input type="checkbox" name="colores" value="azul" /> <br /> <input
			type="submit" />
	</form>
</body>
</html>