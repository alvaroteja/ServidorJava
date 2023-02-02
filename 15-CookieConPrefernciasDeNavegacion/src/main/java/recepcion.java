
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
			// capturamos los parametros
			String nombre = request.getParameter("nombre");
			String contrasena = request.getParameter("contrasena");

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

				// Buscando la cookie con el nombre de usuario
				Cookie[] cookies = request.getCookies();
				Cookie ck = null;

				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals(nombre)) {
							ck = cookie;
							break;
						}
					}
				}
				// si no existe la cookie con el nombre de usuario vamos a bienvenido
				if (ck == null) {
					request.setAttribute("nombreUsuario", nombre);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bienvenido.jsp");
					dispatcher.forward(request, response);
				}
				// si existe la cookie con el nombre de usuario la manejamos
				else {
					// Sacando los valores de la cookie
					String contenidoCk[] = ck.getValue().split("&");
					int contador = Integer.parseInt(contenidoCk[0]);
					String checkBox = contenidoCk[1];
					String nombreUsuario = ck.getName();
					
					// incremento contador
					contador++;
					
					// preparo la nueva cookie que va a sustituir la anterior
					Cookie cknueva = new Cookie(nombreUsuario, contador + "&" + checkBox);
					response.addCookie(cknueva);
					
					// vamos a binvenido.jsp
					request.setAttribute("contador", contador);
					request.setAttribute("nombreUsuario", nombre);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bienvenido.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");

				request.setAttribute("usuarioValido", usuarioValido);
				request.setAttribute("nombre", request.getParameter("nombre"));
				request.setAttribute("contrasenaValida", contrasenaValida);
				request.setAttribute("contrasena", request.getParameter("contrasena"));

				dispatcher.forward(request, response);
			}
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
