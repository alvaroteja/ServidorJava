
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Servlet implementation class FormularioServlet
 */
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LinkedHashMap<String, String> arrayValoresYEtiquetas = new LinkedHashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormularioServlet() {
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

		arrayValoresYEtiquetas.put("ES", "Espana");
		arrayValoresYEtiquetas.put("FR", "Francia");
		arrayValoresYEtiquetas.put("IT", "Italia");

		PrintWriter out = response.getWriter();
		out.println("<h1>hola</h1>");
		try {
			String nombre = request.getParameter("nombre");
			String clave = request.getParameter("clave");
			String genero = request.getParameter("genero");
			String FechaNacimiento = request.getParameter("FechaNacimiento");
			String selectorSimple = request.getParameter("selectorSimple");
			String[] pais = request.getParameterValues("pais");
			String acepto = request.getParameter("acepto");
			String comentario = request.getParameter("comentario");
			String oculto = request.getParameter("oculto");
			String[] colores = request.getParameterValues("colores");

			String nombreValidacion;
			String claveValidacion;
			String generoValidacion;
			String FechaNacimientoValidacion;
			String selectorSimpleValidacion;
			String paisValidacion;
			String aceptoValidacion;
			String comentarioValidacion;
			String ocultoValidacion;
			String coloresValidacion;

			// Validacion nombre
			if (nombre != null && nombre.length() > 0) {
				nombreValidacion = "ok";
			} else {
				nombreValidacion = "Nombre no introducido.";
			}
			request.setAttribute("nombre", nombre);
			request.setAttribute("nombreValidacion", nombreValidacion);

			// Validacion clave
			if (clave != null) {
				if (clave.length() >= 6 && clave.length() <= 12) {
					claveValidacion = "ok";
				} else {
					claveValidacion = "Clave no segura, introduce una clave entre 6 y 12 caracteres.";
				}
			} else {
				claveValidacion = "Clave no introducida.";
			}
			request.setAttribute("clave", clave);
			request.setAttribute("claveValidacion", claveValidacion);

			// Validacion genero
			if (genero != null) {
				if (genero.equals("masculino")) {
					generoValidacion = "ok";
				} else if (genero.equals("femenino")) {
					generoValidacion = "ok";
				} else {
					generoValidacion = "El genero no corresponde.";
				}
			} else {
				generoValidacion = "Genero no introducido.";
			}
			request.setAttribute("genero", genero);
			request.setAttribute("generoValidacion", generoValidacion);

			// Validacion fecha
			if (FechaNacimiento != null && FechaNacimiento.length() > 0) {
				try {
					LocalDate fecha = LocalDate.parse(FechaNacimiento);
					if (validacionEdad(fecha)) {
						FechaNacimientoValidacion = "ok";
					} else {
						FechaNacimientoValidacion = "Eres menor de edad.";
					}
				} catch (Exception e) {
					FechaNacimientoValidacion = "Formato de fecha incorrecto.";
				}
			} else {
				FechaNacimientoValidacion = "Fecha no introducida.";
			}
			request.setAttribute("FechaNacimiento", FechaNacimiento);
			request.setAttribute("FechaNacimientoValidacion", FechaNacimientoValidacion);

			// Validacion selectorSimple
			if (selectorSimple != null && selectorSimple.length() > 0) {
				selectorSimpleValidacion = "ok";
			} else {
				selectorSimpleValidacion = "Selector simple no especificado.";
			}
			request.setAttribute("selectorSimple", selectorSimple);
			request.setAttribute("selectorSimpleValidacion", selectorSimpleValidacion);

			// Validacion pais
			if (pais != null && pais.length > 0) {
				paisValidacion = "ok";
			} else {
				paisValidacion = "No se ha seleccionado ningun pais.";
			}
			request.setAttribute("pais", pais);
			request.setAttribute("paisValidacion", paisValidacion);

			// Validacion acepto
			int aceptoInt;
			if (acepto != null && acepto.length() > 0 && acepto.equals("on")) {
				aceptoValidacion = "ok";
				aceptoInt = 1;

			} else {
				aceptoValidacion = "No se ha seleccionado la casilla 'Acepto'.";
				aceptoInt = 0;
			}
			// boolean aceptoBoolean = Boolean.parseBoolean(acepto);
			request.setAttribute("acepto", acepto);
			request.setAttribute("aceptoValidacion", aceptoValidacion);

			// Validacion comentario
			if (comentario == null) {
				comentarioValidacion = "No hay ningun comentario.";
			} else if (comentario.length() <= 0) {
				comentarioValidacion = "No se ha escrito ningun comentario.";
			} else if (comentario.length() > 0) {
				comentarioValidacion = "ok";
			} else {
				comentarioValidacion = "Error al enviar el comentario.";
			}
			request.setAttribute("comentario", comentario);
			request.setAttribute("comentarioValidacion", comentarioValidacion);

			// Validacion oculto
			if (oculto != null && oculto.length() > 0) {
				ocultoValidacion = "ok";
			} else {
				ocultoValidacion = "Campo oculto no se ha enviado correctamente.";
			}
			request.setAttribute("oculto", oculto);
			request.setAttribute("ocultoValidacion", ocultoValidacion);

			// Validacion colores
			if (colores != null && colores.length > 0) {
				coloresValidacion = "ok";
			} else {
				coloresValidacion = "No se ha seleccionado ningun color.";
			}
			request.setAttribute("colores", colores);
			request.setAttribute("coloresValidacion", coloresValidacion);

			// Guardado en la base de datos
			String paisConcatenado = concatenarValores(pais);
			String coloresConcatenado = concatenarValores(colores);

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/datosformulario", "root", "");

			// Sentencia no preparada
			//Statement stmt = conn.createStatement();
			//String sqlStr = "INSERT INTO `usuarios` VALUES (NULL, '" + nombre + "', '" + clave + "', '" + genero
			//+ "', '" + FechaNacimiento + "', '" + selectorSimple + "', '" + paisConcatenado + "', '" + aceptoInt
			//+ "', '" + comentario + "', '" + coloresConcatenado + "');";
			
			String sqlStr = "INSERT INTO usuarios values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stmt = conn.prepareStatement(sqlStr);

			stmt.setString(1, nombre);
			stmt.setString(2, clave);
			stmt.setString(3, genero);
			stmt.setString(4, FechaNacimiento);
			stmt.setString(5, selectorSimple);
			stmt.setString(6, paisConcatenado);
			stmt.setInt(7, aceptoInt);
			stmt.setString(8, comentario);
			stmt.setString(9, coloresConcatenado);

			//pasarle sqlStr si no es preparada
			int filas = stmt.executeUpdate();

			out.println("<h1>" + filas + "</h1>");
			
			////////////////////////////////////

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formulario.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	protected boolean validacionEdad(LocalDate fecha) {
		if (calcularEdad(fecha) >= 18) {
			return true;
		} else {
			return false;
		}
	}

	public static int calcularEdad(LocalDate fecha) {
		LocalDate curDate = LocalDate.now();
		if ((fecha != null) && (curDate != null)) {
			return Period.between(fecha, curDate).getYears();
		} else {
			return 0;
		}
	}

	public static String generaSelectSimple(String nombreControl, Map<String, String> arrayValoresYEtiquetas,
			String valorSeleccionado) {
		String salida = "";
		salida += "<select name=\"" + nombreControl + "\">" + "\n";
		Iterator<String> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
		while (iteradorConjuntoClaves.hasNext()) {
			String clave = iteradorConjuntoClaves.next();
			String valor = arrayValoresYEtiquetas.get(clave);
			if (valorSeleccionado.equals(clave)) {
				salida += "  <option value=\"" + clave + "\" selected=\"selected\">" + valor + "</option>" + "\n";
			} else {
				salida += "  <option value=\"" + clave + "\">" + valor + "</option>" + "\n";
			}
		}
		salida += "</select>" + "\n";
		return salida;
	}

	public static String concatenarValores(String[] valores) {
		valores = valores != null ? valores : new String[0];

		String valoresConcatenados = "";
		for (int i = 0; i < valores.length; i++) {
			if (i == 0) {
				valoresConcatenados += valores[i];
			} else {
				valoresConcatenados += "&" + valores[i];
			}
		}
		return valoresConcatenados;
	}
}
