
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Contador
 */
public class Contador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {

			int i;
			if (request.getCookies() != null) {

				Cookie[] arrayCookies = request.getCookies();
				String contenidoCookie = "";
				int longitud = arrayCookies.length;

				boolean cookieEncontrada = false;

				if (arrayCookies != null && longitud > 0) {
					for (i = 0; i < longitud && !cookieEncontrada; i++) {
						String nombreCookie = arrayCookies[i].getName();
						if (nombreCookie.equals("cont")) {
							cookieEncontrada = true;
							contenidoCookie = arrayCookies[i].getValue();
						}
					}

					if (cookieEncontrada) {
						out.println("<h1>Hola usuario, tu Cookie es " + contenidoCookie + "</h1>");
						aumentarContador(contenidoCookie, response, request);
					} else {
						out.print("<h1>El usuario no tiene la cookie uid.</h1>");
						crearCookie("cont", response, request);
					}
				} else {
					out.print("<h1>No hay ninguna Cookie</h1>");
					crearCookie("cont", response, request);
				}
			} else {
				out.print("<h1>No hay ninguna Cookie en el navegador</h1>");
				crearCookie("cont", response, request);
			}
		} catch (Exception e) {
			out.println("Se produce una excepci???n <br />");
			e.printStackTrace(out);
		} finally {
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void crearCookie(String nombreCookie, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		Cookie contador = new Cookie(nombreCookie, "1");
		response.addCookie(contador);
		
		request.setAttribute("contador", "1");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/respuesta.jsp");
		dispatcher.forward(request, response);
	}

	protected void aumentarContador(String contenidoCookie, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		int n = Integer.parseInt(contenidoCookie);
		n++;
		Cookie contador = new Cookie("cont", Integer.toString(n));
		response.addCookie(contador);
		
		request.setAttribute("contador", Integer.toString(n));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/respuesta.jsp");
		dispatcher.forward(request, response);
	}
}
