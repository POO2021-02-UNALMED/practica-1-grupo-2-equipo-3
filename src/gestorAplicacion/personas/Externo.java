package gestorAplicacion.personas;

import java.util.ArrayList;

public class Externo extends Persona implements Usuario {
	
	//ATRIBUTOS DE CLASE
		private static ArrayList<Externo> usuariosExternos ; 
		
	//ATRIBUTOS INSTANCIA
		private String universidad= "No especificada";	
		
	
	//CONSTRUCTORES
	Externo(String nombre,int id,String correo,short tel,String direccion, short edad, String paisOrigen){
		super( nombre, id, correo, tel, direccion,  edad,  paisOrigen);
		usuariosExternos.add(this);
	}
	Externo(String nombre,int id,String correo,short tel,String direccion, short edad, String paisOrigen, String universidad){
		super( nombre, id, correo, tel, direccion,  edad,  paisOrigen);
		this.universidad=universidad;
		usuariosExternos.add(this);
		// Constructor con el parametro opcional Universidad
	}
	
	
	//GETTERS SETTERS
	public static ArrayList<Externo> getUsuariosExternos() {
		return usuariosExternos;
	}
	public static void setUsuariosExternos(ArrayList<Externo> usuariosExternos) {
		Externo.usuariosExternos = usuariosExternos;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

}
