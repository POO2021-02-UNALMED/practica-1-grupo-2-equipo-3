package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.obras.*;


public class Serializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	
	// Método para serializar todas las publicaciones creadas
	public static void serializar(Publicacion publicacion) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		FileOutputStream fileOut;
		try {
			fos = new FileOutputStream(System.getProperty("user.dir") + "\\tmp\\publicaciones.txt");
			
			oos = new ObjectOutputStream(fos);
			
			for (Publicacion publicacion : lista) {
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

	
	
	// Método para serializar todas las estanterias creadas

	
	
	// Método para serializar todas los prestamos creados


}
