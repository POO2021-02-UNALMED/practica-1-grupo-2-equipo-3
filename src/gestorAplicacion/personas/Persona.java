package gestorAplicacion.personas;

import java.util.ArrayList;

abstract class Persona {
	
	//ATRIBUTOS DE CLASE
	public static ArrayList<Persona> lista = new ArrayList<>();
	
	//ATRIBUTOS INSTANCIA
	protected String nombre;
	protected int id;
	protected String correo;
	protected short tel;
	protected String direccion;
	protected short edad;
	protected String paisOrigen;
	protected boolean vivo=true;
	
	//CONSTRUCTORES
	Persona (String nombre, short edad, String paisOrigen){
		this.nombre=nombre;
		this.edad=edad;
		this.paisOrigen=paisOrigen;
	}
	Persona(String nombre,int id,String correo,short tel,String direccion, short edad, String paisOrigen){
		this.nombre=nombre;
		this.id=id;
		this.correo=correo;
		this.tel=tel;
		this.direccion=direccion;
		this.edad=edad;
		this.paisOrigen=paisOrigen;
	}
	
		
		
		
	//GETTERS SETTERS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public short getEdad() {
		return edad;
	}
	public void setEdad(short edad) {
		this.edad = edad;
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
}
