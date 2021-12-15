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
	protected short año;
	protected short ejemplar;
	protected Estados estado = Estados.CIRCULACION;
	protected Estanteria estanteria;
	
	
	//CONSTRUCTORES
	Publicacion (int codigo, String nombre, short año, short ejemplar) {
	this.codigo= codigo;
	this.nombre=nombre;
	this.año= año;
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
	public short getAño() {
		return año;
	}
	public void setAño(short año) {
		this.año = año;
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
