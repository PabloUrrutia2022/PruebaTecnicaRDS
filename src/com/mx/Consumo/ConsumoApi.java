package com.mx.Consumo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConsumoApi {

	public static void main(String[] args) {
		//Declaración de variables
		int conReg =0;
		
		// Solicitar peticion
		// url: https://api.copomex.com/query/info_cp/09810?token=pruebas

		String cp = "55719";
		String tokenp = "pruebas";
		String token = "37c5eaa3-8cbc-4623-9b92-89c66f038986";
		try {
			URL url = new URL("https://api.copomex.com/query/info_cp/" + cp + "?token=" + tokenp);
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

				System.out.println(infString);

				JSONArray jsona = new JSONArray(infString.toString());

				int numval = jsona.length();
				System.out.println("El número de valores es: " + numval + "\n");

				for (int i = 0; i < jsona.length(); i++) {
					JSONObject jsonoU = (JSONObject) jsona.getJSONObject(i);
					impresioninformacion((JSONObject) jsonoU);

				} // Cierra for lectura de valores array
				
				LinkedList<LocalDateTime> registro = new LinkedList<LocalDateTime>();
				LocalDateTime fecHor = LocalDateTime.now();
				registro.addLast(fecHor);
				for(conReg=conReg;conReg<registro.size();conReg++) {
					System.out.println("Registro "+conReg+": " +registro.get(conReg));
					
				} // Cierra For impresion registro
				

			} // Cierra else comportamiento correcto

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // Cierra main
	
	

	private static void impresioninformacion(JSONObject jsonoU) {
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

	}

} // Cierra ConsumoApi
