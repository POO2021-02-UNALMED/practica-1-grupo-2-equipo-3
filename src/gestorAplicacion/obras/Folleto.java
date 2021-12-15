package gestorAplicacion.obras;

import java.util.ArrayList;

public class Folleto extends Publicacion {
	// ATRIBUTOS DE CLASE
	static private ArrayList<Folleto> folletos = new ArrayList();

	// ATRIBUTOS INSTANCIA
	private String referencia;

	// CONSTRUCTORES
	public Folleto(int codigo, String nombre, short año, short ejemplar, String referencia,Estanteria estanteria) {
		super(codigo, nombre, año, ejemplar);
		this.referencia = referencia;
		super.estanteria = estanteria;
		folletos.add(this);
		estanteria.getPublicaciones().add(this);
		Publicacion.numeroPublicaciones++;
	}

	// METODOS
	public String mostrarInfo() {
		return " INFORMACION DEL FOLLETO " + "\n" + "Nombre: " + this.nombre + "\n" + "Año: " + this.año + "\n" 
				+ "Codigo: " + this.codigo + "\n" + "Ejemplar: " + this.ejemplar + "\n" + "Estado: " + this.estado
				+ "\n" + "Referencia: " + this.referencia;
	}

	public String mostrarUbicacion() {
		return "Se localiza en -> " + this.estanteria.motrarInfo();
	}

	// GETTERS Y SETTERS
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public static ArrayList<Folleto> getFolletos() {
		return folletos;
	}

	public static void setFolletos(ArrayList<Folleto> folletos) {
		Folleto.folletos = folletos;
	}

}
