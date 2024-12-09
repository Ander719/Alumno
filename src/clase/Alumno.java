package clase;

import java.util.ArrayList;
import util.Utilidades;

public class Alumno {
	private String nif;
	private String nombre;
	private String apellido;
	private String ciclo;
	private boolean repetidor;
	private ArrayList<String> modulos;
	private ArrayList<Integer> notas;

	// Getters y setters

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	public ArrayList<String> getModulos() {
		return modulos;
	}

	public void setModulos(ArrayList<String> modulos) {
		this.modulos = modulos;
	}

	public ArrayList<Integer> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}

	// Constructor
	public Alumno() {
	}

	// ToString
	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + ", ciclo=" + ciclo
				+ ", repetidor=" + repetidor + ", modulos=" + modulos.toString() + ", notas=" + notas + "]";
	}

	// setDatos
	public void setDatos(String nifIntro) {
		boolean salir = false;
		nif = nifIntro;
		nombre = Utilidades.introducirCadena("Introduce el nombre:");
		apellido = Utilidades.introducirCadena("Introduce el apellido:");
		ciclo = Utilidades.introducirCadena("Introduce el ciclo:");
		repetidor = Utilidades.introducirBooleano("¿Es repetidor? (true/false)");
		modulos = new ArrayList<String>();
		notas = new ArrayList<Integer>();
		do {
			String modulo = Utilidades.introducirCadena("Introduce el modulo que deseas");
			modulos.add(modulo);
			notas.add(0);
			salir = Utilidades.introducirBooleano("¿Quieres seguir introduciendo modulos?");
		} while (salir);
		System.out.println(modulos.toString());
		System.out.println(notas.toString());
	}

}
