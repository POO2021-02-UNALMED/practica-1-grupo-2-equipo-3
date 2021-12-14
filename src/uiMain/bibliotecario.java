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
		// Deserializador.deserializar();
		
		System.out.println("Hola!\nBienvenido al Sistema de Gestión de la Biblioteca");
		
		// Menú de opciones principal
		int opcion;
		do {
			System.out.println("\nMenú de opciones: ");
			System.out.println(" 1. Añadir Registros");
			System.out.println(" 2. Mostrar registros");
			
			System.out.println("Teclee la opción: ");
			opcion = (int) readLong();
			
			switch(opcion) {
			case 1: System.out.println("Está resgistrando ..."); break;
			case 2: System.out.println("Está mostrando ...");
			case 5: Serializador.serializar(); break;
			}
			
		} while (opcion !=5);

	
	
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
}
