package gestorAplicacion.obras;

import java.util.ArrayList;

import gestorAplicacion.personas.Autor;

public class Libro extends Publicacion {
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	static private ArrayList<Libro>libros=new ArrayList<Libro>();
	static public enum tipoLibro {COLECCION_GENERAL,RESERVA,INVESTIGACION,SEMINARIO,TESIS};
	
	//ATRIBUTOS INSTANCIA
	private tipoLibro tipo;
	private String referencia;
	private short volumen;
	private final Autor autor;
	
	//CONSTRUCTORES
	public Libro (int codigo, String nombre, short año, short ejemplar,Autor autor,tipoLibro tipo,String referencia, short volumen, Estanteria estanteria) {
		super(codigo,nombre,año,ejemplar);
		this.autor=autor;
		this.tipo=tipo;
		this.referencia=referencia;
		this.volumen=volumen;
		super.estanteria=estanteria;
		libros.add(this);
		estanteria.getPublicaciones().add(this);
		Publicacion.numeroPublicaciones++;
	}
	
	//METODOS
	public String mostrarInfo() {
		return " INFORMACION DEL LIBRO " + "\n"+ "Nombre: "+ this.nombre + "\n" + "Autor: "+ this.autor.getNombre()+ "\n" +"Año: "+ this.año + "\n" + "Tipo: " + this.tipo
				+ "\n" + "Vol: " + this.volumen + "\n" +"Codigo: "+ this.codigo + "\n" + "Ejemplar: "+this.ejemplar+ "\n" + "Estado: "+this.estado
				+ "\n" + "Referencia: "+this.referencia;
	}
	public String mostrarUbicacion() {
		return "Se localiza en -> "+this.estanteria.motrarInfo();
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
