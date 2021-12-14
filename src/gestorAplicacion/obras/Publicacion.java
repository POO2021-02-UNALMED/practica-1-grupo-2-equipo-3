package gestorAplicacion.obras;

import java.io.Serializable;

import java.util.ArrayList;

public abstract class Publicacion implements Serializable {
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	public static ArrayList<Publicacion> lista = new ArrayList<>();
	static protected int numeroPublicaciones;
	protected static enum Estados  {CIRCULACION, PRESTADO, PERDIDO};
	
	//ATRIBUTOS INSTANCIA
	protected int codigo;
	protected String nombre;
	protected short a�o;
	protected short ejemplar;
	protected Estados estado;
	protected Estanteria estanteria;
	
	
	//CONSTRUCTORES
	public Publicacion() {
		
	}
	public Publicacion (int codigo, String nombre, short a�o, short ejemplar,Estados estado) {
	this.codigo= codigo;
	this.nombre=nombre;
	this.a�o= a�o;
	this.ejemplar=ejemplar;
	this.estado=estado;
	lista.add(this);
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
