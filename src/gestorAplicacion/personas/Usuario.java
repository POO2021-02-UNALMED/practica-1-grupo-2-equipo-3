package gestorAplicacion.personas;
import java.time.LocalDate;

import gestorAplicacion.obras.Publicacion;
import gestorAplicacion.prestamo.Prestamo;

public abstract interface Usuario{
	
	public abstract String prestar(Publicacion publicacion,int id,LocalDate inicio); // metodo abstracto para el usuario prestar un libro
	//public abstract String Renovar(Prestamo prestamo);
	//public abstract void prestamoVigente();// metodo abstracto que se hereda para verificar que prestamo esta vigente en el usuario(persona) si lo hay
	
}
