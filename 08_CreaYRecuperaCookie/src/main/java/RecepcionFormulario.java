
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RecepcionFormulario
 */
public class RecepcionFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecepcionFormulario() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// se inicializa un objeto Cookie "vac�o"
		String nombreCookie = "";
		String contenidoCookie = "";
		String clave = "";
		String idioma = "";
		Cookie unaCookie = null;

		// Recepci�n de par�metros
		nombreCookie = request.getParameter("nombreCookie");
		clave = request.getParameter("clave");
		idioma = request.getParameter("idioma");

		contenidoCookie = nombreCookie + "&" + clave + "&" + idioma;

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Crea y Recupera</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet Crea y Recupera</h1>");
		out.println("<h1>" + nombreCookie + "," + clave + "," + idioma + "</h1>");

		try {
			// se crea el objeto cookie en el servidor
			unaCookie = new Cookie(nombreCookie, contenidoCookie);

			// se a�ade a la respuesta para enviar al cliente
			response.addCookie(unaCookie);

			out.println("Se crea una cookie de nombre " + nombreCookie);
			out.println("<br />");
			out.println("El contenido de la cookie es " + contenidoCookie);
			out.println("<br />");
		} catch (Exception e) {
			out.println("Se produce una excepci�n: ");
			out.println(e.getMessage());
			out.println("<br />");
		} finally {
			out.println("<a href=\"RecuperaCookie\">Ir a RecuperaCookie <a/> ");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}
}
