package gestorAplicacion.personas;
import java.time.LocalDate;
import java.time.LocalDateTime;

import gestorAplicacion.obras.Publicacion;
import gestorAplicacion.prestamo.Prestamo;

public abstract interface Usuario{
	
	public abstract String prestar(Publicacion publicacion,int id,LocalDate inicio); // metodo abstracto para el usuario prestar un libro
	long diasParaVencimiento(LocalDateTime fin);
	String renovar(Prestamo prestamo);
	String renovar(int idprestamo);
	
}
