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
		
		// Se eliminan todos los objetos creados para trabajar solamente con los de los arcvhivos
		//Deserializador.resetarMemoria();
		Deserializador.deserializar();
		
		// Crear autor an�nimo y estanter�a vac�a si no oest�n ya creados
		
		ArrayList<Integer> autores_id = new ArrayList<Integer>();
		for(Autor autor : Autor.getAutores()) {autores_id.add(autor.getId());}
		if (autores_id.contains(0) == false) {new Autor();}
		
		ArrayList<Short> estanterias_numeros = new ArrayList<Short>();
		for(Estanteria estanteria : Estanteria.getLista()) {estanterias_numeros.add(estanteria.getNumero());}
		if (estanterias_numeros.contains((short) 0) == false) {new Estanteria();}

		
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
			opcion = (int) readLong();readLn();
			
			switch(opcion) {
			
			

			
			
			//////////
			///////
			/// Men� de opciones para registrar 
			///////
			//////////		
			case 1: 
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
				opcion = (int) readLong();readLn();
				
				switch(opcion) {
					case 1: System.out.println("Ingrese los datos de la Estanter�a:");
					
					System.out.println("N�mero:"); short n = (short) readLong();
					System.out.println("Piso:"); short p = (short) readLong();readLn();
					System.out.println("L�mte inferior:"); 
					String li = readLn();
					System.out.println("L�mite superior:"); 
					String ls = readLn();
					String[] l = new String[]{li,ls};
					new Estanteria(n, p, l);
					System.out.println("Estanteria registrada con �xito");
					break;
					
					case 2:// Men� de opciones para publicacion
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
						System.out.println("Teclee la opci�n: ");
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
						System.out.println(" 6. Volver al Men� de Registro");
						System.out.println("-------------------------");
						System.out.println("Teclee la opci�n: ");
						opcion2 = (int) readLong();
						
						switch(opcion2) {
						case 1: tipo = Libro.tipoLibro.COLECCION_GENERAL;break;
						case 2: tipo = Libro.tipoLibro.RESERVA;break;
						case 3: tipo = Libro.tipoLibro.INVESTIGACION;break;
						case 4: tipo = Libro.tipoLibro.SEMINARIO;break;
						case 5: tipo = Libro.tipoLibro.TESIS;break;
						case 6: break;
						default: System.out.println("Tipo de libro inv�lido");break;
						}}while(opcion2 !=1 & opcion2 != 2 & opcion2 != 3 & opcion2 != 4 & opcion2 != 5 & opcion2 != 6);
						
						if(opcion2 != 6) {

						System.out.println("C�digo:"); int cod = (int) readLong();readLn();
						System.out.println("Nombre:"); String nombre2 = readLn();
						System.out.println("A�o:"); short aa = (short) readLong();
						System.out.println("Ejemplar:"); short ejemplar = (short) readLong();readLn();
						System.out.println("Referencia :"); String ref= readLn();
						System.out.println("Volumen:"); short vol = (short) readLong();
						System.out.println("ID del autor:"); short nautor = (short) readLong();readLn();
						Autor autor = null;
						for (Persona a: Persona.getLista()) {
							if (a.getId() == nautor) {autor = (Autor) a;}
						}
						System.out.println("N�mero de Estanter�a:"); short nes = (short) readLong();readLn();
						if (numeros_estanterias.contains(nes) == false) {
							System.out.println("Estanter�a inv�lida");
						}else {
							for (Estanteria e: Estanteria.getLista()) {
								if (e.getNumero() == nes) {estanteria = e;}}
							}
						
						tipoLibro tipo = null;
						new Libro (cod,nombre2,aa,ejemplar,autor,tipo,ref,vol,estanteria);
						 System.out.println("Libro registrado con �xito");
						}
						break;
						
						case 2: System.out.println("Ingrese los datos de la Revista");
						
						// Valores del enumerado Meses en una lista de Strings
						ArrayList<String> list = new ArrayList<String>();
						for (Revista.Meses mes : Revista.Meses.values()) {
							String m = mes.toString();
							list.add(m);}
						readLn();
						System.out.println("Mes en espa�ol y en May�sculas:"); String m = readLn();
						if (list.contains(m) == false) {System.out.println("Mes inv�lido");
						System.out.println("Devuela al Men� de Registro de Datos");break;}
						Revista.Meses mes = Revista.Meses.valueOf(m);
						System.out.println("C�digo:"); int cod = (int) readLong();readLn();
						System.out.println("Nombre:"); String nombre2 = readLn();
						System.out.println("A�o:");short aa = (short) readLong();
						System.out.println("Ejemplar:"); short ejemplar = (short) readLong();
						System.out.println("N�mero:"); short numero = (short) readLong();readLn();
						System.out.println("Temporada:"); String temporada = readLn();
						System.out.println("N�mero de Estanter�a:");  short es = (short) readLong();readLn();
						if (numeros_estanterias.contains(es) == false) {
							System.out.println("Estanter�a inv�lida");
						}else {
							for (Estanteria e: Estanteria.getLista()) {
								if (e.getNumero() == es) {estanteria = e;}}
							}
						
						new Revista (cod,nombre2,aa,ejemplar,numero,mes,temporada,estanteria);
						 System.out.println("Revista registrada con �xito");
						break;
						
						case 3: System.out.println("Ingrese los datos del Folleto");
						
						readLn();
						System.out.println("C�digo:"); cod = (int) readLong();readLn();
						System.out.println("Nombre:"); nombre2 = readLn();
						System.out.println("A�o:"); aa = (short) readLong();
						System.out.println("Ejemplar:"); ejemplar = (short) readLong();readLn();
						System.out.println("Referencia:"); String ref = readLn();
						System.out.println("N�mero de Estanter�a:");  short nes = (short) readLong();
						if (numeros_estanterias.contains(nes) == false) {
							System.out.println("Estanter�a inv�lida");
						}else {
							for (Estanteria e: Estanteria.getLista()) {
								if (e.getNumero() == nes) {estanteria = e;}}
							}
						
						new Folleto (cod,nombre2,aa,ejemplar,ref,estanteria);
						 System.out.println("Folleto registrado con �xito");
						break;
						
						default: 
							System.out.println("Opci�n no v�lida\nDevuelta al Men� de Registro");break;
						} // cierre del switch de registrar publicacion

					break;
					
					case 3: int v;
					boolean vivo = false;
					do {	
					System.out.println("\nIngrese los datos del autor");
					
					System.out.println("�Est� vivo el autor?:");
					System.out.println("-------------------------");
					System.out.println(" 1. Si");
					System.out.println(" 2. No");
					System.out.println(" 3. Volver al Men� de Registro");
					System.out.println("-------------------------");
					System.out.println("Teclee la opci�n: ");
					v = (int) readLong();
					switch(v){
					case 1: vivo = true; break;
					case 3: break;
					default: 
						System.out.println("Opci�n no v�lida\nIntente otra vez");break;
						}
					} while (v !=1 & v !=2 & v !=3);
					
					if (v !=3) {
					System.out.println("ID:"); int id = (int)readLong();readLn();
					System.out.println("Nombre:"); String nautor = readLn();
					System.out.println("Fecha de nacimiento en formato AAAA-MM-DD"); String nacimiento = readLn();
					System.out.println("Pa�s de Origen"); String pais = readLn();
	

					new Autor (id, nautor,LocalDate.parse(nacimiento), pais,vivo);
					 
					 System.out.println("Autor registrado con �xito");
					}
					break;
					
					case 4: // Men� de opciones para usuario
						System.out.println("-------------------------");
						System.out.println("Tipo de usuario: ");
						System.out.println(" 1. Estudiante/profesor");
						System.out.println(" 2. Externo");
						System.out.println(" 3. Volver al Men� de Registro");
						System.out.println("-------------------------");
						System.out.println("Teclee la opci�n: ");
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
						System.out.println("Pa�s de Origen:"); String origen = readLn();
						
						new EstudianteProfesor(nombre,id,correo,tel,direccion, LocalDate.parse(nac), origen);
						System.out.println("Estudiante o Profesor registrado con �xito!");
						
						break;
						
						case 2: System.out.println("Ingrese los datos del usuario externo");
						System.out.println("�Pertenece a alguna Universidad?");
						System.out.println("Responda SI O NO"); String u = readLn();
						if(u != "SI" & u!="NO") {
							System.out.println("No digit� una respuesta correcta\nDevuelta al Men� de Registro");
							break;}
						if (u == "SI") {
							System.out.println("Universidad"); String uni = readLn();
							System.out.println("Nombre:"); String nombre2 =  readLn();
							System.out.println("Id:"); short id2 = (short) readLong();readLn();
							System.out.println("Correo:"); String correo2 = readLn();
							System.out.println("Telefono:"); short tel2 = (short) readLong();readLn();
							System.out.println("Direccion:"); String direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac2 = readLn();
							System.out.println("Pa�s de Origen:"); String origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2,uni);
							System.out.println("Usuario Externo registrado con �xito!");
							break;
							
						}else {
							System.out.println("Nombre:"); String nombre2 =  readLn();
							System.out.println("Id:"); short id2 = (short) readLong();readLn();
							System.out.println("Correo:"); String correo2 = readLn();
							System.out.println("Telefono:"); short tel2 = (short) readLong();readLn();
							System.out.println("Direccion:"); String direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD:"); String nac2 = readLn();
							System.out.println("Pa�s de Origen:"); String origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2);
							System.out.println("Usuario Externo registrado con �xito!");
							break;
							
						}
						
						case 3: break;

						
						default:
							System.out.println("Opci�n no v�lida\nDevuelta al Men� de Registro");break;
						}
						
						
					break;
					
					case 5: System.out.println("Ingrese los datos del Prestamo:");
					
					
					
					
					break;
					case 6: break;
				} // cierre switch - registro de datos
			} while (opcion !=6);
			break;
			
			
			
			
			//////////
			///////
			/// Men� de opciones para mostrar
			///////
			//////////
			case 2: System.out.println("Est� mostrando ..."); break;
			
			
			
			
			
			//////////
			///////
			/// Men� de opciones para eliminar
			///////
			//////////
			case 3: System.out.println("Est� eliminando ..."); break;
			case 4: break;
			
			} //cierre del switch - men� principal
		
		
		} while (opcion !=4); // cierre del do - men� principal

	
		
		
		
		
		
		
	Serializador.serializar();
	
	
	
	} // cierre del m�todo main

	
	
	
	
	
	
	
	
	
	
	
}
