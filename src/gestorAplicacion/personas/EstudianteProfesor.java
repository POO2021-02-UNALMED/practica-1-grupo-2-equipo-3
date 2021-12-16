package gestorAplicacion.personas;

import java.time.LocalDate;
import java.util.ArrayList;
import gestorAplicacion.obras.Libro;
import gestorAplicacion.obras.Revista;
import gestorAplicacion.obras.Publicacion;
import gestorAplicacion.prestamo.Prestamo;


public class EstudianteProfesor extends Persona implements Usuario {
	
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	private static ArrayList<EstudianteProfesor>estudiantesyprofesores = new ArrayList<EstudianteProfesor>(); 
	public static enum Rol  {ESTUDIANTE, PROFESOR,OTRO};
	
	//ATRIBUTOS INSTANCIA
	private final String universidad= "Universidad Nacional Sede Medellin";
	private int deudas;
	private Rol rol;
	private  ArrayList<Prestamo>prestamos= new ArrayList<Prestamo>();
	
	
	//CONSTRUCTORES
	public EstudianteProfesor(String nombre,int id,Rol rol,String correo,int tel,String direccion, LocalDate nacimiento, String paisOrigen){
		super( nombre, id, correo, tel, direccion,  nacimiento,  paisOrigen);
		this.rol=rol;
		//estudiantesyprofesores.add(this);
		Persona.lista.add(this);
		
	}
	
	//METODOS
	public String infoPersonal() {
		return "DATOS PERSONALES :"+"\n" +"Nombre:  " + this.nombre +"\n"+ "Rol: "+this.rol+ "\n"+ "ID: "+ this.id 
				+ "\n"+"Universidad: " + this.universidad +"\n"+  "Correo: "+ this.correo +"\n"+ "Telefono: "+this.tel
				+"\n"+"Direccion: "+ this.direccion +"\n"+"Pais de Origen: "+ this.paisOrigen +"\n"+ "Fecha de Nacimiento: "+ this.nacimiento;
	}
	
	public String prestar( Publicacion publicacion,int id,LocalDate inicio) { // Metodo para prestar un material
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
			c= c + publicacion.mostrarInfo()+"\n \n"; //ligadura dinamica
			c=c+ prestamo.mostrarInfo();
			
			
		}else {
			c="La publicacion ya se encuentra en prestamo.";
		}
		
	
		return c;
	}
	

	
	
	public String renovar(Prestamo prestamo) {
		Publicacion publicacion = prestamo.getPublicacion();
		prestamo.getFin(); Prestamo.
		String c ="";
		
		
		c += "Error!!  Aún debe esperar "+"días para renovar" ;
		c += "Renovación exitosa";
		
		
		if (publicacion instanceof Libro) {
			prestamo.determinarFin(this, (Libro) publicacion);
		}else if(publicacion instanceof Revista) {
			prestamo.determinarFin(this, (Revista) publicacion);
		}
		
		
		
		return c;
	}

	
	public String renovar(int idprestamo) {
		Prestamo prestamo = null;
		String c = "";
		for(Prestamo prest : Prestamo.getLista()) {
			if (prest.getId() == idprestamo){
				prestamo = prest;c ="Prestamo encontrado";
				this.renovar(prest);}} 
		if (prestamo == null) {c= "Prestamo encontrado";}
		return c;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
}
