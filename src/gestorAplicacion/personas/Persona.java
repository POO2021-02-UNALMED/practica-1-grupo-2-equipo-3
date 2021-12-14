package gestorAplicacion.personas;

import java.io.Serializable;
import java.time.*;

import java.util.ArrayList;

public abstract class Persona implements Serializable{

	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> lista = new ArrayList<>();

	
	//ATRIBUTOS INSTANCIA
	protected String nombre;
	protected int id;
	protected String correo;
	protected short tel;
	protected String direccion;
	protected LocalDate nacimiento;
	protected String paisOrigen;
	protected boolean vivo=true;
	
	//CONSTRUCTORES
	Persona(){};
	Persona (String nombre, LocalDate nacimiento, String paisOrigen){
		this.nombre=nombre;
		this.nacimiento=nacimiento;
		this.paisOrigen=paisOrigen;
	}
	Persona(String nombre,int id,String correo,short tel,String direccion,LocalDate nacimiento, String paisOrigen){
		this.nombre=nombre;
		this.id=id;
		this.correo=correo;
		this.tel=tel;
		this.direccion=direccion;
		this.nacimiento=nacimiento;
		this.paisOrigen=paisOrigen;
	}
	
		
		
		
	//GETTERS SETTERS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public short getTel() {
		return tel;
	}
	public void setTel(short tel) {
		this.tel = tel;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public static ArrayList<Persona> getLista() {
		return lista;
	}
	public static void setLista(ArrayList<Persona> lista) {
		Persona.lista = lista;
	}
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
}
