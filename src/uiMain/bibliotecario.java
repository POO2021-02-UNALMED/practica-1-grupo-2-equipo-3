package uiMain;

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
					
					System.out.println("Número:");
					System.out.println("Piso:");
					System.out.println("Límte inferior:");
					System.out.println("Límite superior:");
				
					break;
					case 2: System.out.println(" Menú con tipo de publicacion: ");break;
					case 3: System.out.println(" Se llena con constructor de autor");break;
					case 4: System.out.println(" Menú con tipo de usuario: ");break;
					case 5: System.out.println(" Se llena con constructor de autor");break;
					case 6: break;
				}
			} while (opcion2 !=6);
			break;
			
			
			case 2: System.out.println("Está mostrando ..."); break;
			case 3: System.out.println("Está eliminando ..."); break;
			case 4: break;
			
			} //cierre del switch menú principal
		
		
		} while (opcion !=4); // cierre del do menú principal

	
	
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
}
