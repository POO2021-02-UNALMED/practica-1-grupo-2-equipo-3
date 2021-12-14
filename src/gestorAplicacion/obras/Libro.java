package gestorAplicacion.obras;

import java.util.ArrayList;

public class Libro extends Publicacion {
	//ATRIBUTOS DE CLASE
	static private ArrayList<Libro>libros;
	static private enum tipoLibro {COLECCION_GENERAL,RESERVA,INVESTIGACION,SEMINARIO,TESIS};
	
	//ATRIBUTOS INSTANCIA
	private tipoLibro tipo;
	private String referencia;
	private short volumen;
	
	//CONSTRUCTORES
	public Libro (int codigo, String nombre, short año, short ejemplar, Estados estado, tipoLibro tipo,String referencia, short volumen, Estanteria estanteria) {
		super(codigo,nombre,año,ejemplar,estado);
		this.tipo=tipo;
		this.referencia=referencia;
		this.volumen=volumen;
		super.estanteria=estanteria;
		libros.add(this);
		Publicacion.numeroPublicaciones++;
	}
	
	
	//GETTERS Y SETTERS
	public tipoLibro getTipo() {
		return tipo;
	}

	public void setTipo(tipoLibro tipo) {
		this.tipo = tipo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public short getVolumen() {
		return volumen;
	}

	public void setVolumen(short volumen) {
		this.volumen = volumen;
	}
	public static ArrayList<Libro> getLibros() {
		return libros;
	}
	public static void setLibros(ArrayList<Libro> libros) {
		Libro.libros = libros;
	}
	
}
