package Scriptlets;

import java.util.ArrayList;

import Datos.listaIdiomas;
import jakarta.servlet.http.HttpSession;

public class scriptlets1 {
	public static String crearRadioButton(String idiomaSeleccionado) {

		String salida = "";

		ArrayList<String> idiomas = listaIdiomas.darIdiomas();

		for (int i = 0; i < idiomas.size(); i++) {
			String checked = "";
			if (idiomas.get(i).equals(idiomaSeleccionado)) {
				checked = "checked";
			}
			salida += "<input type='radio' id=" + idiomas.get(i) + " name='idiomas' value='" + idiomas.get(i) + "' "
					+ checked + " />" + "<label for='" + idiomas.get(i) + "'>" + idiomas.get(i) + "</label>";
		}
		return salida;
	}
}
