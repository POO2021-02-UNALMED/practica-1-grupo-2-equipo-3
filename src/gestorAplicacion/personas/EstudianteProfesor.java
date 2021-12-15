package gestorAplicacion.personas;

import java.time.LocalDate;
import java.util.ArrayList;


public class EstudianteProfesor extends Persona implements Usuario {
	
	//ATRIBUTOS DE CLASE
	private final static String universidad= "Universidad Nacional Sede Medellin";
	private static ArrayList<EstudianteProfesor>estudiantesyprofesores; 
	
	//ATRIBUTOS INSTANCIA
	private int deudas;
	
	//CONSTRUCTORES
	public EstudianteProfesor(String nombre,int id,String correo,short tel,String direccion, LocalDate nacimiento, String paisOrigen){
		super( nombre, id, correo, tel, direccion,  nacimiento,  paisOrigen);
		estudiantesyprofesores.add(this);
	}

	public static ArrayList<EstudianteProfesor> getEstudiantesyprofesores() {
		return estudiantesyprofesores;
	}

	public static void setEstudiantesyprofesores(ArrayList<EstudianteProfesor> estudiantesyprofesores) {
		EstudianteProfesor.estudiantesyprofesores = estudiantesyprofesores;
	}

	public static String getUniversidad() {
		return universidad;
		
	}

	public int getDeudas() {
		return deudas;
	}

	public void setDeudas(int deudas) {
		this.deudas = deudas;
	}
	
	
	
	
}
