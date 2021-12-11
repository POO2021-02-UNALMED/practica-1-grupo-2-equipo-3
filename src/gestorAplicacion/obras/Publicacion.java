package gestorAplicacion.obras;

public abstract class Publicacion {
	//ATRIBUTOS DE CLASE
	static protected int numeroPublicaciones;
	protected static enum Estados  {CIRCULACION, PRESTADO, PERDIDO};
	
	//ATRIBUTOS INSTANCIA
	protected long codigo;
	protected String nombre;
	protected short a�o;
	protected short ejemplar;
	protected Estados estado;
	protected String holi="sokdsf";
	
	//CONSTRUCTORES
	public Publicacion() {
		
	}
	public Publicacion (long codigo, String nombre, short a�o, short ejemplar,Estados estado) {
	this.codigo= codigo;
	this.nombre=nombre;
	this.a�o= a�o;
	this.ejemplar=ejemplar;
	this.estado=estado;
	
	}
	
	
	//GETTERS Y SETTERS
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
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
}
