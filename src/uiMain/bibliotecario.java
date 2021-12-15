package uiMain;

import java.time.LocalDate;
import java.util.Scanner;
import baseDatos.*; 
import gestorAplicacion.obras.*;
import gestorAplicacion.obras.Revista.Meses;
import gestorAplicacion.personas.*;


public class bibliotecario {
	static Scanner sc = new Scanner(System.in);
	static long readLong() {return sc.nextLong();}
	static String readLn() {return sc.nextLine();}
	

	public static void main(String[] args) {
		
		// Se eliminan todos los objetos creados para trabajar solamente con los de los arcvhivos
		Deserializador.resetarMemoria();
		
		// Se almacenan en memoria ram todas las clases antes creadas
		//Deserializador.deserializar();
		//Deserializador.deserializarPublicaciones();;
		
		System.out.println("Hola!\nBienvenido al Sistema de Gestión de la Biblioteca");
		
		// Menú de opciones principal
		int opcion;
		do {
			
			
			System.out.println("\nMENÚ PRINCIPAL: ");
			System.out.println("-------------------------");
			System.out.println(" 1. Añadir Registros");
			System.out.println(" 2. Mostrar registros");
			System.out.println(" 3. Eliminar registros");
			System.out.println(" 4. Guardar datos y salir del sistema");
			System.out.println("-------------------------");
		
			System.out.println("Teclee la opción: ");
			opcion = (int) readLong();
			
			switch(opcion) {
			
			case 1: // Menú de opciones para registrar 
				int opcion2;
			do {
				System.out.println("\nREGISTRO DE DATOS");
				System.out.println("¿Qué desea registrar?");
				System.out.println("-------------------------");
				System.out.println("Menú de opciones: ");
				System.out.println(" 1. Estantería");
				System.out.println(" 2. Publicación");
				System.out.println(" 3. Autor");
				System.out.println(" 4. Usuario");
				System.out.println(" 5. Prestamo");
				System.out.println(" 6. Volver al menú principal");
				System.out.println("-------------------------");
				
				System.out.println("Teclee la opción: ");
				opcion2 = (int) readLong();
				
				switch(opcion2) {
					case 1: System.out.println("Ingrese los datos de la Estantería:");
					
					System.out.println("Número:"); short n = (short) readLong();
					System.out.println("Piso:"); short p = (short) readLong();
					System.out.println("Límte inferior:"); String li = readLn();
					System.out.println("Límite superior:"); String ls = readLn();
					String[] l = {li,ls};
					new Estanteria(n, p, l);
					break;
					
					case 2:// Menú de opciones para publicacion
						System.out.println("-------------------------");
						System.out.println("Tipo de publicacion: ");
						System.out.println(" 1. Libro");
						System.out.println(" 2. Revista");
						System.out.println(" 3. Folleto");
						System.out.println("-------------------------");
						Estanteria estanteria = null;
						System.out.println("Teclee la opción: ");
						int opcion3;
						opcion3 = (int) readLong();
						
						switch (opcion3) {
						case 1: System.out.println("Ingrese los datos del Libro");
						
		
						Libro.tipoLibro tipo = null;
						System.out.println("-------------------------");
						System.out.println("Tipo de libro: ");
						System.out.println(" 1. Coleccion General");
						System.out.println(" 2. Reserva");
						System.out.println(" 3. Investigacion");
						System.out.println(" 4. Seminario");
						System.out.println(" 5. Tesis");
						System.out.println("-------------------------");
						System.out.println("Teclee la opción: ");
						opcion = (int) readLong();
						
						switch(opcion) {
						case 1: tipo = Libro.tipoLibro.COLECCION_GENERAL;break;
						case 2: tipo = Libro.tipoLibro.RESERVA;break;
						case 3: tipo = Libro.tipoLibro.INVESTIGACION;break;
						case 4: tipo = Libro.tipoLibro.SEMINARIO;break;
						case 5: tipo = Libro.tipoLibro.TESIS;break;
						default: System.out.println("Tipo de libro inválido");break;
						}

						System.out.println("Código:"); int cod = (int) readLong();
						System.out.println("Nombre:"); String nombre2 = readLn();
						System.out.println("Año:"); short aa = (short) readLong();
						System.out.println("Ejemplar:"); short ejemplar = (short) readLong();
						System.out.println("Referencia :"); String ref= readLn();
						System.out.println("Volumen:"); short vol = (short) readLong();
						System.out.println("ID del autor:"); short nautor = (short) readLong();
						Autor autor = null;
						for (Persona a: Persona.getLista()) {
							if (a.getId() == nautor) {autor = (Autor) a;}
						}
						System.out.println("Número de Estantería:"); short nes = (short) readLong();
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == nes) {estanteria = e;}
						}
						
						new Libro (cod,nombre2,aa,ejemplar,autor,tipo,ref,vol,estanteria);
						break;
						
						case 2: System.out.println("Ingrese los datos de la Revista");
						
						Revista.Meses mes = null;
						System.out.println("Mes en español y en Mayúsculas:"); String m = readLn();
						if (Meses.valueOf(m) == null) {
							System.out.println("Mes inválido");
						}
						System.out.println("Código:"); cod = (int) readLong();
						System.out.println("Nombre:"); nombre2 = readLn();
						System.out.println("Año:"); aa = (short) readLong();
						System.out.println("Ejemplar:"); ejemplar = (short) readLong();
						System.out.println("Número:"); short numero = (short) readLong();
						System.out.println("Temporada:"); String temporada = readLn();
						System.out.println("Número de Estantería:");  nes = (short) readLong();
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == nes) {estanteria = e;}
						}
						
						new Revista (cod,nombre2,aa,ejemplar,numero,mes,temporada,estanteria);
						break;
						
						case 3: System.out.println("Ingrese los datos del Folleto");
						
						System.out.println("Código:"); cod = (int) readLong();
						System.out.println("Nombre:"); nombre2 = readLn();
						System.out.println("Año:"); aa = (short) readLong();
						System.out.println("Ejemplar:"); ejemplar = (short) readLong();
						System.out.println("Referencia:"); ref = readLn();
						System.out.println("Número de Estantería:");  nes = (short) readLong();
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == nes) {estanteria = e;}
						}
						
						new Folleto (cod,nombre2,aa,ejemplar,ref,estanteria);
						break;
						
						default: 
							System.out.println("Opción no válida");break;
						}
						
						
					break;
					
					case 3: System.out.println("Ingrese los datos del autor");
					
					System.out.println("¿Está vivo el autor?:");
					System.out.println("Responda SI O NO"); String v = readLn();
					System.out.println("ID:"); int id = (int)readLong();
					System.out.println("Nombre:"); String nautor = readLn();
					System.out.println("Fecha de nacimiento en formato AAAA-MM-DD"); String nacimiento = readLn();
					System.out.println("País de Origen"); String pais = readLn();
	
					boolean vivo;
					if (v == "SI") {vivo = true;
					}else {vivo = false;}
					
					 new Autor (id, nautor,LocalDate.parse(nacimiento), pais,vivo);
					
					break;
					
					case 4: // Menú de opciones para usuario
						System.out.println("-------------------------");
						System.out.println("Tipo de usuario: ");
						System.out.println(" 1. Estudiante/profesor");
						System.out.println(" 2. Externo");
						System.out.println("-------------------------");
						System.out.println("Teclee la opción: ");
						int opcion4;
						opcion4 = (int) readLong();
						
						switch (opcion4) {
						case 1: System.out.println("Ingrese los datos del estudiante/profesor");
						
						System.out.println("Nombre:"); String nombre = readLn();
						System.out.println("Id:"); id = (short) readLong();
						System.out.println("Correo:"); String correo = readLn();
						System.out.println("Telefono:"); short tel = (short) readLong();
						System.out.println("Direccion:"); String direccion = readLn();
						System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac = readLn();
						System.out.println("País de Origen:"); String origen = readLn();
						
						new EstudianteProfesor(nombre,id,correo,tel,direccion, LocalDate.parse(nac), origen);
						break;
						
						case 2: System.out.println("Ingrese los datos del usuario externo");
						System.out.println("¿Pertenece a alguna Universidad?");
						System.out.println("Responda SI O NO"); String u = readLn();
						if (u == "SI") {
							System.out.println("Universidad"); String uni = readLn();
						}
						System.out.println("Nombre:"); String nombre2 =  readLn();
						System.out.println("Id:"); short id2 = (short) readLong();
						System.out.println("Correo:"); String correo2 = readLn();
						System.out.println("Telefono:"); short tel2 = (short) readLong();
						System.out.println("Direccion:"); String direccion2 = readLn();
						System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac2 = readLn();
						System.out.println("País de Origen:"); String origen2 = readLn();
						
						new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2);
						break;
						
						default:
							System.out.println("Opción no válida");break;
						}
						
						
					break;
					
					case 5: System.out.println("Ingrese los datos del Prestamo:");
					
					
					
					
					break;
					case 6: break;
				}
			} while (opcion2 !=6);
			break;
			
			
			case 2: System.out.println("Está mostrando ..."); break;
			case 3: System.out.println("Está eliminando ..."); break;
			case 4: break;
			
			} //cierre del switch - menú principal
		
		
		} while (opcion !=4); // cierre del do - menú principal

	
	Serializador.serializar();
	
	
	
	} // cierre del método main

	
	
	
	
	
	
	
	
	
	
	
}
