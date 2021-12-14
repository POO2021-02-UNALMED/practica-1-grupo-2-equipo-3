package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import gestorAplicacion.obras.Publicacion;
import gestorAplicacion.obras.Estanteria;
import gestorAplicacion.personas.Persona;
import gestorAplicacion.prestamo.Prestamo;


public class Serializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	
	// Método para serializar todas las publicaciones creadas
	private static void serializarPublicaciones() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		try {
			fos = new FileOutputStream(rutaTemp + "\\publicaciones.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Publicacion publicacion : Publicacion.getLista()) {
				oos.writeObject(publicacion);
			}
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// Método para serializar todas las personas creadas
	private static void serializarPersonas() {
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(rutaTemp + "\\personas.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Persona persona : Persona.getLista()) {
				oos.writeObject(persona);
			}
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Método para serializar todas las estanterias creadas
	private static void serializarEstanterias() {
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(rutaTemp + "\\estanterias.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Estanteria estanteria : Estanteria.getLista()) {
				oos.writeObject(estanteria);
			}
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Método para serializar todas los prestamos creados
	private static void serializarPrestamos() {
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(rutaTemp + "\\prestamos.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Prestamo prestamo : Prestamo.getLista()) {
				oos.writeObject(prestamo);
			}
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Método para serializar todos los objetos creados y garantizar persistencia
	public static void serializar() {
		serializarPublicaciones();
		serializarPersonas();
		serializarEstanterias();
		serializarPrestamos();
	}

}
