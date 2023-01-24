

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Servlet implementation class HolaMundoServlet
 */
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Establece el tipo MIME del mensaje de respuesta
		response.setContentType("text/html");
		// Crea un flujo de salida para escribir la respuesta a la petici´on del cliente
		PrintWriter out = response.getWriter();
		// Escribe el mensaje de respuesta en una p´agina html
		try {
		out.println("<html>");
		out.println("<head><title>Hola Mundo</title></head>");
		out.println("<body>");
		out.println("<h1>Hola Mundo</h1>"); // dice hola
		// Muestra informaci´on de la petici´on del cliente
		out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
		out.println("<p>Protocolo: " + request.getProtocol() + "</p>");
		out.println("<p>Direcci´on remota: " + request.getRemoteAddr() + "</p>");
		// Genera un n´umero aleatorio para cada petici´on
		out.println("<p>N´umero aleatorio: <strong>" + Math.random() + "</strong></p>");
		out.println("<p>Fecha del sistema: <strong>" + LocalDateTime.now() + "</strong></p>");
		out.println("</body></html>");
		} finally {
		out.close(); // Cierra el flujo de salida
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
