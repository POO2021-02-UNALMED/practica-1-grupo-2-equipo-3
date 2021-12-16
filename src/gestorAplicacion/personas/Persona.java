package gestorAplicacion.personas;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;


public abstract class Persona implements Serializable{

	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	protected static ArrayList<Persona> lista = new ArrayList<>();

	
	//ATRIBUTOS INSTANCIA
	protected String nombre;
	protected int id;
	protected String correo;
	protected int tel;
	protected String direccion;
	protected LocalDate nacimiento;
	protected String paisOrigen;
	protected boolean vivo=true;
	
	//CONSTRUCTORES
	Persona(){};
	Persona (int id,String nombre, LocalDate nacimiento, String paisOrigen){
		this.nombre=nombre;
		this.nacimiento=nacimiento;
		this.paisOrigen=paisOrigen;
	}
	Persona(String nombre,int id,String correo,int tel,String direccion,LocalDate nacimiento, String paisOrigen){
		this(id,nombre, nacimiento, paisOrigen);
		this.tel=tel;
		this.direccion=direccion;
		this.paisOrigen=paisOrigen;
	}
	
	//METODOS
	public static void eliminarPersona(Persona p) { // elimina un registro de Persona
		lista.remove(lista.indexOf(p));
	}
	public static String mostrarRegistros() {
		String c="Personas creadas: "+"\n";
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) instanceof Autor ) {c = c + i+"."+"Autor "+ lista.get(i).nombre + "  ID "+ lista.get(i).id+ "\n";	}
			else if(lista.get(i) instanceof EstudianteProfesor) {c = c + i+"."+"Usuario de la Universidad "+ lista.get(i).nombre + "  ID (CP) "+ lista.get(i).getId()+ "\n";}
			else if(lista.get(i) instanceof Externo) {c = c + i+"."+"Usuario externo de la Universidad "+ lista.get(i).nombre + "  ID (CP)"+ lista.get(i).getId()+ "\n";}
		}
		return c;
	}
	
	//METODO ABSTRACTO
	public abstract String infoPersonal ();
		
		
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
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
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
