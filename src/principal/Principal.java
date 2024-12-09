package principal;

import java.util.ArrayList;

import clase.Alumno;
import util.Utilidades;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		int opc = 0;

		do {
			opc = mostarMenu(opc);
			if (alumnos.isEmpty() && opc > 1 && opc < 16) {
				System.out.println("No hay empleados registrados.");
			} else {
				switch (opc) {
				case 1:
					introducirAlumnos(alumnos);
					break;
				case 2:
					mostrarAlumnos(alumnos);
					break;
				case 3:
					buscarNif(alumnos);
					break;
				case 4:
					introducirNotas(alumnos);
					break;
				case 5:
					introducirNotas(alumnos);
					break;
				case 6:
					eliminarAlumno(alumnos);
					break;
				case 7:
					eliminarModulo(alumnos);
					break;
				case 8:
					modificarNotasModuloConcreto(alumnos);
					break;
				case 9:
					notaMediaDelCilco(alumnos);
					break;
				case 10:
					buscarNif(alumnos);
					break;
				case 11:
					suspensoModulo(alumnos);
					break;
				case 12:
					notaAltaYBaja(alumnos);
					break;
				case 13:
					buscarNif(alumnos);
					break;
				case 14:
					mostrarRepetidores(alumnos);// v
					break;
				case 15:
					buscarNif(alumnos);
					break;
				case 16:
					System.out.println("Saliendo...");// v
					break;
				default:
					System.out.println("Opcion no valida");
					break;
				}
			}
		} while (opc != 16);
	}

	private static void notaAltaYBaja(ArrayList<Alumno> alumnos) {
		String buscarModulo;
		//int nota;

		buscarModulo = Utilidades.introducirCadena("El modulo a buscar:");
		for (int i = 0; i < alumnos.size(); i++) {
			for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
				if (alumnos.get(i).getModulos().get(j).equalsIgnoreCase(buscarModulo)) {
				
				}
				for (int l = i + 1; l < alumnos.size(); l++) {
					
				}
			}

		}
	}

	private static void suspensoModulo(ArrayList<Alumno> alumnos) {
		String buscarModulo;
		int suspenso = 0;
		int nota;

		buscarModulo = Utilidades.introducirCadena("El modulo a buscar:");
		for (int i = 0; i < alumnos.size(); i++) {
			for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
				if (alumnos.get(i).getModulos().get(j).equalsIgnoreCase(buscarModulo)) {
					nota=alumnos.get(i).getNotas().get(j);
					if (nota <= 4) {
						suspenso++;
					}

				}
			}
		}
		System.out.println("El numero de suspensos en el modulo " + buscarModulo + " es de: " + suspenso);
	}

	private static void notaMediaDelCilco(ArrayList<Alumno> alumnos) {
		float sumaNotas = 0;
		float notaMedia = 0;
		int notas;
		float nota;
		int sumaModulos = 0;
		String cicloBuscar;

		cicloBuscar = Utilidades.introducirCadena("El ciclo a buscar:");
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getCiclo().equalsIgnoreCase(cicloBuscar)) {
				for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
					sumaModulos++;
					notas=alumnos.get(i).getNotas().get(j);
					nota = (float) notas;
					sumaNotas += nota;
				}
			}
		}
		notaMedia = sumaNotas / sumaModulos;
		System.out.println("La nota media del ciclo es de: " + notaMedia);
	}

	private static void eliminarModulo(ArrayList<Alumno> alumnos) {
		String nif;
		String moduloBuscar;
		boolean compro = false;

		nif = Utilidades.introducirCadena("Introduce el nif del alumno a dar de baja el modulo:");
		moduloBuscar = Utilidades.introducirCadena("El modulo:");
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {
				for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
					if (alumnos.get(i).getModulos().get(j).equalsIgnoreCase(moduloBuscar)) {
						alumnos.get(i).getModulos().remove(j);
						alumnos.get(i).getNotas().remove(j);
						System.out.println("Modulo eliminado correctamente.");
						compro = true;
					}
				}
			}
		}
		if (!compro) {
			System.out.println("No se encontró ningún alumno con ese nif.");

		}
	}

	private static void modificarNotasModuloConcreto(ArrayList<Alumno> alumnos) {
		String nifBuscar;
		String asignaturaBuscar;
		Integer nota = null;
		nifBuscar = Utilidades.introducirCadena("Introduce el nif de la persona que quieres modificar las notas");
		asignaturaBuscar = Utilidades.introducirCadena("Introduce la asignatura que quieras modificar");
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nifBuscar)) {
				for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
					if (alumnos.get(i).getModulos().get(j).equalsIgnoreCase(asignaturaBuscar)) {
						nota = Utilidades.introducirNumero("Introduce la nota de " + alumnos.get(i).getModulos().get(j));
						alumnos.get(i).getNotas().set(j, nota);
						System.out.println("Se ha modificado correctamente");
					}
				}
			}
		}
	}

	private static void introducirNotas(ArrayList<Alumno> alumnos) {
		String nifBuscar;
		Integer nota = null;
		nifBuscar = Utilidades.introducirCadena("Introduce el nif de la persona que quieres ingresar las notas");
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nifBuscar)) {
				for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
					nota = Utilidades.introducirNumero("Introduce la nota de " + alumnos.get(i).getModulos().get(j));
					alumnos.get(i).getNotas().set(j, nota);
					System.out.println("Se ha resgistrado correctamente");
				}
			}
		}
	}

	private static void ordenarPorNif(ArrayList<Alumno> alumnos) {

	}

	private static void mostrarRepetidores(ArrayList<Alumno> alumnos) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).isRepetidor()) {
				System.out.println(alumnos.get(i));
			}
		}
	}

	private static void eliminarAlumno(ArrayList<Alumno> alumnos) {
		String nif;
		boolean compro = false;

		nif = Utilidades.introducirCadena("Introduce el nif del alumno a dar de baja:");

		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {
				alumnos.remove(i);
				System.out.println("Alumno eliminado correctamente.");
				compro = true;
			}
		}
		if (!compro) {
			System.out.println("No se encontró ningún empleado con ese dni.");

		}
	}

	private static void buscarNif(ArrayList<Alumno> alumnos) {
		String nifBuscar = null;
		nifBuscar = Utilidades.introducirCadena("Introduce el nif que quieres buscar");
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nifBuscar)) {
				for (int j = 0; j < alumnos.get(i).getNotas().size(); j++) {
					if (alumnos.get(i).getNotas().equals("0")) {
						//alumnos.get(i).getNotas().set(j, "Sin Nota");
					}
				}

				System.out.println(alumnos.get(i));
			}
		}
	}

	private static void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i));
		}
	}

	private static void introducirAlumnos(ArrayList<Alumno> alumnos) {
		Alumno alum;
		String nifIntro;
		int existeAlumno;
		boolean seguir = true;

		for (; seguir;) {
			nifIntro = Utilidades.introducirCadena("Introduce el nif: ");
			existeAlumno = buscarAlumno(alumnos, nifIntro);
			if (existeAlumno == -1) {
				alum = new Alumno();
				alum.setDatos(nifIntro);
				alumnos.add(alum);
				System.out.println("Añadido exitosamente.");
			} else {
				System.out.println("Ya existe un empleado con ese dni.");
			}

			seguir = Utilidades.introducirCadena("Quieres seguir introduciendo alumnos?").equalsIgnoreCase("SI");
		}
	}

	private static int buscarAlumno(ArrayList<Alumno> alumnos, String nif) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {
				return 0;
			}
		}
		return -1;

	}

	private static int mostarMenu(int opc) {
		System.out.println("1. Introducir alumos");
		System.out.println("2. Mostrar alumnos");
		System.out.println("3. Buscar por nif");
		System.out.println("4. Introducir notas");
		System.out.println("5. Modificar notas");
		System.out.println("6. Dar de baja a alummno");
		System.out.println("7. Dar de baja un modulo del alummno");
		System.out.println("8. Introducir notas de un modulo en concreto");
		System.out.println("9. Notas medias del ciclo");
		System.out.println("10. Ordenar por nif");
		System.out.println("11. Alumnos que han suspendido un modulo");
		System.out.println("12. Nota mas alta y baja del modulo");
		System.out.println("13. Alumnos sin evaluar");
		System.out.println("14. Lista de repetidores");
		System.out.println("15. Suspensos del modulo");
		System.out.println("16. Salir");// v
		opc = Utilidades.introducirNumero("Elige una opción: ");
		return opc;
	}

}
