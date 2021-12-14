package gestorAplicacion.prestamo;

import java.time.*;
import java.util.ArrayList;

public class Prestamo {
	
	//ATRIBUTOS DE CLASE
	private static ArrayList<Prestamo> lista = new ArrayList<>();
	
	
	
	//ATRIBUTOS DE INSTANCIA
	private int id;
	private LocalDate inicio;
	private LocalDate fin;
	private int multa;
	
	//CONSTRUCTORES
	
	
	//GETTERS SETTERS
	public static ArrayList<Prestamo> getLista() {
		return lista;
	}
	public static void setLista(ArrayList<Prestamo> lista) {
		Prestamo.lista = lista;
	}
	
	

}
