package gestorAplicacion.obras;

public class Publicacion {
	private long codigo;
	private String nombre;
	private short año;
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
}
