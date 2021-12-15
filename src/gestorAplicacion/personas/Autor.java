package gestorAplicacion.personas;

import java.time.LocalDate;
import java.util.ArrayList;
import gestorAplicacion.obras.Libro;

public class Autor extends Persona {
	// ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	static private ArrayList<Autor>autores = new ArrayList<Autor>();

	// ATRIBUTOS INSTANCIA
	private ArrayList<Libro> libros;

	// CONSTRUCTORES
	public Autor() { // Constructor para anonimos
		super.nombre= "Anonimo";
		autores.add(this);
	}

	public Autor(int id, String nombre, LocalDate nacimiento, String paisOrigen) {
		super(id, nombre, nacimiento, paisOrigen);
		autores.add(this);

	}

	public Autor(int id, String nombre, LocalDate nacimiento, String paisOrigen, boolean vivo) { // Constructor si el
																									// Autor no esta
																									// vivo
		super(id, nombre, nacimiento, paisOrigen);
		super.vivo = vivo;
		autores.add(this);
	}

	// METODOS
	public String infoPersonal() {
		String c = "";
		if (this.nombre == "Anonimo") {
			c = "El autor es anonimo.";
		} else {
			if (this.isVivo() == true) {
				c = "El autor se llama " + this.nombre + ", originario de " + this.paisOrigen + ", nacio el "
						+ this.nacimiento + " y aun vive.";
			} else {
				c = "El autor se llama " + this.nombre + ", originario de " + this.paisOrigen + ", nacio el "
						+ this.nacimiento + " y ya no esta vivo.";
			}
		}
		return c;
	}

	// GETTERS SETTERS
	public static ArrayList<Autor> getAutores() {
		return autores;
	}

	public static void setAutores(ArrayList<Autor> autores) {
		Autor.autores = autores;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

}
