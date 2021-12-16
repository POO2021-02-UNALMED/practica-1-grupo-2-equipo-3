package gestorAplicacion.personas;

import java.time.LocalDate;
import java.util.ArrayList;

import gestorAplicacion.obras.Libro;
import gestorAplicacion.obras.Publicacion;
import gestorAplicacion.obras.Revista;
import gestorAplicacion.prestamo.Prestamo;

public class Externo extends Persona implements Usuario {
	
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	private static ArrayList<Externo> usuariosExternos = new ArrayList<Externo>(); 
		
	//ATRIBUTOS INSTANCIA
	private String universidad= "No especificada";	
	private int deudas;
	private  ArrayList<Prestamo>prestamos= new ArrayList<Prestamo>();	
	
	//CONSTRUCTORES
	public Externo(String nombre,int id,String correo,int tel,String direccion, LocalDate nacimiento, String paisOrigen){
		super( nombre, id, correo, tel, direccion,  nacimiento,  paisOrigen);
		usuariosExternos.add(this);
	}
	public Externo(String nombre,int id,String correo,short tel,String direccion,LocalDate nacimiento, String paisOrigen, String universidad){// Constructor con el parametro opcional Universidad
		super( nombre, id, correo, tel, direccion, nacimiento,  paisOrigen);
		this.universidad=universidad;
		usuariosExternos.add(this);
	}
	
	//METODOS 
	public String infoPersonal() {
		return "DATOS PERSONALES :"+"\n" +"Nombre:  " + this.nombre + "\n"+ "ID: "+ this.id 
				+ "\n"+"Universidad: " + this.universidad +"\n"+  "Correo: "+ this.correo +"\n"+ "Telefono: "+this.tel
				+"\n"+"Direccion: "+ this.direccion +"\n"+"Pais de Origen: "+ this.paisOrigen +"\n"+ "Fecha de Nacimiento: "+ this.nacimiento;
	}
	
	public String prestar( Publicacion publicacion,int id,LocalDate inicio) {
		String c ="";
		if(publicacion.verificarPrestado() == false) { // verifica si el libro no esta prestado
			c= "El material se encuentra disponible para prestamo \n \n";
			Prestamo prestamo = new Prestamo(this,  publicacion, id, inicio);
			if (publicacion instanceof Libro) {
				prestamo.determinarFin(this, (Libro) publicacion);
			}else if(publicacion instanceof Revista) {
				prestamo.determinarFin(this, (Revista) publicacion);
			}
			publicacion.setEstado(Publicacion.Estados.PRESTADO);
			c= c+ this.nombre + " ha prestado exitosamente el siguiente material \n \n";
			c= c + publicacion.mostrarInfo()+"\n"; //ligadura dinamica
			c=c+ prestamo.mostrarInfo();
			
			
		}else {
			c="La publicacion ya se encuentra en prestamo.";
		}
		
	
		return c;
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
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

}
