package gestorAplicacion.obras;

import java.util.ArrayList;

public class Folleto extends Publicacion {
	//ATRIBUTOS DE CLASE
	static public ArrayList<Folleto>folletos= new ArrayList();
	
	//ATRIBUTOS INSTANCIA
	private String referencia;

	
	//CONSTRUCTORES
	public Folleto() {
		Publicacion.numeroPublicaciones++;
	}
	public Folleto(long codigo, String nombre, short año, short ejemplar, Estados estado,String referencia) {
		super(codigo, nombre, año, ejemplar, estado);
		this.referencia=referencia;	
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
	

	


}
