package gestorAplicacion.personas;

import java.time.LocalDate;
import java.util.ArrayList;


public class EstudianteProfesor extends Persona implements Usuario {
	
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	private static ArrayList<EstudianteProfesor>estudiantesyprofesores = new ArrayList<EstudianteProfesor>(); 
	private static enum Rol  {ESTUDIANTE, PROFESOR,OTRO};
	
	//ATRIBUTOS INSTANCIA
	private final String universidad= "Universidad Nacional Sede Medellin";
	private int deudas;
	private Rol rol;
	
	
	//CONSTRUCTORES
	public EstudianteProfesor(String nombre,int id,String correo,short tel,String direccion, LocalDate nacimiento, String paisOrigen){
		super( nombre, id, correo, tel, direccion,  nacimiento,  paisOrigen);
		estudiantesyprofesores.add(this);
	}
	
	//METODOS
	public String infoPersonal() {
		return "DATOS PERSONALES :"+"\n" +"Nombre:  " + this.nombre +"\n"+ "Rol: "+this.rol+ "\n"+ "ID: "+ this.id 
				+ "\n"+"Universidad: " + this.universidad +"\n"+  "Correo: "+ this.correo +"\n"+ "Telefono: "+this.tel
				+"\n"+"Direccion: "+ this.direccion +"\n"+"Pais de Origen"+ this.paisOrigen +"\n"+ "Fecha de Nacimiento: "+ this.nacimiento;
	}
	
	
	//GETTERS SETTERS 

	public static ArrayList<EstudianteProfesor> getEstudiantesyprofesores() {
		return estudiantesyprofesores;
	}

	public static void setEstudiantesyprofesores(ArrayList<EstudianteProfesor> estudiantesyprofesores) {
		EstudianteProfesor.estudiantesyprofesores = estudiantesyprofesores;
	}

	public  String getUniversidad() {
		return universidad;
		
	}

	public int getDeudas() {
		return deudas;
	}

	public void setDeudas(int deudas) {
		this.deudas = deudas;
	}
	
	
	
	
}
