package gestorAplicacion.obras;

import java.util.ArrayList;

public class Folleto extends Publicacion {
	//ATRIBUTOS DE CLASE
	static private ArrayList<Folleto>folletos;
	
	//ATRIBUTOS INSTANCIA
	private String referencia;

	
	//CONSTRUCTORES
	public Folleto() {
		Publicacion.numeroPublicaciones++;
	}
	public Folleto(int codigo, String nombre, short año, short ejemplar, Estados estado,String referencia, Estanteria estanteria) {
		super(codigo, nombre, año, ejemplar, estado);
		this.referencia=referencia;	
		super.estanteria=estanteria;
		folletos.add(this);
		Publicacion.numeroPublicaciones++;
	}


	//GETTERS Y SETTERS
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
