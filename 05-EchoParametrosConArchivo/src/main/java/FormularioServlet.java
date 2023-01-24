
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.File;
//import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Iterator;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class FormularioServlet
 */

//@WebServlet("/SubeFichero_tipo")

//@MultipartConfig (
//   location = "carpeta donde se guardan los archivos (creada previamente)", 
//   maxFileSize =  tama�o maximo de archivo a subir (entero largo)
//)

@MultipartConfig(location = "c:\\upload", maxFileSize = 10485760L) // (Barra para escapar c:\\ , 10MB)
//@MultipartConfig
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub
		// doGet(request, response);

		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Establece el tipo MIME del mensaje de respuesta
		// response.setContentType("text/html");
		// Crea un flujo de salida para escribir la respuesta a la petici´on del cliente
		PrintWriter out = response.getWriter();
		// Escribe el mensaje de respuesta en una página html

		Collection<Part> parteArchivos = request.getParts(); // Recibe el archivo en un objeto de tipo Part
		int numeroDeArchivos = parteArchivos.size() - 1;
		
		Iterator<Part> it = parteArchivos.iterator();
		Part parteArchivo;
		String nombreArchivo;
		long tamanio;
		String tipo;
		// String nombreArchivo = parteArchivo.getSubmittedFileName(); // Extrae el
		// nombre original del archivo del objeto
		// long tamanio = parteArchivo.getSize();
		// String tipo = parteArchivo.getContentType();

		try {
			out.println("<html>");
			out.println("<head><title>Formulario</title></head>");
			out.println("<body>");
			out.println("<h1>Hola2</h1>");
			// Ver si el nombre está vacío
			if (request.getParameter("nombre") == null || request.getParameter("nombre").length() == 0) {
				out.println("<h1>Nombre: Este campo está vacío.</h1>");
			} else {
				out.println("<h1>Nombre: " + request.getParameter("nombre") + "</h1>");
			}
			out.println("<h1>Numero de archivos subidos: " + numeroDeArchivos + "</h1>");
			
			
			
			// *******************************************************

			// Tratamiento del tipo del archivo
//			if (!tipo.equals("image/jpeg")) {
//				response.setContentType("text/html;charset=UTF-8");
//				try {
//					out.println("<h1>El fichero no es de tipo imagen/jpeg</h1>");
//					out.close();
//				}finally {
//				}
//			} else {
//				//parteArchivos.write(nombreArchivo); // Guarda en el disco el archivo con el nombre original
//
//				// Creaci�n del html de salida
//				response.setContentType("text/html;charset=UTF-8");
//				try {
//
//					out.println("<h1>Operaci�n realizada con �xito</h1>");
//					out.println("<h1>Operaci�n realizada con �xito</h1>");
//					//out.println("<table border=1px>");
//					//out.println("<tr><td>Archivo subido  </td><td><b>C:\\upload\\" + nombreArchivo + "</b></td></tr>");
//					//out.println("<tr><td>Tama�o del archivo </td><td>" + tamanio + " bytes</td></tr>");
//					//out.println("<tr><td>Tipo de archivo </td><td>" + tipo + "</td></tr>");
//					//out.println("</table>");
//					out.close();
//				} finally {
//				}
		} finally {
			out.println("</body></html>");
		}
	}
}
