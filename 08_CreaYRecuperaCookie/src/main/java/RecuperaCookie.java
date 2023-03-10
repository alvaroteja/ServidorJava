
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RecuperaCookie
 */
public class RecuperaCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecuperaCookie() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Crea y Recupera</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Recupera Cookie</h1>");
			out.println("<h2>Cookies recibidas:</h2>");

			int i;

			Cookie[] arrayCookies = request.getCookies();
			int longitud = arrayCookies.length;

			if (arrayCookies != null && longitud > 0) {
				for (i = 0; i < longitud; i++) {
					String nombreCookie = arrayCookies[i].getName();
					String[] contenidoCookie = arrayCookies[i].getValue().split("&");
					out.print("Nombre: <b>" + nombreCookie + "</b>" + " <br />");
					out.print("Contenido: " + "<br />");
					for	(int j = 0; j < contenidoCookie.length; j++) {
						out.print(contenidoCookie[j] + "<br />");
					}
				}
			} else {
				out.print("El navegador no ha enviado ninguna cookie");
			}

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Se produce una excepci�n <br />");
			e.printStackTrace(out);
		} finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
