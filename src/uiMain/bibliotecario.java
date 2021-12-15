package uiMain;

import java.time.LocalDate;
import java.util.ArrayList;
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
		//Inicializadores para algunos atributos
		tipoLibro tipo;
		Autor autor;
		Estanteria estanteria;
		
		// Se eliminan todos los objetos creados para trabajar solamente con los de los archivos almacenados
		//Deserializador.resetarMemoria();
		Deserializador.deserializar();
		
		// Crear autor an�nimo y estanter�a vac�a si no oest�n ya creados
		
		ArrayList<Integer> autores_id = new ArrayList<Integer>();
		for(Autor autor1 : Autor.getAutores()) {autores_id.add(autor1.getId());}
		if (autores_id.contains(0) == false) {new Autor();}
		
		ArrayList<Short> estanterias_numeros = new ArrayList<Short>();
		for(Estanteria estanteria1 : Estanteria.getLista()) {estanterias_numeros.add(estanteria1.getNumero());}
		if (estanterias_numeros.contains((short) 0) == false) {new Estanteria();}
		
		
		  ///////////////////////////
		 /// INICIO DEL SISTEMA ////
		///////////////////////////
		System.out.println("Hola!\nBienvenido al Sistema de Gesti�n de la Biblioteca");
		
		// Men� de opciones principal
		int opcion;
		do {
			
			
			System.out.println("\nMEN� PRINCIPAL: ");
			System.out.println("-------------------------");
			System.out.println(" 1. A�adir Registros");
			System.out.println(" 2. Mostrar registros");
			System.out.println(" 3. Eliminar registros");
			System.out.println(" 4. Funcionalidad A");
			System.out.println(" 5. Funcionalidad B");
			System.out.println(" 6. Funcionalidad C");
			System.out.println(" 7. Funcionalidad D");
			System.out.println(" 8. Funcionalidad E");
			System.out.println(" 9. Guardar datos y salir del sistema");
			System.out.println("-------------------------");
		
			System.out.println("Teclee la opci�n(N): ");
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
				System.out.println(" 5. Volver al men� principal");
				System.out.println("-------------------------");
				
				System.out.println("Teclee la opci�n(N): ");
				opcion = (int) readLong();readLn();
				
				switch(opcion) {
					case 1: System.out.println("Ingrese los datos de la Estanter�a:");
					
					System.out.println("N�mero (N):"); short n = (short) readLong();
					System.out.println("Piso (N):"); short p = (short) readLong();readLn();
					System.out.println("L�mte inferior (S):"); 
					String li = readLn();
					System.out.println("L�mite superior (S):"); 
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
						
						System.out.println("Teclee la opci�n (N): ");
						int opcion3;
						opcion3 = (int) readLong();
						
						switch (opcion3) {
						case 1:
						int opcion2;
						tipo = null;
						do {
						System.out.println("Ingrese los datos del Libro");

						System.out.println("-------------------------");
						System.out.println("Tipo de libro: ");
						System.out.println(" 1. Coleccion General");
						System.out.println(" 2. Reserva");
						System.out.println(" 3. Investigacion");
						System.out.println(" 4. Seminario");
						System.out.println(" 5. Tesis");
						System.out.println(" 6. Volver al Men� de Registro");
						System.out.println("-------------------------");
						System.out.println("Teclee la opci�n (N): ");
						opcion2 = (int) readLong();
						
						switch(opcion2) {
						case 1: tipo = tipoLibro.COLECCION_GENERAL;break;
						case 2: tipo = tipoLibro.RESERVA;break;
						case 3: tipo = tipoLibro.INVESTIGACION;break;
						case 4: tipo = tipoLibro.SEMINARIO;break;
						case 5: tipo = tipoLibro.TESIS;break;
						case 6: break;
						default:; System.out.println("Tipo de libro inv�lido");break;
						}}while(opcion2 !=1 & opcion2 != 2 & opcion2 != 3 & opcion2 != 4 & opcion2 != 5 & opcion2 != 6);
						
						if(opcion2 != 6) {

						System.out.println("C�digo (N):"); int cod = (int) readLong();readLn();
						System.out.println("Nombre (S):"); String nombre2 = readLn();
						System.out.println("A�o: (N)"); short aa = (short) readLong();
						System.out.println("Ejemplar (N):"); short ejemplar = (short) readLong();readLn();
						System.out.println("Referencia (S):"); String ref= readLn();
						System.out.println("Volumen (N):"); short vol = (short) readLong();
						System.out.println("ID del autor (N):"); short nautor = (short) readLong();readLn();
						autor = null;
						for (Autor a: Autor.getAutores()) {
							if (a.getId() == nautor) {autor = a;}
						}
						System.out.println("N�mero de Estanter�a (N):"); short nes = (short) readLong();readLn();
						estanteria = null;
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == nes) {estanteria = e;}
						}
						
						new Libro (cod,nombre2,aa,ejemplar,autor,tipo,ref,vol,estanteria);
			
						 System.out.println("Libro registrado con �xito");
	
						break;}
						
						case 2: System.out.println("Ingrese los datos de la Revista");
						
						// Valores del enumerado Meses en una lista de Strings
						ArrayList<String> list = new ArrayList<String>();
						for (Revista.Meses mes : Revista.Meses.values()) {
							String m = mes.toString();
							list.add(m);}
						readLn();
						System.out.println("Mes en espa�ol y en May�sculas (N):"); String m = readLn();
						if (list.contains(m) == false) {System.out.println("Mes inv�lido");
						System.out.println("De vuelta al Men� de Registro de Datos");break;}
						Revista.Meses mes = Revista.Meses.valueOf(m);
						System.out.println("C�digo (N):"); int cod = (int) readLong();readLn();
						System.out.println("Nombre (S):"); String nombre2 = readLn();
						System.out.println("A�o (N):");short aa = (short) readLong();
						System.out.println("Ejemplar (N):"); short ejemplar = (short) readLong();
						System.out.println("N�mero (N):"); short numero = (short) readLong();readLn();
						System.out.println("Temporada (S):"); String temporada = readLn();
						System.out.println("N�mero de Estanter�a (N):");  short es = (short) readLong();readLn();
						estanteria = null;
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == es) {estanteria = e;}}
						new Revista (cod,nombre2,aa,ejemplar,numero,mes,temporada,estanteria);
						 System.out.println("Revista registrada con �xito");
						break;
						
						case 3: System.out.println("Ingrese los datos del Folleto");
						
						readLn();
						System.out.println("C�digo (N):"); cod = (int) readLong();readLn();
						System.out.println("Nombre (S):"); nombre2 = readLn();
						System.out.println("A�o (N):"); aa = (short) readLong();
						System.out.println("Ejemplar (N):"); ejemplar = (short) readLong();readLn();
						System.out.println("Referencia (S):"); String ref = readLn();
						System.out.println("N�mero de Estanter�a (N):");  short nes = (short) readLong();
						estanteria = null;
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == nes) {estanteria = e;}
							}
						new Folleto (cod,nombre2,aa,ejemplar,ref,estanteria);
						 System.out.println("Folleto registrado con �xito");
						break;
						
						default: 
							System.out.println("Opci�n no v�lida\nDevuelta al Men� de Registro");break;
						} // cierre del switch de registrar publicacion

					break;
					
					case 3: int v;
					boolean vivo = true;
					do {	
					System.out.println("\nIngrese los datos del autor");
					
					System.out.println("�Est� vivo el autor?:");
					System.out.println("-------------------------");
					System.out.println(" 1. Si");
					System.out.println(" 2. No");
					System.out.println(" 3. Volver al Men� de Registro");
					System.out.println("-------------------------");
					System.out.println("Teclee la opci�n (N): ");
					v = (int) readLong();
					switch(v){
					case 1: break;
					case 2: vivo = false; break;
					case 3: break;
					default: 
						System.out.println("Opci�n no v�lida\nIntente otra vez");break;
						}
					} while (v !=1 & v !=2 & v !=3);
					
					if (v !=3) {
					System.out.println("ID (N):"); int id = (int)readLong();readLn();
					System.out.println("Nombre (S):"); String nautor = readLn();
					System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S)"); String nacimiento = readLn();
					System.out.println("Pa�s de Origen (S)"); String pais = readLn();
	
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
						System.out.println("Teclee la opci�n (N): ");
						int opcion4;
						opcion4 = (int) readLong();readLn();
						
						switch (opcion4) {
						case 1: System.out.println("Ingrese los datos del estudiante/profesor");
						
						System.out.println("Nombre (S):"); String nombre = readLn();
						System.out.println("Id (N):"); short id = (short) readLong();readLn();
						System.out.println("Correo (S):"); String correo = readLn();
						System.out.println("Telefono (N):"); short tel = (short) readLong();readLn();
						System.out.println("Direccion (S):"); String direccion = readLn();
						System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S):"); String nac = readLn();
						System.out.println("Pa�s de Origen (S):"); String origen = readLn();
						
						new EstudianteProfesor(nombre,id,correo,tel,direccion, LocalDate.parse(nac), origen);
						System.out.println("Estudiante o Profesor registrado con �xito!");
						
						break;
						
						case 2: System.out.println("Ingrese los datos del usuario externo");
							int u;
							do {
							System.out.println("�Pertenece a alguna Universidad?");
							System.out.println("-------------------------");
							System.out.println(" 1. Si");
							System.out.println(" 2. No");
							System.out.println(" 3. Volver al Men� de Registro");
							System.out.println("-------------------------");
							System.out.println("Teclee la opci�n (N): ");
							u = (int) readLong();readLn();
							switch(u){
							case 1: 
							//CONSTRUCTOR CON UNI
							System.out.println("Universidad (S)"); String uni = readLn();
							System.out.println("Nombre (S):"); String nombre2 =  readLn();
							System.out.println("Id (N):"); short id2 = (short) readLong();readLn();
							System.out.println("Correo (S):"); String correo2 = readLn();
							System.out.println("Telefono (N):"); short tel2 = (short) readLong();readLn();
							System.out.println("Direccion (S):"); String direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S):"); String nac2 = readLn();
							System.out.println("Pa�s de Origen (S):"); String origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2,uni);
							System.out.println("Usuario Externo registrado con �xito!");
							break;

							case 2: 
							// CONTRUCTOR SIN UNI
							System.out.println("Nombre (S):"); nombre2 =  readLn();
							System.out.println("Id (N):"); id2 = (short) readLong();readLn();
							System.out.println("Correo (S):");correo2 = readLn();
							System.out.println("Telefono (N):"); tel2 = (short) readLong();readLn();
							System.out.println("Direccion (S):"); direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S):"); nac2 = readLn();
							System.out.println("Pa�s de Origen (S):"); origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2);
							System.out.println("Usuario Externo registrado con �xito!");
							break;

							case 3: break;
							default: 
							System.out.println("Opci�n no v�lida\nIntente otra vez\n");break;
							} // cierre switch - pertenece uni
							} while (u !=1 & u !=2 & u !=3); // cierre do- pertenece uni
						
						
						case 3: break;

						default:
							System.out.println("Opci�n no v�lida\nDevuelta al Men� de Registro");break;
						} // cierre de switch - casos usuario
						
						
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
			/// Men� de opciones para mostrar
			///////
			//////////
			case 2: System.out.println("Est� mostrando ..."); break;
			
			
			
		      //////////
	            ///////
	                /// 
	            ///////
	         //////////
			
			
			
			
			
			
			
			
			//////////
			///////
			/// Men� de opciones para eliminar
			///////
			//////////
			case 3: System.out.println("Est� eliminando ..."); break;
			
			
		     //////////
               ///////
                   /// 
              ///////
           //////////
			
			
			
			
			
			//////////
			///////
			/// Men� de opciones para A
			///////
			//////////
			case 4: System.out.println("Se est� implementando la Funcionalidad A");break;
			
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			
			
			
			
			//////////
			///////
			/// Men� de opciones para B
			///////
			//////////
			case 5: System.out.println("Se est� implementando la Funcionalidad B");break;
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			
			
			
			
			
			//////////
			///////
			/// Men� de opciones para C
			///////
			//////////
			case 6: System.out.println("Se est� implementando la Funcionalidad C");break;
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			
			
			
			
			
			
			//////////
			///////
			/// Men� de opciones para D
			///////
			//////////
			case 7: System.out.println("Se est� implementando la Funcionalidad D");break;
			
			  //////////
				///////
					/// 
				///////
			//////////
			
			
			
			
			
			
			
			
			
			//////////
			///////
			/// Men� de opciones para E
			///////
			//////////
			case 8: System.out.println("Se est� implementando la Funcionalidad E");break;
			
		     //////////
            ///////
                /// 
           ///////
        //////////
			case 9: break;

			} //cierre del switch - men� principal
		
		
		} while (opcion !=9); // cierre del do - men� principal

	
		
		
	Serializador.serializar();
	} // cierre del m�todo main

	
	
	
	
	
	
	
	
	
	
	
}
