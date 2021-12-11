package gestorAplicacion.obras;

import java.util.ArrayList;

public class Libro extends Publicacion {
	//ATRIBUTOS DE CLASE
	static public ArrayList<Libro>libros= new ArrayList();
	
	
	//ATRIBUTOS INSTANCIA
	private String tipo;
	private String referencia;
	private short volumen;
	
	//CONSTRUCTORES
	public Libro() {
		System.out.println(holi);
		Publicacion.numeroPublicaciones++;
	}
	public Libro (long codigo, String nombre, short año, short ejemplar, Estados estado, String tipo,String referencia, short volumen) {
		super(codigo,nombre,año,ejemplar,estado);
		this.tipo=tipo;
		this.referencia=referencia;
		this.volumen=volumen;
		libros.add(this);
		Publicacion.numeroPublicaciones++;
	}
	
	
	//GETTERS Y SETTERS
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
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
	
}
