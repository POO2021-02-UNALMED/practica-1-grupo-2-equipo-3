package gestorAplicacion.personas;

import java.time.LocalDate;
import java.util.ArrayList;

public class Externo extends Persona implements Usuario {
	
	//ATRIBUTOS DE CLASE
		private static ArrayList<Externo> usuariosExternos ; 
		
	//ATRIBUTOS INSTANCIA
		private String universidad= "No especificada";	
		private int deudas;
		
	
	//CONSTRUCTORES
	public Externo(String nombre,int id,String correo,short tel,String direccion, LocalDate nacimiento, String paisOrigen){
		super( nombre, id, correo, tel, direccion,  nacimiento,  paisOrigen);
		usuariosExternos.add(this);
	}
	public Externo(String nombre,int id,String correo,short tel,String direccion,LocalDate nacimiento, String paisOrigen, String universidad){
		super( nombre, id, correo, tel, direccion, nacimiento,  paisOrigen);
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
	public int getDeudas() {
		return deudas;
	}
	public void setDeudas(int deudas) {
		this.deudas = deudas;
	}

}
