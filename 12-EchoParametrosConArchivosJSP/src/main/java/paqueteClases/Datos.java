package paqueteClases;

import java.util.LinkedHashMap;

public class Datos {
	public static LinkedHashMap<String, String> arrayValoresYEtiquetasSimple = new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("ES", "Espana");
			put("FR", "Francia");
			put("IT", "Italia");
		}
	};

	public static LinkedHashMap<String, String> arrayValoresYEtiquetasMultiple = new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("PR", "Portugal");
			put("ES", "Espana");
			put("FR", "Francia");
			put("IT", "Italia");
		}
	};
	
	public static LinkedHashMap<String, String> arrayColores = new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("AM", "amarillo");
			put("RO", "rojo");
			put("WE", "verde");
			put("Az", "azul");
		}
	};
}
