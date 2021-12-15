package gestorAplicacion.obras;

import java.io.Serializable;

import java.util.ArrayList;

public abstract class Publicacion implements Serializable {
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	public static ArrayList<Publicacion> lista = new ArrayList<>();
	static protected int numeroPublicaciones;
	public static enum Estados  {CIRCULACION, PRESTADO};
	
	//ATRIBUTOS INSTANCIA
	protected int codigo;
	protected String nombre;
	protected short a�o;
	protected short ejemplar;
	protected Estados estado = Estados.CIRCULACION;
	protected Estanteria estanteria;
	
	
	//CONSTRUCTORES
	Publicacion (int codigo, String nombre, short a�o, short ejemplar) {
	this.codigo= codigo;
	this.nombre=nombre;
	this.a�o= a�o;
	this.ejemplar=ejemplar;
	lista.add(this);
	}
	
	
	//METODOS ABSTRACTOS
	public abstract String mostrarInfo ();
	public abstract String mostrarUbicacion();
	
	
	//METODOS NORMALES
	public static void eliminarPublicacion(Publicacion p) { // elimina un registro de Publicacion
		lista.remove(lista.indexOf(p));
	}
	public static String mostrarRegistros() {
		String c="Publicaciones creadas: "+"\n";
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) instanceof Libro ) {c = c + i+"."+"Libro "+ lista.get(i).nombre + "  Codigo "+ lista.get(i).codigo+ "\n";	}
			else if(lista.get(i) instanceof Revista) {c = c + i+"."+"Revista "+ lista.get(i).nombre + "  Codigo "+ lista.get(i).codigo+ "\n";}
			else if(lista.get(i) instanceof Folleto) {c = c + i+"."+"Folleto "+ lista.get(i).nombre + "  Codigo "+ lista.get(i).codigo+ "\n";}
		}
		return c;
	}
	
	
	//GETTERS Y SETTERS
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public short getA�o() {
		return a�o;
	}
	public void setA�o(short a�o) {
		this.a�o = a�o;
	}
	public short getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(short ejemplar) {
		this.ejemplar = ejemplar;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	public static int getNumeroPublicaciones() {
		return numeroPublicaciones;
	}
	public static void setNumeroPublicaciones(int numeroPublicaciones) {
		Publicacion.numeroPublicaciones = numeroPublicaciones;
	}
	public static ArrayList<Publicacion> getLista() {
		return lista;
	}
	public static void setLista(ArrayList<Publicacion> lista) {
		Publicacion.lista = lista;
	}
	public Estanteria getEstanteria() {
		return estanteria;
	}
	public void setEstanteria(Estanteria estanteria) {
		this.estanteria = estanteria;
	}
}
