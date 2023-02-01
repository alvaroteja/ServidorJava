
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
			if (request.getParameter("restarProducto") != null) {
				HttpSession session = request.getSession(true);

				ArrayList<Producto> listaProductos = (ArrayList) session.getAttribute("produ");

				int idARestar = Integer.parseInt(request.getParameter("restarProducto"));

				boolean productoEncontrado = false;
				for (int i = 0; i < listaProductos.size() && !productoEncontrado; i++) {
					int idProducto = listaProductos.get(i).getIdproducto();
					if (idARestar == idProducto) {
						System.out.print("producto encontrado");
						int cantidadActual = listaProductos.get(i).getCantidad();

						if (cantidadActual > 1) {
							listaProductos.get(i).setCantidad(cantidadActual - 1);
						} else {
							listaProductos.remove(i);
						}
						productoEncontrado = true;
					}
				}
			} else if (request.getParameter("eliminarProducto") != null) {
				HttpSession session = request.getSession(true);

				ArrayList<Producto> listaProductos = (ArrayList) session.getAttribute("produ");

				int idARestar = Integer.parseInt(request.getParameter("eliminarProducto"));

				boolean productoEncontrado = false;
				for (int i = 0; i < listaProductos.size() && !productoEncontrado; i++) {
					int idProducto = listaProductos.get(i).getIdproducto();
					if (idARestar == idProducto) {
						listaProductos.remove(i);
						productoEncontrado = true;
					}
				}
			} else if (request.getParameter("idProductoH") != null) {
				System.out.print("Se ha detectado in id " + request.getParameter("idProductoH"));
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
				HttpSession session = request.getSession(true);

				if (session.getAttribute("produ") != null) {
					ArrayList<Producto> listaProductos = (ArrayList) session.getAttribute("produ");
					boolean productoEncontrado = false;
					for (int i = 0; i < listaProductos.size(); i++) {
						int id = listaProductos.get(i).getIdproducto();
						if (id == idProducto) {
							listaProductos.get(i).setCantidad(listaProductos.get(i).getCantidad() + 1);
							productoEncontrado = true;
						}
					}
					if (productoEncontrado == false) {
						listaProductos.add(produ);
					}
					session.setAttribute("produ", listaProductos);
				} else {
					// Copio la lista de la seion y añado el nuevo objeto
					ArrayList<Producto> listaProductos = new ArrayList<Producto>();
					listaProductos.add(produ);

					// Meto la nueva lista en la sesion, reemplazando la atigua
					session.setAttribute("produ", listaProductos);
				}

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
			HttpSession session = request.getSession(false);
			if (session.getAttribute("produ") != null) {
				float precioTotal = 0;
				ArrayList<Producto> listaProductos = (ArrayList) session.getAttribute("produ");

				for (int i = 0; i < listaProductos.size(); i++) {
					float pvp = listaProductos.get(i).getPvp();
					int cantidad = listaProductos.get(i).getCantidad();
					precioTotal += (pvp * cantidad);
				}
				session.setAttribute("precioTotal", precioTotal);
			}
			// Redirecciono al jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productos.jsp");
			dispatcher.forward(request, response);
		}
	}

}
