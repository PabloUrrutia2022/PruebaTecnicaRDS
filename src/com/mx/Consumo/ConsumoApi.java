package com.mx.Consumo;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mx.Implements.ConsumoApiImp;
import com.mx.Implements.ConsumoHistorial;

public class ConsumoApi {

	public static void main(String[] args) {
		// Declaracion
		int menuUno, menuDos, menuTres, menuCuatro, menuCinco, regBorrar;
		Scanner lec = null;
		StringBuilder infString;
		LinkedList<LocalDateTime> registro = new LinkedList<LocalDateTime>();
		LinkedList<String> consultaCP = new LinkedList<String>();
		LinkedList<StringBuilder> infStringList = new LinkedList<StringBuilder>();

		ConsumoApiImp consumoImp = new ConsumoApiImp();
		ConsumoHistorial consumoHis = new ConsumoHistorial();

		// Inicio
		do {
			System.out.println("\n---- Bienvenido, a tu menu de manejo de APIs externas ----");
			System.out.println("Indica la acción que deseas visualizar\n");
			System.out.println("1.- Consultar codigo postal");
			System.out.println("2.- Consultar el clima");
			System.out.println("3.- Consultar el historial de registros");
			System.out.println("4.- Salir");
			System.out.print("\nIngresa tu decisión: ");
			lec = new Scanner(System.in);
			menuUno = lec.nextInt();

			switch (menuUno) {
			case 1:
				System.out.println("\n----- Tu elección fue consultar el codigo postal -----");
				do {
					System.out.println("Indica la acción que desees realizar\n");
					System.out.println("1.- Ingresar con tu token para consultas en entorno real");
					System.out.println("2.- Ingresar a la API para modulo de pruebas");
					System.out.println("3.- Regresar al menú principal");
					System.out.print("\nIngresa tu decisión: ");
					lec = new Scanner(System.in);
					menuDos = lec.nextInt();

					switch (menuDos) {
					case 1:
						System.out.println("\n----- Ingresaste al modulo de entorno real -----");
						System.out.print("\nIngresa tu token: ");
						lec = new Scanner(System.in);
						String token = lec.nextLine();
						System.out.print("\nIngresa el código postal a consultar: ");
						lec = new Scanner(System.in);
						String copo = lec.nextLine();
						System.out.println("\nSe visualizará la información correspondiente al código postal: " + copo);

						infString = consumoImp.connectar(copo, token);
						consumoImp.respuestaSistemaPostal(infString);
						consumoHis.registroeventos(registro);
						consultaCP.addLast(copo);
						infStringList.addLast(infString);
						break;

					case 2:
						// Conectar
						System.out.println("\n----- Ingresaste al modulo de pruebas -----");

						infString = consumoImp.connectar("55719", "pruebas");
						consumoImp.respuestaSistemaPostal(infString);
						consumoHis.registroeventos(registro);
						consultaCP.addLast("Codigo-Prueba");
						infStringList.addLast(infString);
						break;

					case 3:
						System.out.println("\nGracias, se dirigirá al menú principal");
						break;
					}
				} while (menuDos < 3); // Menu codigo Postal

				break;
			case 2:
				break;
			case 3:
				System.out.println("\n----- Tu elección fue consultar el historial de registros -----");
				do {
					System.out.println("Indica la acción que desees realizar\n");
					System.out.println("1.- Consultar el historial");
					System.out.println("2.- Eliminar un registro del historial");
					System.out.println("3.- Borrar el historial");
					System.out.println("4.- Regresar al menú principal");
					System.out.print("\nIngresa tu decisión: ");
					lec = new Scanner(System.in);
					menuTres = lec.nextInt();

					switch (menuTres) {
					case 1:
						System.out.println("\n----- Ingresaste a consultar el historial -----");
						consumoHis.impresionregistros(registro, consultaCP, infStringList);
						break;

					case 2:
						System.out.println("\n----- Ingresaste a borrar un registro del historial -----");

						if (registro.size() > 0) {
							System.out.print("\nIngresa el registro a borrar: ");
							lec = new Scanner(System.in);
							regBorrar = lec.nextInt();

							System.out
									.println("¿Realmente deseas borrar el registro " + regBorrar + " del historial?\n");
							System.out.println("1.- Sí");
							System.out.println("2.- No");
							System.out.print("\nIngresa tu decisión: ");
							lec = new Scanner(System.in);
							menuCinco = lec.nextInt();

							switch (menuCinco) {
							case 1:
								System.out.println("...");
								registro.remove(regBorrar);
								consultaCP.remove(regBorrar);
								infStringList.remove(regBorrar);
								System.out.println("El registro " + regBorrar + " ha sido borrado\n");
								break;
							case 2:
								System.out.println("Se dirigirá al menu Historial");
								break;
							}

						} // Cierra if borrar un registro > 0
						else {
							System.out.println("\nEl registro esta vacío\n");
						}

						break;

					case 3:
						System.out.println("\n----- Ingresaste a borrar el historial -----");
						if (registro.size() > 0) {
							System.out.println("¿Realmente deseas borrar el historial?\n");
							System.out.println("1.- Sí");
							System.out.println("2.- No");
							System.out.print("\nIngresa tu decisión: ");
							lec = new Scanner(System.in);
							menuCuatro = lec.nextInt();

							switch (menuCuatro) {
							case 1:
								System.out.println("...");
								registro.clear();
								consultaCP.clear();
								infStringList.clear();
								System.out.println("El historial ha sido borrado\n");
								break;
							case 2:
								System.out.println("Se dirigirá al menu Historial");
								break;
							}
						} // Cierra if de registro > 0
						else {
							System.out.println("\nEl registro esta vacío\n");
						}

						break;

					case 4:
						System.out.println("\nGracias, se dirigirá al menú principal");
						break;
					}

				} while (menuTres < 4);

				break;
			case 4:
				System.out.println("\n\n----- Gracias vuelva pronto -----");
				break;

			}

		} while (menuUno < 4);
		lec.close();
	} // Cierra main
}
// Cierra ConsumoApi
