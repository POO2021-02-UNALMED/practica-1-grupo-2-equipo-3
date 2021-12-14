package gestorAplicacion.personas;

import java.util.ArrayList;


public class EstudianteProfesor extends Persona implements Usuario {
	
	//ATRIBUTOS DE CLASE
	private final static String universidad= "Universidad Nacional Sede Medellin";
	private static ArrayList<EstudianteProfesor>estudiantesyprofesores; 
	
	//ATRIBUTOS INSTANCIA
	
	
	//CONSTRUCTORES
	EstudianteProfesor(String nombre,int id,String correo,short tel,String direccion, short edad, String paisOrigen){
		super( nombre, id, correo, tel, direccion,  edad,  paisOrigen);
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
	
	
	
	
}
