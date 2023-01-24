
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

/**
 * Servlet implementation class FormularioServlet
 */
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormularioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>hola</h1>");
		try {
			String nombre = request.getParameter("nombre");
			String clave = request.getParameter("clave");
			String genero = request.getParameter("genero");
			String FechaNacimiento = request.getParameter("FechaNacimiento");
			String selectorSimple = request.getParameter("selectorSimple");
			String[] pais = request.getParameterValues("pais");
			String acepto = request.getParameter("acepto");
			String comentario = request.getParameter("comentario");
			String oculto = request.getParameter("oculto");
			String[] colores = request.getParameterValues("colores");

			String nombreValidacion;
			String claveValidacion;
			String generoValidacion;
			String FechaNacimientoValidacion;
			String selectorSimpleValidacion;
			String paisValidacion;
			String aceptoValidacion;
			String comentarioValidacion;
			String ocultoValidacion;
			String coloresValidacion;

			// Validacion nombre
			if (nombre != null && nombre.length() > 0) {
				nombreValidacion = "ok";
			} else {
				nombreValidacion = "Nombre no introducido.";
			}
			request.setAttribute("nombre", nombre);
			request.setAttribute("nombreValidacion", nombreValidacion);

			// Validacion clave
			if (clave != null) {
				if (clave.length() >= 6 && clave.length() <= 12) {
					claveValidacion = "ok";
				} else {
					claveValidacion = "Clave no segura, introduce una clave entre 6 y 12 caracteres.";
				}
			} else {
				claveValidacion = "Clave no introducida.";
			}
			request.setAttribute("clave", clave);
			request.setAttribute("claveValidacion", claveValidacion);

			// Validacion genero
			if (genero != null) {
				if (genero.equals("masculino")) {
					generoValidacion = "ok";
				} else if (genero.equals("femenino")) {
					generoValidacion = "ok";
				} else {
					generoValidacion = "El genero no corresponde.";
				}
			} else {
				generoValidacion = "Genero no introducido.";
			}
			request.setAttribute("genero", genero);
			request.setAttribute("generoValidacion", generoValidacion);

			// Validacion fecha
			if (FechaNacimiento != null && FechaNacimiento.length() > 0) {
				try {
					LocalDate fecha = LocalDate.parse(FechaNacimiento);
					if (validacionEdad(fecha)) {
						FechaNacimientoValidacion = "ok";
					} else {
						FechaNacimientoValidacion = "Eres menor de edad.";
					}
				} catch (Exception e) {
					FechaNacimientoValidacion = "Formato de fecha incorrecto.";
				}
			} else {
				FechaNacimientoValidacion = "Fecha no introducida.";
			}
			request.setAttribute("FechaNacimiento", FechaNacimientoValidacion);
			request.setAttribute("FechaNacimientoValidacion", FechaNacimientoValidacion);

			// Validacion selectorSimple
			if (selectorSimple != null && selectorSimple.length() > 0) {
				selectorSimpleValidacion = "ok";
			} else {
				selectorSimpleValidacion = "Selector simple no especificado.";
			}
			request.setAttribute("selectorSimple", selectorSimple);
			request.setAttribute("selectorSimpleValidacion", selectorSimpleValidacion);

			// Validacion pais
			if (pais != null && pais.length > 0) {
				paisValidacion = "ok";
			} else {
				paisValidacion = "No se ha seleccionado ningun pais.";
			}
			//request.setAttribute("pais", paisValidacion);

			// Validacion acepto
			if (acepto != null && acepto.length() > 0 && acepto.equals("on")) {
				aceptoValidacion = "ok";
			} else {
				aceptoValidacion = "No se ha seleccionado la casilla 'Acepto'.";
			}
			request.setAttribute("acepto", acepto);
			request.setAttribute("aceptoValidacion", aceptoValidacion);

			// Validacion comentario
			if (comentario == null) {
				comentarioValidacion = "No hay ningun comentario.";
			} else if (comentario.length() <= 0) {
				comentarioValidacion = "No se ha escrito ningun comentario.";
			} else if (comentario.length() > 0) {
				comentarioValidacion = "ok";
			} else {
				comentarioValidacion = "Error al enviar el comentario.";
			}
			request.setAttribute("comentario", comentario);
			request.setAttribute("comentarioValidacion", comentarioValidacion);

			// Validacion oculto
			if (oculto != null && oculto.length() > 0) {
				ocultoValidacion = "ok";
			} else {
				ocultoValidacion = "Campo oculto no se ha enviado correctamente.";
			}
			request.setAttribute("oculto", oculto);
			request.setAttribute("ocultoValidacion", ocultoValidacion);

			// Validacion colores
			if (colores != null && colores.length > 0) {
				coloresValidacion = "ok";
			} else {
				coloresValidacion = "No se ha seleccionado ningun color.";
			}
			//request.setAttribute("colores", coloresValidacion);

			out.println("nombnre = " + nombre + "</br>");
			out.println("clave = " + clave + "</br>");
			out.println("genero = " + genero + "</br>");
			out.println("FechaNacimiento = " + FechaNacimiento + "</br>");
			out.println("selectorSimple = " + selectorSimple + "</br>");
			if (pais != null && pais.length > 0) {
				for (int i = 0; i < pais.length; i++) {
					out.println("pais = " + pais[i] + "</br>");
				}
			}
			out.println("acepto = " + acepto + "</br>");
			out.println("comentario = " + comentario + "</br>");
			out.println("oculto = " + oculto + "</br>");
			if (colores != null && colores.length > 0) {
				for (int i = 0; i < colores.length; i++) {
					out.println("color = " + pais[i] + "</br>");
				}
			}
			out.println("</br>nombreValidacion = " + nombreValidacion + "</br>");
			out.println("claveValidacion = " + claveValidacion + "</br>");
			out.println("generoValidacion = " + generoValidacion + "</br>");
			out.println("FechaNacimientoValidacion = " + FechaNacimientoValidacion + "</br>");
			out.println("selectorSimpleValidacion = " + selectorSimpleValidacion + "</br>");
			out.println("paisValidacion = " + paisValidacion + "</br>");
			out.println("aceptoValidacion = " + aceptoValidacion + "</br>");
			out.println("comentarioValidacion = " + comentarioValidacion + "</br>");
			out.println("ocultoValidacion = " + ocultoValidacion + "</br>");
			out.println("coloresValidacion = " + coloresValidacion + "</br>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formulario.jsp");
			dispatcher.forward(request, response);
		} finally {

		}
	}

	protected boolean validacionEdad(LocalDate fecha) {
		if (calcularEdad(fecha) >= 18) {
			return true;
		} else {
			return false;
		}
	}

	public static int calcularEdad(LocalDate fecha) {
		LocalDate curDate = LocalDate.now();
		if ((fecha != null) && (curDate != null)) {
			return Period.between(fecha, curDate).getYears();
		} else {
			return 0;
		}
	}

}
