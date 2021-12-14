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
		
		System.out.println("Hola!\nBienvenido al Sistema de Gesti�n de la Biblioteca");
		
		// Men� de opciones principal
		int opcion;
		do {
			System.out.println("\nMen� de opciones: ");
			System.out.println(" 1. A�adir Registros");
			System.out.println(" 2. Mostrar registros");
			
			System.out.println("Teclee la opci�n: ");
			opcion = (int) readLong();
			
			switch(opcion) {
			case 1: System.out.println("Est� resgistrando ..."); break;
			case 2: System.out.println("Est� mostrando ...");
			case 5: Serializador.serializar(); break;
			}
			
		} while (opcion !=5);

	
	
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
}
