package gestorAplicacion.obras;

import java.io.Serializable;

import java.util.ArrayList;

import gestorAplicacion.prestamo.Prestamo;

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
	protected Prestamo prestamo;
	
	
	//CONSTRUCTORES
	Publicacion (int codigo, String nombre, short año, short ejemplar) {
	this.codigo= codigo;
	this.nombre=nombre;
	this.año= año;
	this.ejemplar=ejemplar;
	lista.add(this);
	}
	
	public  String mostrarInfo () {
		return "Informacion perteneciente a la publicacion " + this.nombre ;
	}
	
	//METODOS ABSTRACTOS
	  // muestra informacion detallada de la publicacion, es decir sus atributos
	public abstract String mostrarUbicacion();  //muestra la estanteria y con ello la ubicacion donde se encuentra la publicacion
	
	
	//METODOS NORMALES
	public static void eliminarPublicacion(Publicacion p) { // elimina un registro de Publicacion
		lista.remove(lista.indexOf(p));
	}
	public static String mostrarRegistros() {   // muestra todos los registros creados de publicacion
		String c="Publicaciones creadas: "+"\n";
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) instanceof Libro ) {c = c + i+"."+"Libro "+ lista.get(i).nombre + "  Codigo (CP) "+ lista.get(i).codigo+ "\n";	}
			else if(lista.get(i) instanceof Revista) {c = c + i+"."+"Revista "+ lista.get(i).nombre + "  Codigo (CP) "+ lista.get(i).codigo+ "\n";}
			else if(lista.get(i) instanceof Folleto) {c = c + i+"."+"Folleto "+ lista.get(i).nombre + "  Codigo (CP) "+ lista.get(i).codigo+ "\n";}
		}
		return c;
	}
	
	public boolean verificarPrestado() {
		boolean b= true;                                            //Verifica que la publicacion este en circulacion es decir no prestada, arroja true si esta prestado
		if(this.getEstado()== Publicacion.Estados.CIRCULACION) {
			 b= false;
		}
		return b;
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
