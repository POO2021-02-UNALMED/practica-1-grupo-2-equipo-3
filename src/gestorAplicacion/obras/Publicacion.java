package gestorAplicacion.obras;

public class Publicacion {
	private long codigo;
	private String nombre;
	private short a�o;
	private short ejemplar;
	private static enum Estados  {CIRCULACION, PRESTADO, PERDIDO};
	private Estados estado;
	
	
	
	
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
}
