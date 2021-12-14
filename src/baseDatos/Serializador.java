package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.obras.*;
import gestorAplicacion.personas.*;


public class Serializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	
	// Método para serializar todas las publicaciones creadas
	public static void serializarPublicaciones() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		try {
			fos = new FileOutputStream(System.getProperty("user.dir") + "\\tmp\\publicaciones.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Publicacion publicacion : Publicacion.lista) {
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
	public static void serializarPersonas() {
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(System.getProperty("user.dir") + "\\tmp\\personas.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Persona persona : Persona.lista) {
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
	public static void serializarEstanterias() {
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(System.getProperty("user.dir") + "\\tmp\\estanterias.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Estanteria estanteria : Estanteria.lista) {
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


}
