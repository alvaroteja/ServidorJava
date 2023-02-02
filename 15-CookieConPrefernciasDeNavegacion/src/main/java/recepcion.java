
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Servlet implementation class recepcion
 */
public class recepcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public recepcion() {
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

		// Se crea el hasmap con usuarios y contraseñas
		HashMap<String, String> usuariosPass = new HashMap<String, String>();
		usuariosPass.put("Alvaro", "alvaroasd");
		usuariosPass.put("Han", "hanasd");
		usuariosPass.put("Nico", "nicoasd");
		usuariosPass.put("Jose", "joseasd");
		Iterator<String> it = usuariosPass.keySet().iterator();

		// validaciones de los parametros
		boolean nombreHaSidoEnviado;
		boolean contrasenaHaSidoEnviada;
		if (request.getParameter("nombre") != null && request.getParameter("nombre").length() > 0) {
			nombreHaSidoEnviado = true;
		} else {
			nombreHaSidoEnviado = false;
		}
		if (request.getParameter("contrasena") != null && request.getParameter("contrasena").length() > 0) {
			contrasenaHaSidoEnviada = true;
		} else {
			contrasenaHaSidoEnviada = false;
		}
		// **************************************

		if (nombreHaSidoEnviado && contrasenaHaSidoEnviada) {
			// camturamos los parametros
			String nombre = request.getParameter("nombre");
			String contrasena = request.getParameter("contrasena");

			// testing
			out.print("<h1>Esto es recepcion</h1>");
			out.print("<h1>nombre: " + nombre + "</h1>");
			out.print("<h1>contrasena: " + contrasena + "</h1>");

			// Se valida el usuario y la contraseña

			boolean usuarioEncontrado = false;
			boolean usuarioValido = false;
			boolean contrasenaValida = false;
			while (it.hasNext() && !usuarioEncontrado) {
				String nombreH = it.next();
				if (nombre.equals(nombreH)) {
					usuarioEncontrado = true;
					usuarioValido = true;
					String contrasenaH = usuariosPass.get(nombreH);
					if (contrasena.equals(contrasenaH)) {
						contrasenaValida = true;
					}
				}
			}

			// Dependiendo de si nombre y contraseña estan bien o no
			if (usuarioValido && contrasenaValida) {
				// mandar a crear cookie
				Cookie[] arrayCookies = request.;
				if (arrayCookies == null || arrayCookies.length == 0) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bienvenido.jsp");
					dispatcher.forward(request, response);
//					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bienvenido");
//					dispatcher.forward(request, response);
				} else {
					out.print("<h1>cagaste</h1>");
					
					out.print(arrayCookies[0].getName());
				}

			} else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");

				request.setAttribute("usuarioValido", usuarioValido);
				request.setAttribute("nombre", request.getParameter("nombre"));
				request.setAttribute("contrasenaValida", contrasenaValida);
				request.setAttribute("contrasena", request.getParameter("contrasena"));

				dispatcher.forward(request, response);
			}
			out.print("<h1>usuarioValido: " + usuarioValido + "</h1>");
			out.print("<h1>contraseñaValida: " + contrasenaValida + "</h1>");
		} else {
			// Mandar para atras a decir que campo falta
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");

			request.setAttribute("nombreHaSidoEnviado", nombreHaSidoEnviado);
			request.setAttribute("nombre", request.getParameter("nombre"));
			request.setAttribute("contrasenaHaSidoEnviada", contrasenaHaSidoEnviada);
			request.setAttribute("contrasena", request.getParameter("contrasena"));

			dispatcher.forward(request, response);

		}
	}
}
