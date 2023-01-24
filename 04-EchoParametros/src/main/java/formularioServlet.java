
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * Servlet implementation class formularioServlet
 */
public class formularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public formularioServlet() {
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

		// Establece el tipo MIME del mensaje de respuesta
		response.setContentType("text/html");
		// Crea un flujo de salida para escribir la respuesta a la petici´on del cliente
		PrintWriter out = response.getWriter();
		// Escribe el mensaje de respuesta en una p´agina html
		try {
			out.println("<html>");
			out.println("<head><title>Formulario</title></head>");
			out.println("<body>");
			out.println("<h1>Nombre: " + request.getParameter("nombre") + "</h1>");

			// validacion contraseña
			if (validacionContrasena(request.getParameter("calve"))) {
				out.println("<h1>clave: " + request.getParameter("calve") + "</h1>");
			} else {
				out.println("<h1>clave: esta clave no es válida.</h1>");
			}
			out.println("<h1>genero: " + request.getParameter("genero") + "</h1>");

			// validacion de edad.
			String f = request.getParameter("FechaNacimiento");
			if (f.length() != 0) {
				LocalDate fecha = LocalDate.parse(f);
				if (validacionEdad(fecha)) {
					out.println("<h1>Eres mayor de edad, tienes " + calcularEdad(fecha) + " años.</h1>");
				} else {
					out.println("<h1>No eres mayor de edad, tienes " + calcularEdad(fecha) + " años.</h1>");
				}
			} else {
				out.println("<h1>Fecha no introducida.</h1>");
			}
			out.println("<h1>Selector simple: " + request.getParameter("selectorSimple") + "</h1>");
			out.println("<h1>Acepto: " + request.getParameter("acepto") + "</h1>");
			out.println("<h1>Comentario: " + request.getParameter("comentario") + "</h1>");
			out.println("<h1>hidden: " + request.getParameter("custId") + "</h1>");

			String paises[] = request.getParameterValues("pais");

			out.println("<h1>paises:");
			if (paises != null) {
				for (int i = 0; i < paises.length; i++) {
					out.println(paises[i] + ", ");
				}
			}
			out.println("</h1>");

			String colores[] = request.getParameterValues("colores");
			out.println("<h1>colores:");
			if (paises != null) {
				for (int i = 0; i < colores.length; i++) {
					out.println(colores[i] + ", ");
				}
			}
			out.println("</h1>");

			out.println("<h1>campos del formulario:");
			Enumeration enumeration = request.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String parameterName = (String) enumeration.nextElement();
				out.println(parameterName + ", ");
			}

			out.println("</body></html>");
		} finally {
			out.close(); // Cierra el flujo de salida
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected boolean validacionContrasena(String contrasena) {
		if (contrasena.length() >= 6 && contrasena.length() <= 12) {
			return true;
		} else {
			return false;
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
