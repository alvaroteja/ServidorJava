
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Clases.Producto;

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

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h1>Esto es recepcion</h1>");

		try {
			// Si vienen datos del formulario
			if (request.getParameter("idProductoH") != null) {
				// Capturo los datos enviados por el formulario
				int idProducto = Integer.parseInt(request.getParameter("idProductoH"));
				int stockActual = Integer.parseInt(request.getParameter("stockActualH"));
				int stockMinimo = Integer.parseInt(request.getParameter("stockMinimoH"));
				String producto = request.getParameter("productoH");
				String descripcion = request.getParameter("descripcionH");
				float pvp = Float.parseFloat(request.getParameter("pvpH"));

				// Creo un objeto con los datos del formulario
				Producto produ = new Producto(idProducto, stockActual, stockMinimo, producto, descripcion, pvp);

				// Inicio la sesion
				HttpSession session = request.getSession();

				// Copio la lista de la seion y añado el nuevo objeto
				ArrayList<Producto> listaProductos = (ArrayList<Producto>) session.getAttribute("produ");
				listaProductos.add(produ);

				// Meto la nueva lista en la sesion, reemplazando la atigua
				session.setAttribute("produ", listaProductos);

			}
			// Si no venimos desde el formulario
			else {
				// Creo una lista de productos vacia, inicio sesion y meto la lista en la sesion
				ArrayList<Producto> listaProductos = new ArrayList<Producto>();
				HttpSession session = request.getSession();
				session.setAttribute("produ", listaProductos);
			}

		} catch (Error e) {
		} finally {
			// Redirecciono al jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productos.jsp");
			dispatcher.forward(request, response);
		}
	}

}
