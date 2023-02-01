<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.ArrayList, Clases.Producto, java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
	HttpSession sesion = request.getSession();
	ArrayList<Producto> listaProductos = (ArrayList) sesion.getAttribute("produ");
	%>
	<div class="carrito">
		<p class="etiqueta">Carrito:</p>
		<%
		for (int i = 0; i < listaProductos.size(); i++) {
			out.println("<div class='productoCarrito'><div class='columna'><p class='etiqueta'>Producto:</p><p class='producto'>"
			+ listaProductos.get(i).getProducto() + "</p></div><div class='columna'><p class='etiqueta'> Precio:</p><p class='pvp'>"
			+ listaProductos.get(i).getPvp() + "</p></div></div>");
		}
		%>
	</div>
	<div class="productos">
		<form action="RecepcionFormulario" method="post">
			<div class="fila1">
				<div class="contenedor idProducto">
					<p class="etiqueta">ID Producto:</p>
					<p class="idProducto">1</p>
				</div>
				<div class="contenedor stockActual">
					<p class="etiqueta">Stock Actual:</p>
					<p class="stockActual">50</p>
				</div>
				<div class="contenedor stockMinimo">
					<p class="etiqueta">Stock Mínimo:</p>
					<p class="stockMinimo">5</p>
				</div>
				<div class="contenedor producto">
					<p class="etiqueta">producto:</p>
					<p class="producto">Ratón</p>
				</div>
				<div class="contenedor pvp">
					<p class="etiqueta">PVP:</p>
					<p class="pvp">20€</p>
				</div>
				<input class="contenedor boton" type="submit" value="Añadir" />
			</div>
			<div class="fila2">
				<div class="contenedor descripcion">
					<p class="etiqueta">Descripcion:</p>
					<p class="descripcion">Presentando este mouse Vendetta de Forgeon puedo decirte que te encuentras ante el ratón más competente del mercado.
						Este mouse ha sido por varios años consecutivos elegido el mejor mouse gaming en cuanto a su diseño. Dispone de diferentes botones que te
						generan todos los atajos y prestaciones que necesites al alcance de tu mano y lleva también un sensor que regula la velocidad que quieras en
						cada momento. Con el mouse Vendetta lo ganarás todo.</p>
				</div>
			</div>
			<input type="hidden" name="idProductoH" value="1" /> <input type="hidden" name="stockActualH" value="50" /> <input type="hidden"
				name="stockMinimoH" value="5" /> <input type="hidden" name="productoH" value="raton" /> <input type="hidden" name="descripcionH"
				value="Presentando este mouse Vendetta de Forgeon puedo decirte que te encuentras ante el ratón más competente del mercado. Este mouse ha sido por varios años consecutivos elegido el mejor mouse gaming en cuanto a su diseño. Dispone de diferentes botones que te generan todos los atajos y prestaciones que necesites al alcance de tu mano y lleva también un sensor que regula la velocidad que quieras en cada momento. Con el mouse Vendetta lo ganarás todo." />
			<input type="hidden" name="pvpH" value="20" />
		</form>
		<form action="RecepcionFormulario" method="post">
			<div class="fila1">
				<div class="contenedor idProducto">
					<p class="etiqueta">ID Producto:</p>
					<p class="idProducto">2</p>
				</div>
				<div class="contenedor stockActual">
					<p class="etiqueta">Stock Actual:</p>
					<p class="stockActual">27</p>
				</div>
				<div class="contenedor stockMinimo">
					<p class="etiqueta">Stock Mínimo:</p>
					<p class="stockMinimo">10</p>
				</div>
				<div class="contenedor producto">
					<p class="etiqueta">producto:</p>
					<p class="producto">Teclado</p>
				</div>
				<div class="contenedor pvp">
					<p class="etiqueta">PVP:</p>
					<p class="pvp">80€</p>
				</div>
				<input class="contenedor boton" type="submit" value="Añadir" />
			</div>
			<div class="fila2">
				<div class="contenedor descripcion">
					<p class="etiqueta">Descripcion:</p>
					<p class="descripcion">Combina lo mejor de ambas tecnologías para darte una sensación de uso muy superior al resto, la tecnología Híbrida ha
						llegado para quedarse y este teclado es buena muestra de ello. Además, en Tempest no se quedan cortos en cuanto a iluminación y cuenta con hasta
						13 modos de iluminación RGB diferente tanto en las teclas como alrededor del teclado, lo cual aporta una sensación ultra gaming. Tu teclado
						brillará como nunca has visto nada igual. Pero esto no es todo, Tempest piensa cada detalle de su producto y gracias a su reposamuñecas
						acolchado, su uso será realmente cómodo, permitiendo un uso prolongado si que acuses cansancio o desgaste. No nos equivocamos si decimos que no
						has visto un teclado igual, podrás ponerlo a juego con tu setup y se convertirá en tu mejor escudero durante la batalla. Si todo esto te parece
						poco, el teclado está fabricado en aluminio de alta calidad lo cual aporta un extra de durabilidad y una sensación premium, que hará que tu
						teclado dure mucho más tiempo y resista todo tipo de uso diario.</p>
				</div>
			</div>
			<input type="hidden" name="idProductoH" value="2" /> <input type="hidden" name="stockActualH" value="27" /> <input type="hidden"
				name="stockMinimoH" value="10" /> <input type="hidden" name="productoH" value="teclado" /> <input type="hidden" name="descripcionH"
				value="Combina lo mejor de ambas tecnologías para darte una sensación de uso muy superior al resto, la tecnología Híbrida ha llegado para quedarse y este teclado es buena muestra de ello. Además, en Tempest no se quedan cortos en cuanto a iluminación y cuenta con hasta 13 modos de iluminación RGB diferente tanto en las teclas como alrededor del teclado, lo cual aporta una sensación ultra gaming. Tu teclado brillará como nunca has visto nada igual. Pero esto no es todo, Tempest piensa cada detalle de su producto y gracias a su reposamuñecas acolchado, su uso será realmente cómodo, permitiendo un uso prolongado si que acuses cansancio o desgaste. No nos equivocamos si decimos que no has visto un teclado igual, podrás ponerlo a juego con tu setup y se convertirá en tu mejor escudero durante la batalla. Si todo esto te parece poco, el teclado está fabricado en aluminio de alta calidad lo cual aporta un extra de durabilidad y una sensación premium, que hará que tu teclado dure mucho más tiempo y resista todo tipo de uso diario." />
			<input type="hidden" name="pvpH" value="80" />
		</form>
		<form action="RecepcionFormulario" method="post">
			<div class="fila1">
				<div class="contenedor idProducto">
					<p class="etiqueta">ID Producto:</p>
					<p class="idProducto">3</p>
				</div>
				<div class="contenedor stockActual">
					<p class="etiqueta">Stock Actual:</p>
					<p class="stockActual">18</p>
				</div>
				<div class="contenedor stockMinimo">
					<p class="etiqueta">Stock Mínimo:</p>
					<p class="stockMinimo">10</p>
				</div>
				<div class="contenedor producto">
					<p class="etiqueta">producto:</p>
					<p class="producto">Monitor</p>
				</div>
				<div class="contenedor pvp">
					<p class="etiqueta">PVP:</p>
					<p class="pvp">250€</p>
				</div>
				<input class="contenedor boton" type="submit" value="Añadir" />
			</div>
			<div class="fila2">
				<div class="contenedor descripcion">
					<p class="etiqueta">Descripcion:</p>
					<p class="descripcion">Nuestra serie de monitores gaming Icarus da la bienvenida al modelo de 27” QHD 144Hz R1500 VA - IC27Q4-V2P. Este nuevo
						monitor de Newskill está diseñado para aquellos jugadores exigentes en cuanto a resolución y calidad de imagen. Con una interesante tasa de
						refresco de hasta 144Hz, resolución 2560x1440P “2K” y compatible tanto con G-Sync como con FreeSync, nuestro nuevo Icarus es lo que necesitas
						para llevar tu set-up al siguiente nivel.</p>
				</div>
			</div>
			<input type="hidden" name="idProductoH" value="3" /> <input type="hidden" name="stockActualH" value="18" /> <input type="hidden"
				name="stockMinimoH" value="10" /> <input type="hidden" name="productoH" value="monitor" /> <input type="hidden" name="descripcionH"
				value="Nuestra serie de monitores gaming Icarus da la bienvenida al modelo de 27” QHD 144Hz R1500 VA - IC27Q4-V2P. Este nuevo monitor de Newskill está diseñado para aquellos jugadores exigentes en cuanto a resolución y calidad de imagen. Con una interesante tasa de refresco de hasta 144Hz, resolución 2560x1440P “2K” y compatible tanto con G-Sync como con FreeSync, nuestro nuevo Icarus es lo que necesitas para llevar tu set-up al siguiente nivel." />
			<input type="hidden" name="pvpH" value="250" />
		</form>
		<form action="RecepcionFormulario" method="post">
			<div class="fila1">
				<div class="contenedor idProducto">
					<p class="etiqueta">ID Producto:</p>
					<p class="idProducto">4</p>
				</div>
				<div class="contenedor stockActual">
					<p class="etiqueta">Stock Actual:</p>
					<p class="stockActual">85</p>
				</div>
				<div class="contenedor stockMinimo">
					<p class="etiqueta">Stock Mínimo:</p>
					<p class="stockMinimo">20</p>
				</div>
				<div class="contenedor producto">
					<p class="etiqueta">producto:</p>
					<p class="producto">Auriculares</p>
				</div>
				<div class="contenedor pvp">
					<p class="etiqueta">PVP:</p>
					<p class="pvp">35€</p>
				</div>
				<input class="contenedor boton" type="submit" value="Añadir" />
			</div>
			<div class="fila2">
				<div class="contenedor descripcion">
					<p class="etiqueta">Descripcion:</p>
					<p class="descripcion">El día que esperabas ha llegado y Tempest GHS301 Barbarian estarán contigo en esa batalla. Tempest sube de nivel con
						los auriculares gaming definitivos. Estos auriculares disponen de unos altavoces 7.1 virtual de alta calidad estéreo con materiales de última
						generación, llevando el estatus de nuestra marca a un nuevo nivel.</p>
				</div>
			</div>
			<input type="hidden" name="idProductoH" value="4" /> <input type="hidden" name="stockActualH" value="85" /> <input type="hidden"
				name="stockMinimoH" value="20" /> <input type="hidden" name="productoH" value="auriculares" /> <input type="hidden" name="descripcionH"
				value="El día que esperabas ha llegado y Tempest GHS301 Barbarian estarán contigo en esa batalla. Tempest sube de nivel con los auriculares gaming definitivos. Estos auriculares disponen de unos altavoces 7.1 virtual de alta calidad estéreo con materiales de última generación, llevando el estatus de nuestra marca a un nuevo nivel. " />
			<input type="hidden" name="pvpH" value="35" />
		</form>
		<form action="RecepcionFormulario" method="post">
			<div class="fila1">
				<div class="contenedor idProducto">
					<p class="etiqueta">ID Producto:</p>
					<p class="idProducto">5</p>
				</div>
				<div class="contenedor stockActual">
					<p class="etiqueta">Stock Actual:</p>
					<p class="stockActual">15</p>
				</div>
				<div class="contenedor stockMinimo">
					<p class="etiqueta">Stock Mínimo:</p>
					<p class="stockMinimo">5</p>
				</div>
				<div class="contenedor producto">
					<p class="etiqueta">producto:</p>
					<p class="producto">Altavoces</p>
				</div>
				<div class="contenedor pvp">
					<p class="etiqueta">PVP:</p>
					<p class="pvp">99€</p>
				</div>
				<input class="contenedor boton" type="submit" value="Añadir" />
			</div>
			<div class="fila2">
				<div class="contenedor descripcion">
					<p class="etiqueta">Descripcion:</p>
					<p class="descripcion">Bose Companion 2 Series III Altavoces multimedia. ¿Te encanta reproducir música, juegos y vídeos en tu ordenador?
						¡Actualiza tu sonido y tu experiencia! Hazlo con el sistema de altavoces multimedia Companion 2 Series III. Disfrutarás de su rendimiento, que
						es considerablemente mejor que el de tus altavoces originales: y es nuestro sistema de altavoces para ordenador más asequible.</p>
				</div>
			</div>
			<input type="hidden" name="idProductoH" value="5" /> <input type="hidden" name="stockActualH" value="15" /> <input type="hidden"
				name="stockMinimoH" value="5" /> <input type="hidden" name="productoH" value="altavoces" /> <input type="hidden" name="descripcionH"
				value="Bose Companion 2 Series III Altavoces multimedia. ¿Te encanta reproducir música, juegos y vídeos en tu ordenador? ¡Actualiza tu sonido y tu experiencia! Hazlo con el sistema de altavoces multimedia Companion 2 Series III. Disfrutarás de su rendimiento, que es considerablemente mejor que el de tus altavoces originales: y es nuestro sistema de altavoces para ordenador más asequible." />
			<input type="hidden" name="pvpH" value="99" />
		</form>
	</div>
</body>
</html>
