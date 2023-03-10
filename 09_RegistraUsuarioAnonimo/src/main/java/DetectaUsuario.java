
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Servlet implementation class DetectaUsuario
 */
public class DetectaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetectaUsuario() {
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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Ejemplo");
		//dispatcher.forward(request,response);
		
		//String vista= "/Ejemplo.java";
		//RequestDispatcher dispacher = getServletContext().getRequestDispatcher(vista);
		//dispacher.forward(request, response);
		
		request.setAttribute("clave","aa");
		request.getRequestDispatcher("respuesta");

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>DetectaUsuario</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Detecta Usuario</h1>");
			
			

			int i;
			if (request.getCookies() != null) {

				Cookie[] arrayCookies = request.getCookies();
				String contenidoCookie = "";
				int longitud = arrayCookies.length;

				boolean cookieEncontrada = false;

				if (arrayCookies != null && longitud > 0) {
					for (i = 0; i < longitud && !cookieEncontrada; i++) {
						String nombreCookie = arrayCookies[i].getName();
						if (nombreCookie.equals("uid")) {
							cookieEncontrada = true;
							contenidoCookie = arrayCookies[i].getValue();
						}
					}

					if (cookieEncontrada) {
						out.println("<h1>Hola usuario, tu Cookie es " + contenidoCookie + "</h1>");
					} else {
						out.print("<h1>El usuario no tiene la cookie uid.</h1>");
						crearCookie("uid", response);
					}
				} else {
					out.print("<h1>No hay ninguna Cookie</h1>");
					crearCookie("uid", response);
				}
			} else {
				out.print("<h1>No hay ninguna Cookie en el navegador</h1>");
				crearCookie("uid", response);
			}
		} catch (Exception e) {
			out.println("Se produce una excepci???n <br />");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void crearCookie(String nombreCookie, HttpServletResponse response) {
		String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		// La cadena en donde iremos agregando un car??cter aleatorio
		String stringRandom = "";
		int longitud = 10;
		for (int x = 0; x < longitud; x++) {
			int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
			char caracterAleatorio = banco.charAt(indiceAleatorio);
			stringRandom += caracterAleatorio;
		}

		Cookie unaCookie = new Cookie(nombreCookie, stringRandom);
		response.addCookie(unaCookie);
	}

	public static int numeroAleatorioEnRango(int minimo, int maximo) {
		// nextInt regresa en rango pero con l??mite superior exclusivo, por eso sumamos
		// 1
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}

}
