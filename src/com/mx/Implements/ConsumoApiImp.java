package com.mx.Implements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConsumoApiImp {

	public StringBuilder connectar(String cp, String token) {
		// Solicitar peticion
		// url: https://api.copomex.com/query/info_cp/09810?token=pruebas
		// token: 37c5eaa3-8cbc-4623-9b92-89c66f038986

		try {
			URL url = new URL("https://api.copomex.com/query/info_cp/" + cp + "?token=" + token);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();

			int responseCode = con.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("Ocurrio un error de tipo: " + responseCode);

			} // Cierra if comportamiento incorrecto
			else {
				StringBuilder infString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					infString.append(scanner.nextLine());

				} // Cierra while llegada de informacion

				scanner.close();
				return infString;

			} // Cierra else comportamiento correcto

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	} // Cierra metodo-conexion

	public void respuestaSistemaPostal(StringBuilder infString) {
		JSONArray jsona = new JSONArray(infString.toString());

		int numval = jsona.length();
		System.out.println("El número de coincidencias es: " + numval + "\n");

		for (int i = 0; i < jsona.length(); i++) {
			JSONObject jsonoU = (JSONObject) jsona.getJSONObject(i);
			impresioninformacion((JSONObject) jsonoU);

		} // Cierra for lectura de valores array

	}

	private static void impresioninformacion(JSONObject jsonoU) {
		try {

			JSONObject jsonoD = (JSONObject) jsonoU.getJSONObject("response");

			System.out.println("Imprimiendo response:  " + jsonoD);

			String asentamiento = (String) jsonoD.getString("asentamiento");
			System.out.println("Asentamiento: " + asentamiento);

			String estado = (String) jsonoD.getString("estado");
			System.out.println("Estado: " + estado);

			String municipio = (String) jsonoD.getString("municipio");
			System.out.println("Municipio: " + municipio);

			String ciudad = (String) jsonoD.getString("ciudad");
			System.out.println("Ciudad: " + ciudad);

			String tipo_asentamiento = (String) jsonoD.getString("tipo_asentamiento");
			System.out.println("Tipo asentamiento: " + tipo_asentamiento);

			String pais = (String) jsonoD.getString("pais");
			System.out.println("País: " + pais + "\n \n");
		} catch (Exception e) {
			String respuesta = (String) jsonoU.get("error_message");
			System.out.println("La respuesta es: " + respuesta);
		}

	}

} // Cierra clase
