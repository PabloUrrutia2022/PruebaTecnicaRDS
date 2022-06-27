package com.mx.Implements;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ConsumoHistorial {
	int reg = 0;

	public LinkedList<LocalDateTime> registroeventos(LinkedList<LocalDateTime> registro) {
		LocalDateTime fecHor = LocalDateTime.now();
		registro.addLast(fecHor);
		return registro;

	} // Cerrar metodo registroeventos

	public void impresionregistros(LinkedList<LocalDateTime> registro, LinkedList<String> consultaCP,
			LinkedList<StringBuilder> infStringList) {
		if (registro.size() == 0) {
			System.out.println("Registro vacio\n");
		} else {
			for (int Reg = 0; Reg < registro.size(); Reg++) {
				System.out.println("Registro " + Reg + ": " + registro.get(Reg));
				System.out.println("Con CP: " + consultaCP.get(Reg));
				System.out.println("Con la información: " + infStringList.get(Reg));

			} // Cierra for impresion-registros
		}

	} // Cerrar metodo impresionregistros

}
