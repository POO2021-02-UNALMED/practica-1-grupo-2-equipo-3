package gestorAplicacion.prestamo;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;

import gestorAplicacion.obras.Libro;
import gestorAplicacion.obras.Publicacion;
import gestorAplicacion.obras.Revista;
import gestorAplicacion.personas.EstudianteProfesor;
import gestorAplicacion.personas.Externo;
import gestorAplicacion.personas.Persona;

public class Prestamo implements Serializable {
	
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	private static ArrayList<Prestamo> lista = new ArrayList<>();
	private final static LocalDate fechaActual= LocalDate.now();	
	
	
	//ATRIBUTOS DE INSTANCIA
	private int id;
	private LocalDate inicio;
	private LocalDateTime fin;
	private Publicacion publicacion;
	private Persona usuario;
	private int multa;
	//reserva?
	
	//CONSTRUCTORES
	public Prestamo(EstudianteProfesor usuario, Publicacion publicacion,int id,LocalDate inicio) { // constructor para los usuarios de la universidad
		this.usuario=usuario;
		this.publicacion=publicacion;
		this.id=id;
		this.inicio=inicio;
		usuario.getPrestamos().add(this);
		lista.add(this);
	}
	public Prestamo(Externo usuario, Publicacion publicacion,int id,LocalDate inicio) { // constructor para los usuarios externos de la universidad
		this.usuario=usuario;
		this.publicacion=publicacion;
		this.id=id;
		this.inicio=inicio;
		usuario.getPrestamos().add(this);
		lista.add(this);
	}
	
	//METODOS
	 public void determinarFin(EstudianteProfesor usuario, Libro publicacion) {
		if ( publicacion.getTipo() == Libro.tipoLibro.RESERVA) {
			this.fin= this.inicio.plusDays(1).atTime(LocalTime.of(12, 0));
		}
		else if( publicacion.getTipo() == Libro.tipoLibro.COLECCION_GENERAL) {
			this.fin= this.inicio.plusDays(30).atTime(LocalTime.of(12, 0));
		}else {}
	}
	 
	 public void determinarFin(EstudianteProfesor usuario, Revista publicacion) {
		this.fin= this.inicio.plusDays(15).atTime(LocalTime.of(12, 0));
		}
	 
	 public void determinarFin(Externo usuario, Libro publicacion) {
		 if ( publicacion.getTipo() == Libro.tipoLibro.COLECCION_GENERAL) {
			 this.fin= this.inicio.plusDays(15).atTime(LocalTime.of(12, 0));
		 }
	}
	 
	 public void determinarFin(Externo usuario, Revista publicacion) {
		 this.fin= this.inicio.plusDays(7).atTime(LocalTime.of(12, 0));
	}
	 public String mostrarInfo() {
		 return " DETALLE DEL PRESTAMO " + "\n" + "Publicacion: " + this.publicacion.getNombre() + "\n" + "Usuario: " + this.usuario.getNombre() + "\n" 
					+ "ID: " + this.id + "\n" + "Fecha de inicio: " + this.inicio + "\n" + "Fecha de vencimiento: " + this.fin;
	 }
	
	
	//GETTERS SETTERS
	public static ArrayList<Prestamo> getLista() {
		return lista;
	}
	public static void setLista(ArrayList<Prestamo> lista) {
		Prestamo.lista = lista;
	}
	public static LocalDate getFechaactual() {
		return fechaActual;
	}
	
	

}
