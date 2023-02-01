
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import Clases.Punto;

/**
 * Servlet implementation class CrearSesion
 */
public class CrearSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Esto es crear Sesion</h1>");
		// Vaiamos la sison si existe
		if (request.getSession(false) != null) {
			request.getSession().invalidate();
		}
		// se crea la sesion
		HttpSession laSesion = request.getSession(true);

		Enumeration enumarionAtributos;
		String nombreAtributo, valorAtributo;
		enumarionAtributos = laSesion.getAttributeNames();
		while (enumarionAtributos.hasMoreElements()) {
			nombreAtributo = enumarionAtributos.nextElement().toString();
			valorAtributo = laSesion.getAttribute(nombreAtributo).toString();
			out.println(nombreAtributo + " = " + valorAtributo);
		}

		int entero = 12;
		double real = 3.1416;
		String texto = "Hola sesion";
		Date fecha = new Date();
		Map<String, String> semaforo = new LinkedHashMap<String, String>();
		semaforo.put("R", "Rojo");
		semaforo.put("A", "Amarillo");
		semaforo.put("V", "Verde");
		Punto unPunto = new Punto(2, 3);

		laSesion.setAttribute("entero", entero);
		laSesion.setAttribute("real", real);
		laSesion.setAttribute("texto", texto);
		laSesion.setAttribute("fecha", fecha);
		laSesion.setAttribute("semaforo", semaforo);
		laSesion.setAttribute("unPunto", unPunto);
		
		enumarionAtributos = laSesion.getAttributeNames();
		while (enumarionAtributos.hasMoreElements()) {
			nombreAtributo = enumarionAtributos.nextElement().toString();
			valorAtributo = laSesion.getAttribute(nombreAtributo).toString();
			out.println(nombreAtributo + " = " + valorAtributo);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RecuperaSesion");
		dispatcher.forward(request, response);

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

}
