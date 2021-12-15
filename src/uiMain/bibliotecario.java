package uiMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import baseDatos.*; 
import gestorAplicacion.obras.*;
import gestorAplicacion.obras.Libro.tipoLibro;
import gestorAplicacion.personas.*;


public class bibliotecario {
	static Scanner sc = new Scanner(System.in);
	static long readLong() {return sc.nextLong();}
	static String readLn() {return sc.nextLine();}
	

	public static void main(String[] args) {
		
		// Se eliminan todos los objetos creados para trabajar solamente con los de los archivos almacenados
		//Deserializador.resetarMemoria();
		Deserializador.deserializar();
		
		// Crear autor anónimo y estantería vacía si no oestán ya creados
		
		ArrayList<Integer> autores_id = new ArrayList<Integer>();
		for(Autor autor : Autor.getAutores()) {autores_id.add(autor.getId());}
		if (autores_id.contains(0) == false) {new Autor();}
		
		ArrayList<Short> estanterias_numeros = new ArrayList<Short>();
		for(Estanteria estanteria : Estanteria.getLista()) {estanterias_numeros.add(estanteria.getNumero());}
		if (estanterias_numeros.contains((short) 0) == false) {new Estanteria();}

		
		
		  ///////////////////////////
		 /// INICIO DEL SISTEMA ////
		///////////////////////////
		System.out.println("Hola!\nBienvenido al Sistema de Gestión de la Biblioteca");
		
		// Menú de opciones principal
		int opcion;
		do {
			
			
			System.out.println("\nMENÚ PRINCIPAL: ");
			System.out.println("-------------------------");
			System.out.println(" 1. Añadir Registros");
			System.out.println(" 2. Mostrar registros");
			System.out.println(" 3. Eliminar registros");
			System.out.println(" 4. Funcionalidad A");
			System.out.println(" 5. Funcionalidad B");
			System.out.println(" 6. Funcionalidad C");
			System.out.println(" 7. Funcionalidad D");
			System.out.println(" 8. Funcionalidad E");
			System.out.println(" 9. Guardar datos y salir del sistema");
			System.out.println("-------------------------");
		
			System.out.println("Teclee la opción(N): ");
			opcion = (int) readLong();readLn();
			
			switch(opcion) {
			
			

			
			
			//////////
			///////
			/// Menú de opciones para registrar 
			///////
			//////////		
			case 1: 
			do {
				System.out.println("\nREGISTRO DE DATOS");
				System.out.println("¿Qué desea registrar?");
				System.out.println("-------------------------");
				System.out.println("Menú de opciones: ");
				System.out.println(" 1. Estantería");
				System.out.println(" 2. Publicación");
				System.out.println(" 3. Autor");
				System.out.println(" 4. Usuario");
				System.out.println(" 5. Volver al menú principal");
				System.out.println("-------------------------");
				
				System.out.println("Teclee la opción(N): ");
				opcion = (int) readLong();readLn();
				
				switch(opcion) {
					case 1: System.out.println("Ingrese los datos de la Estantería:");
					
					System.out.println("Número (N):"); short n = (short) readLong();
					System.out.println("Piso (N):"); short p = (short) readLong();readLn();
					System.out.println("Límte inferior (S):"); 
					String li = readLn();
					System.out.println("Límite superior (S):"); 
					String ls = readLn();
					String[] l = new String[]{li,ls};
					new Estanteria(n, p, l);
					System.out.println("Estanteria registrada con éxito");
					break;
					
					case 2:// Menú de opciones para publicacion
						System.out.println("-------------------------");
						System.out.println("Tipo de publicacion: ");
						System.out.println(" 1. Libro");
						System.out.println(" 2. Revista");
						System.out.println(" 3. Folleto");
						System.out.println("-------------------------");
						Estanteria estanteria = null;
						ArrayList<Short> numeros_estanterias = new ArrayList<Short>();
						for (Estanteria e: Estanteria.getLista()) {
							numeros_estanterias.add( e.getNumero() );}
						System.out.println("Teclee la opción (N): ");
						int opcion3;
						opcion3 = (int) readLong();
						
						switch (opcion3) {
						case 1:
						int opcion2;
						do {
						System.out.println("Ingrese los datos del Libro");

						Libro.tipoLibro tipo = null;
						System.out.println("-------------------------");
						System.out.println("Tipo de libro: ");
						System.out.println(" 1. Coleccion General");
						System.out.println(" 2. Reserva");
						System.out.println(" 3. Investigacion");
						System.out.println(" 4. Seminario");
						System.out.println(" 5. Tesis");
						System.out.println(" 6. Volver al Menú de Registro");
						System.out.println("-------------------------");
						System.out.println("Teclee la opción (N): ");
						opcion2 = (int) readLong();
						
						switch(opcion2) {
						case 1: tipo = Libro.tipoLibro.COLECCION_GENERAL;break;
						case 2: tipo = Libro.tipoLibro.RESERVA;break;
						case 3: tipo = Libro.tipoLibro.INVESTIGACION;break;
						case 4: tipo = Libro.tipoLibro.SEMINARIO;break;
						case 5: tipo = Libro.tipoLibro.TESIS;break;
						case 6: break;
						default: System.out.println("Tipo de libro inválido");break;
						}}while(opcion2 !=1 & opcion2 != 2 & opcion2 != 3 & opcion2 != 4 & opcion2 != 5 & opcion2 != 6);
						
						if(opcion2 != 6) {

						System.out.println("Código (N):"); int cod = (int) readLong();readLn();
						System.out.println("Nombre (S):"); String nombre2 = readLn();
						System.out.println("Año: (N)"); short aa = (short) readLong();
						System.out.println("Ejemplar (N):"); short ejemplar = (short) readLong();readLn();
						System.out.println("Referencia (S):"); String ref= readLn();
						System.out.println("Volumen (N):"); short vol = (short) readLong();
						System.out.println("ID del autor (N):"); short nautor = (short) readLong();readLn();
						Autor autor = null;
						for (Autor a: Autor.getAutores()) {
							if (a.getId() == nautor) {autor = a;}
						}
						System.out.println("Número de Estantería (N):"); short nes = (short) readLong();readLn();
						Estanteria estanteria = null;
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == nes) {estanteria = e;}
						}
							
						
						tipoLibro tipo = null;
						new Libro (cod,nombre2,aa,ejemplar,autor,tipo,ref,vol,estanteria);
			
						 System.out.println("Libro registrado con éxito");
	
						break;
						
						case 2: System.out.println("Ingrese los datos de la Revista");
						
						// Valores del enumerado Meses en una lista de Strings
						ArrayList<String> list = new ArrayList<String>();
						for (Revista.Meses mes : Revista.Meses.values()) {
							String m = mes.toString();
							list.add(m);}
						readLn();
						System.out.println("Mes en español y en Mayúsculas (N):"); String m = readLn();
						if (list.contains(m) == false) {System.out.println("Mes inválido");
						System.out.println("De vuelta al Menú de Registro de Datos");break;}
						Revista.Meses mes = Revista.Meses.valueOf(m);
						System.out.println("Código (N):"); int cod = (int) readLong();readLn();
						System.out.println("Nombre (S):"); String nombre2 = readLn();
						System.out.println("Año (N):");short aa = (short) readLong();
						System.out.println("Ejemplar (N):"); short ejemplar = (short) readLong();
						System.out.println("Número (N):"); short numero = (short) readLong();readLn();
						System.out.println("Temporada (S):"); String temporada = readLn();
						System.out.println("Número de Estantería (N):");  short es = (short) readLong();readLn();
						if (numeros_estanterias.contains(es) == false) {
							System.out.println("Estantería inválida");
						}else {
							for (Estanteria e: Estanteria.getLista()) {
								if (e.getNumero() == es) {estanteria = e;}}
						new Revista (cod,nombre2,aa,ejemplar,numero,mes,temporada,estanteria);
						 System.out.println("Revista registrada con éxito");}
						break;
						
						case 3: System.out.println("Ingrese los datos del Folleto");
						
						readLn();
						System.out.println("Código:"); cod = (int) readLong();readLn();
						System.out.println("Nombre:"); nombre2 = readLn();
						System.out.println("Año:"); aa = (short) readLong();
						System.out.println("Ejemplar:"); ejemplar = (short) readLong();readLn();
						System.out.println("Referencia:"); String ref = readLn();
						System.out.println("Número de Estantería:");  short nes = (short) readLong();
						if (numeros_estanterias.contains(nes) == false) {
							System.out.println("Estantería inválida");
						}else {
							for (Estanteria e: Estanteria.getLista()) {
								if (e.getNumero() == nes) {estanteria = e;}}
							}
						
						new Folleto (cod,nombre2,aa,ejemplar,ref,estanteria);
						 System.out.println("Folleto registrado con éxito");
						break;
						
						default: 
							System.out.println("Opción no válida\nDevuelta al Menú de Registro");break;
						} // cierre del switch de registrar publicacion

					break;
					
					case 3: int v;
					boolean vivo = false;
					do {	
					System.out.println("\nIngrese los datos del autor");
					
					System.out.println("¿Está vivo el autor?:");
					System.out.println("-------------------------");
					System.out.println(" 1. Si");
					System.out.println(" 2. No");
					System.out.println(" 3. Volver al Menú de Registro");
					System.out.println("-------------------------");
					System.out.println("Teclee la opción: ");
					v = (int) readLong();
					switch(v){
					case 1: vivo = true; break;
					case 3: break;
					default: 
						System.out.println("Opción no válida\nIntente otra vez");break;
						}
					} while (v !=1 & v !=2 & v !=3);
					
					if (v !=3) {
					System.out.println("ID:"); int id = (int)readLong();readLn();
					System.out.println("Nombre:"); String nautor = readLn();
					System.out.println("Fecha de nacimiento en formato AAAA-MM-DD"); String nacimiento = readLn();
					System.out.println("País de Origen"); String pais = readLn();
	

					new Autor (id, nautor,LocalDate.parse(nacimiento), pais,vivo);
					 
					 System.out.println("Autor registrado con éxito");
					}
					break;
					
					case 4: // Menú de opciones para usuario
						System.out.println("-------------------------");
						System.out.println("Tipo de usuario: ");
						System.out.println(" 1. Estudiante/profesor");
						System.out.println(" 2. Externo");
						System.out.println(" 3. Volver al Menú de Registro");
						System.out.println("-------------------------");
						System.out.println("Teclee la opción: ");
						int opcion4;
						opcion4 = (int) readLong();readLn();
						
						switch (opcion4) {
						case 1: System.out.println("Ingrese los datos del estudiante/profesor");
						
						System.out.println("Nombre:"); String nombre = readLn();
						System.out.println("Id:"); short id = (short) readLong();readLn();
						System.out.println("Correo:"); String correo = readLn();
						System.out.println("Telefono:"); short tel = (short) readLong();readLn();
						System.out.println("Direccion:"); String direccion = readLn();
						System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac = readLn();
						System.out.println("País de Origen:"); String origen = readLn();
						
						new EstudianteProfesor(nombre,id,correo,tel,direccion, LocalDate.parse(nac), origen);
						System.out.println("Estudiante o Profesor registrado con éxito!");
						
						break;
						
						case 2: System.out.println("Ingrese los datos del usuario externo");
						System.out.println("¿Pertenece a alguna Universidad?");
						System.out.println("Responda SI O NO"); String u = readLn();
						if(u != "SI" & u!="NO") {
							System.out.println("No digitó una respuesta correcta\nDevuelta al Menú de Registro");
							break;}
						if (u == "SI") {
							System.out.println("Universidad"); String uni = readLn();
							System.out.println("Nombre:"); String nombre2 =  readLn();
							System.out.println("Id:"); short id2 = (short) readLong();readLn();
							System.out.println("Correo:"); String correo2 = readLn();
							System.out.println("Telefono:"); short tel2 = (short) readLong();readLn();
							System.out.println("Direccion:"); String direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac2 = readLn();
							System.out.println("País de Origen:"); String origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2,uni);
							System.out.println("Usuario Externo registrado con éxito!");
							break;
							
						}else {
							System.out.println("Nombre:"); String nombre2 =  readLn();
							System.out.println("Id:"); short id2 = (short) readLong();readLn();
							System.out.println("Correo:"); String correo2 = readLn();
							System.out.println("Telefono:"); short tel2 = (short) readLong();readLn();
							System.out.println("Direccion:"); String direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac2 = readLn();
							System.out.println("País de Origen:"); String origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2);
							System.out.println("Usuario Externo registrado con éxito!");
							break;
							
						}
						
						case 3: break;

						
						default:
							System.out.println("Opción no válida\nDevuelta al Menú de Registro");break;
						}
						
						
					break;
					
					
	
					case 5: break;
				} // cierre switch - registro de datos
			} while (opcion !=5);
			break;
			       //////////
			          ///////
			             /// 
			         ///////
			      //////////
			
			
			
			
			
			//////////
			///////
			/// Menú de opciones para mostrar
			///////
			//////////
			case 2: System.out.println("Está mostrando ..."); break;
			
			
			
		      //////////
	            ///////
	                /// 
	            ///////
	         //////////
			
			
			
			
			
			
			
			
			//////////
			///////
			/// Menú de opciones para eliminar
			///////
			//////////
			case 3: System.out.println("Está eliminando ..."); break;
			
			
		     //////////
               ///////
                   /// 
              ///////
           //////////
			
			
			
			
			
			//////////
			///////
			/// Menú de opciones para A
			///////
			//////////
			case 4: System.out.println("Se está implementando la Funcionalidad A");break;
			
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			
			
			
			
			//////////
			///////
			/// Menú de opciones para B
			///////
			//////////
			case 5: System.out.println("Se está implementando la Funcionalidad B");break;
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			
			
			
			
			
			//////////
			///////
			/// Menú de opciones para C
			///////
			//////////
			case 6: System.out.println("Se está implementando la Funcionalidad C");break;
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			
			
			
			
			
			
			//////////
			///////
			/// Menú de opciones para D
			///////
			//////////
			case 7: System.out.println("Se está implementando la Funcionalidad D");break;
			
			  //////////
				///////
					/// 
				///////
			//////////
			
			
			
			
			
			
			
			
			
			//////////
			///////
			/// Menú de opciones para E
			///////
			//////////
			case 8: System.out.println("Se está implementando la Funcionalidad E");break;
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			case 9: break;

			} //cierre del switch - menú principal
		
		
		} while (opcion !=9); // cierre del do - menú principal

	
		
		
	Serializador.serializar();
	} // cierre del método main

	
	
	
	
	
	
	
	
	
	
	
}
