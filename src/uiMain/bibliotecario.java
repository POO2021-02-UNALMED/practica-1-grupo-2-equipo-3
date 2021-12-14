package uiMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.*; 
import gestorAplicacion.obras.*;
import gestorAplicacion.personas.*;
import gestorAplicacion.prestamo.*;


public class bibliotecario {
	static Scanner sc = new Scanner(System.in);
	static long readLong() {return sc.nextLong();}
	static String readLn() {return sc.nextLine();}
	

	public static void main(String[] args) {
		
		// Se almacenan en memoria ram todas las clases antes creadas
		//Deserializador.deserializar();
		//Deserializador.deserializarPublicaciones();;
		
		System.out.println("Hola!\nBienvenido al Sistema de Gesti�n de la Biblioteca");
		
		// Men� de opciones principal
		int opcion;
		do {
			
			
			System.out.println("\nMEN� PRINCIPAL: ");
			System.out.println("-------------------------");
			System.out.println(" 1. A�adir Registros");
			System.out.println(" 2. Mostrar registros");
			System.out.println(" 3. Eliminar registros");
			System.out.println(" 4. Guardar datos y salir del sistema");
			System.out.println("-------------------------");
		
			System.out.println("Teclee la opci�n: ");
			opcion = (int) readLong();
			
			switch(opcion) {
			
			case 1: // Men� de opciones para registrar 
				int opcion2;
			do {
				System.out.println("\nREGISTRO DE DATOS");
				System.out.println("�Qu� desea registrar?");
				System.out.println("-------------------------");
				System.out.println("Men� de opciones: ");
				System.out.println(" 1. Estanter�a");
				System.out.println(" 2. Publicaci�n");
				System.out.println(" 3. Autor");
				System.out.println(" 4. Usuario");
				System.out.println(" 5. Prestamo");
				System.out.println(" 6. Volver al men� principal");
				System.out.println("-------------------------");
				
				System.out.println("Teclee la opci�n: ");
				opcion2 = (int) readLong();
				
				switch(opcion2) {
					case 1: System.out.println("Ingrese los datos de la Estanter�a:");
					
					System.out.println("N�mero:"); short n = (short) readLong();
					System.out.println("Piso:"); short p = (short) readLong();
					System.out.println("L�mte inferior:"); String li = readLn();
					System.out.println("L�mite superior:"); String ls = readLn();
					String[] l = {li,ls};
					new Estanteria(n, p, l);
					break;
					
					case 2: System.out.println(" Men� con tipo de publicacion: ");
					break;
					
					case 3: System.out.println("Ingrese los datos del autor");
					
					System.out.println("�Est� vivo el autor?:");
					System.out.println("Responda SI O NO"); String v = readLn();
					System.out.println("Nombre:"); String nautor = readLn();
					System.out.println("Fecha de nacimiento en formato AAAA-MM-DD"); String nacimiento = readLn();
					System.out.println("Pa�s de Origen"); String pais = readLn();
	
					boolean vivo;
					if (v == "SI") {vivo = true;
					}else {vivo = false;}
					
					 new Autor (nautor,LocalDate.parse(nacimiento), pais,vivo);
					
					break;
					
					case 4: // Men� de opciones para usuario
						System.out.println("-------------------------");
						System.out.println("Tipo de usuario: ");
						System.out.println(" 1. Estudiante/profesor");
						System.out.println(" 2. Externo");
						System.out.println("-------------------------");
						System.out.println("Teclee la opci�n: ");
						int opcion4;
						opcion4 = (int) readLong();
						
						switch (opcion4) {
						case 1: System.out.println("Ingrese los datos del estudiante/profesor");
						
						System.out.println("Nombre:"); String nombre = readLn();
						System.out.println("Id:"); short id = (short) readLong();
						System.out.println("Correo:"); String correo = readLn();
						System.out.println("Telefono:"); short tel = (short) readLong();
						System.out.println("Direccion:"); String direccion = readLn();
						System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac = readLn();
						System.out.println("Pa�s de Origen:"); String origen = readLn();
						
						new EstudianteProfesor(nombre,id,correo,tel,direccion, LocalDate.parse(nac), origen);
						break;
						
						case 2: System.out.println("Ingrese los datos del usaurio externo");
						System.out.println("�Pertenece a alguna Universidad?");
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
						System.out.println("Pa�s de Origen:"); String origen2 = readLn();
						
						new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2);
						break;
						
						default:
							System.out.println("Opci�n no v�lida");break;
						}
						
						
					break;
					
					case 5: System.out.println("Ingrese los datos del Prestamo:");
					
					
					
					
					break;
					case 6: break;
				}
			} while (opcion2 !=6);
			break;
			
			
			case 2: System.out.println("Est� mostrando ..."); break;
			case 3: System.out.println("Est� eliminando ..."); break;
			case 4: break;
			
			} //cierre del switch men� principal
		
		
		} while (opcion !=4); // cierre del do men� principal

	
	
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
}
