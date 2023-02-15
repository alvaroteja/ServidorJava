
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class ConsultaServlet
 */
public class ConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String url;
	private Integer contador;
	private ServletContext context;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultaServlet() {
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
		// Establecemos el tipo MIME del mensaje de respuesta
		response.setContentType("text/html");
		// Creamos un objeto para poder escribir la respuesta
		PrintWriter out = response.getWriter();
		out.print("Hola estas en consulta servlet");
		Connection conn = null;
		Statement stmt = null;
		try {
			// Paso 1: Cargar el driver JDBC.
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			//String userName = "root";
			//String password = "";

			// URL de la base de datos(equipo, puerto, base de datos)
			//String url = "jdbc:mysql://localhost/TiendaLibros3";
			conn = DriverManager.getConnection(url, userName, password);

			// Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
			stmt = conn.createStatement();

			// Paso 4: Ejecutar las sentencias SQL a trav´es de los objetos Statement
			String sqlStr = "select * from libros where autor = " + "'" + request.getParameter("autor") + "'";

			// Generar una p´agina HTML como resultado de la consulta
			out.println("<html><head><title>Resultado de la consulta</title></head><body>");
			out.println("<h3>Gracias por tu consulta.</h3>");
			out.println("<p>Tu consulta es: " + sqlStr + "</p>");
			ResultSet rset = stmt.executeQuery(sqlStr);

			request.setAttribute("rset", rset);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/visualizaResultados.jsp");
			dispatcher.forward(request, response);

			// Paso 5: Procesar el conjunto de registros resultante utilizando ResultSet
//			int count = 0;
//			while (rset.next()) {
//				out.println("<p>" + rset.getString("autor") + ", " + rset.getString("titulo") + ", "
//						+ rset.getDouble("precio") + "</p>");
//				count++;
//			}
//			out.println("<p>==== " + count + " registros encontrados =====</p>");
//			out.println("</body></html>");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close(); // Cerramos el flujo de escritura
			try {
				// Cerramos el resto de recursos
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Lectura de los par´ametros de inicializaci´on del Servlet
		userName = config.getInitParameter("usuario");
		password = config.getInitParameter("password");
		url = config.getInitParameter("URLBaseDeDatos");
		
		context = config.getServletContext();
	}

}
