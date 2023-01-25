package paqueteClases;

import java.util.LinkedHashMap;

public class Datos {
	public static LinkedHashMap<String, String> arrayValoresYEtiquetasSimple = new LinkedHashMap<String, String>() {
		{
			put("ES", "Espana");
			put("FR", "Francia");
			put("IT", "Italia");
		}
	};

	public static LinkedHashMap<String, String> arrayValoresYEtiquetasMultiple = new LinkedHashMap<String, String>() {
		{
			put("PR", "Portugal");
			put("ES", "Espana");
			put("FR", "Francia");
			put("IT", "Italia");
		}
	};
}
