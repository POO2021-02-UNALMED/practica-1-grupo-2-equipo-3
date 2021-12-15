package gestorAplicacion.personas;
import java.time.LocalDate;
import java.util.ArrayList;
import gestorAplicacion.obras.Libro;

public class Autor extends Persona {
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	static private ArrayList<Autor>autores;
	
	//ATRIBUTOS INSTANCIA
	private ArrayList<Libro>libros;
	
	//CONSTRUCTORES
	public Autor() {};
	public Autor (int id, String nombre, LocalDate nacimiento, String paisOrigen){
		super(id,nombre,nacimiento,paisOrigen);
		autores.add(this);
		
	}
	public Autor (int id,String nombre,LocalDate nacimiento, String paisOrigen,boolean vivo){ //Constructor si el Autor no esta vivo
		super(id,nombre, nacimiento, paisOrigen);
		super.vivo=vivo;
		autores.add(this);
	}
	
	
	
	//GETTERS SETTERS
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


