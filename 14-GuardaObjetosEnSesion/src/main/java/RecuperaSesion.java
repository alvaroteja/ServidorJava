

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class RecuperaSesion
 */
public class RecuperaSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperaSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Esto es recupera Sesion</h1>");
		HttpSession laSesion = request.getSession(true);

		Enumeration enumarionAtributos;
		String nombreAtributo, valorAtributo;
		enumarionAtributos = laSesion.getAttributeNames();
		while (enumarionAtributos.hasMoreElements()) {
			nombreAtributo = enumarionAtributos.nextElement().toString();
			valorAtributo = laSesion.getAttribute(nombreAtributo).toString();
			out.println(nombreAtributo + " = " + valorAtributo);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
