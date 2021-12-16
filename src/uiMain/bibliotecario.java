package uiMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import baseDatos.*; 
import gestorAplicacion.obras.*;
import gestorAplicacion.obras.Libro.tipoLibro;
import gestorAplicacion.personas.*;
import gestorAplicacion.personas.EstudianteProfesor.Rol;


public class bibliotecario {
	static Scanner sc = new Scanner(System.in);
	static long readLong() {return sc.nextLong();}
	static String readLn() {return sc.nextLine();}
	
	public static void main(String[] args) {
		//Inicializadores para algunos atributos
		tipoLibro tipo;
		Autor autor = null;
		Estanteria estanteria;
		
		// Se eliminan todos los objetos creados para trabajar solamente con los de los archivos almacenados
		//Deserializador.resetarMemoria();
		Deserializador.deserializar();
		
		// Crear autor anónimo y estantería vacía si no oestán ya creados
		
		ArrayList<Integer> autores_id = new ArrayList<Integer>();
		for(Autor autor1 : Autor.getAutores()) {autores_id.add(autor1.getId());}
		if (autores_id.contains(0) == false) {new Autor();}
		
		ArrayList<Short> estanterias_numeros = new ArrayList<Short>();
		for(Estanteria estanteria1 : Estanteria.getLista()) {estanterias_numeros.add(estanteria1.getNumero());}
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
			System.out.println(" 4. Realizar Préstamos");
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
				System.out.println(" 3. Usuario");
				System.out.println(" 4. Volver al menú principal");
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
						
						System.out.println("Teclee la opción (N): ");
						int opcion3;
						opcion3 = (int) readLong();
						
						switch (opcion3) {
						
						// Registro de libro
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
						System.out.println("-------------------------");
						System.out.println("Teclee la opción (N): ");
						opcion2 = (int) readLong();
						
						switch(opcion2) {
						case 1: tipo = tipoLibro.COLECCION_GENERAL;break;
						case 2: tipo = tipoLibro.RESERVA;break;
						case 3: tipo = tipoLibro.INVESTIGACION;break;
						case 4: tipo = tipoLibro.SEMINARIO;break;
						case 5: tipo = tipoLibro.TESIS;break;
						case 6: break;
						default:; System.out.println("Tipo de libro inválido");break;
						}}while(opcion2 !=1 & opcion2 != 2 & opcion2 != 3 & opcion2 != 4 & opcion2 != 5);

						System.out.println("Código (N):"); int cod = (int) readLong();readLn();
						System.out.println("Nombre (S):"); String nombre2 = readLn();
						System.out.println("Año: (N)"); short aa = (short) readLong();
						System.out.println("Ejemplar (N):"); short ejemplar = (short) readLong();readLn();
						System.out.println("Referencia (S):"); String ref= readLn();
						System.out.println("Volumen (N):"); short vol = (short) readLong();
						
						ArrayList<Integer> id_autores = new ArrayList<Integer>();
						//Almaceno una lista con todos los id de autores
						for(Autor autor1: Autor.getAutores()) {id_autores.add(autor1.getId());}
						int idautor;
						boolean puedo_salir;
						boolean vivo = true;
						int asignar_autor_existente = 0;
						do {
						System.out.println("ID del autor (N):"); idautor = (int) readLong();readLn();
						puedo_salir = true;
						//Comprobación si autor ya está registrado
						Autor autor2 = null; // autor que tiene el mismo id que el digitado
						if(id_autores.contains(idautor)) {
							puedo_salir = false;
							System.out.println("Ya existe un autor con este código");
							//Buscamos quien es el autor con ese código
							for(Autor autor1 : Autor.getAutores()) {
								if(autor1.getId() == idautor)  {
									autor2 = autor1;
								}
							}
							// Información del autor que encontramos
							System.out.println(autor2.infoPersonal());
							do {
							System.out.println("¿Desea asignar este autor al libro que está registrando?");
							System.out.println("-------------------------");
							System.out.println(" 1. Si");
							System.out.println(" 2. No");
							System.out.println("-------------------------");
							System.out.println("Teclee la opción (N): ");
							asignar_autor_existente = (int) readLong();readLn();
							
							switch(asignar_autor_existente){
							case 1:autor = autor2;break;//Asignacion de autor existente
							case 2: System.out.println("Ingrese un código diferente");
							default: System.out.println("Opción no válida\nIntente otra vez");
							}
							}while(asignar_autor_existente != 1 & asignar_autor_existente != 2);

							}
						}while(asignar_autor_existente == 2 & puedo_salir == false);
		
						int v = 0;
						if (asignar_autor_existente != 1) {
						//CREacion de un autor         -----------------------------------
						vivo = true;
						do {	
							System.out.println("\nIngrese los datos del autor");	
							System.out.println("¿Está vivo el autor?:");
							System.out.println("-------------------------");
							System.out.println(" 1. Si");
							System.out.println(" 2. No");
							System.out.println(" 3. Volver al Menú de Registro");
							System.out.println("-------------------------");
							System.out.println("Teclee la opción (N): ");
							v = (int) readLong();readLn();
							
							// Se asigna a la variable vivo un booleano
							switch(v){
							case 1: break;
							case 2: vivo = false; break;
							case 3: break;
							default: System.out.println("Opción no válida\nIntente otra vez");break;
							}
							
							} while (v !=1 & v !=2 & v !=3);
						}
						
						if(v != 3 & asignar_autor_existente != 1) {
							
							System.out.println("Nombre (S):"); String nautor = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S)"); String nacimiento = readLn();
							System.out.println("País de Origen (S)"); String pais = readLn();
			
							new Autor (idautor, nautor,LocalDate.parse(nacimiento), pais,vivo);
							 
							 System.out.println("Autor registrado con éxito");
						//Fin creacion de un autor          -----------------------------------
						
						
						
						}
						//Inicio de instrucciones sin autor
						
						
						if(v != 3) {
							System.out.println("Número de Estantería (N):"); short nes = (short) readLong();readLn();
							estanteria = null;
							for (Estanteria e: Estanteria.getLista()) {
								if (e.getNumero() == nes) {estanteria = e;}
							}
							
							new Libro (cod,nombre2,aa,ejemplar,autor,tipo,ref,vol,estanteria);
				
							 System.out.println("Libro registrado con éxito");
							
							
							} // hasta aqui se salta a menu de registro desde vivo autor
						
						break; // cierre de creacion de libro
						
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
						System.out.println("Código (N):"); int cod2 = (int) readLong();readLn();
						System.out.println("Nombre (S):"); String nombre3 = readLn();
						System.out.println("Año (N):");short aa4 = (short) readLong();
						System.out.println("Ejemplar (N):"); short ejemplar1 = (short) readLong();
						System.out.println("Número (N):"); short numero = (short) readLong();readLn();
						System.out.println("Temporada (S):"); String temporada = readLn();
						System.out.println("Número de Estantería (N):");  short es = (short) readLong();readLn();
						estanteria = null;
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == es) {estanteria = e;}}
						new Revista (cod2,nombre3,aa4,ejemplar1,numero,mes,temporada,estanteria);
						 System.out.println("Revista registrada con éxito");
						break;
						
						case 3: System.out.println("Ingrese los datos del Folleto");
						
						readLn();
						System.out.println("Código (N):"); cod = (int) readLong();readLn();
						System.out.println("Nombre (S):"); nombre2 = readLn();
						System.out.println("Año (N):"); aa = (short) readLong();
						System.out.println("Ejemplar (N):"); ejemplar = (short) readLong();readLn();
						System.out.println("Referencia (S):"); String ref2 = readLn();
						System.out.println("Número de Estantería (N):");  short nes = (short) readLong();
						estanteria = null;
						for (Estanteria e: Estanteria.getLista()) {
							if (e.getNumero() == nes) {estanteria = e;}
							}
						new Folleto (cod,nombre2,aa,ejemplar,ref2,estanteria);
						 System.out.println("Folleto registrado con éxito");
						break;
						
						default: 
							System.out.println("Opción no válida\nDevuelta al Menú de Registro");break;
						} // cierre del switch de registrar publicacion

					break;
					
					
					case 3: // Menú de opciones para usuario
						System.out.println("-------------------------");
						System.out.println("Tipo de usuario: ");
						System.out.println(" 1. Estudiante/profesor");
						System.out.println(" 2. Externo");
						System.out.println(" 3. Volver al Menú de Registro");
						System.out.println("-------------------------");
						System.out.println("Teclee la opción (N): ");
						int opcion4;
						opcion4 = (int) readLong();readLn();
						
						switch (opcion4) {
						case 1:
						
						int opcion_rol;
						Rol rol = null;					
						do {
						System.out.println("Ingrese los datos del estudiante/profesor");

						System.out.println("-------------------------");
						System.out.println("Rol: ");
						System.out.println(" 1. Estudiante");
						System.out.println(" 2. Profesor");
						System.out.println(" 3. Otro");
						System.out.println(" 4. Volver al Menú de Registro");
						System.out.println("-------------------------");
						System.out.println("Teclee la opción (N): ");
						opcion_rol = (int) readLong();readLn();
						
						switch(opcion_rol) {
						case 1: rol = Rol.ESTUDIANTE;break;
						case 2: rol = Rol.PROFESOR;break;
						case 3: rol = Rol.OTRO;break;
						case 4: break;
						default:; System.out.println("Tipo de libro inválido");break;
						}}while(opcion_rol !=1 & opcion_rol != 2 & opcion_rol != 3 & opcion_rol != 4);
						
						
						if (opcion_rol !=4) {
						System.out.println("Nombre (S):"); String nombre = readLn();
						System.out.println("Id (N):"); int id = (int) readLong();readLn();
						System.out.println("Correo (S):"); String correo = readLn();
						System.out.println("Telefono (N):"); int tel = (int) readLong();readLn();
						System.out.println("Direccion (S):"); String direccion = readLn();
						System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S):"); String nac = readLn();
						System.out.println("País de Origen (S):"); String origen = readLn();
						
						new EstudianteProfesor(nombre,id,rol,correo,tel,direccion, LocalDate.parse(nac), origen);
						System.out.println("Estudiante o Profesor registrado con éxito!");
						}
						break;
						
						case 2: System.out.println("Ingrese los datos del usuario externo");
							int u;
							do {
							System.out.println("¿Pertenece a alguna Universidad?");
							System.out.println("-------------------------");
							System.out.println(" 1. Si");
							System.out.println(" 2. No");
							System.out.println(" 3. Volver al Menú de Registro");
							System.out.println("-------------------------");
							System.out.println("Teclee la opción (N): ");
							u = (int) readLong();readLn();
							switch(u){
							case 1: 
							//CONSTRUCTOR CON UNI
							System.out.println("Universidad (S)"); String uni = readLn();
							System.out.println("Nombre (S):"); String nombre2 =  readLn();
							System.out.println("Id (N):"); int id2 = (int) readLong();readLn();
							System.out.println("Correo (S):"); String correo2 = readLn();
							System.out.println("Telefono (N):"); int tel2 = (int) readLong();readLn();
							System.out.println("Direccion (S):"); String direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S):"); String nac2 = readLn();
							System.out.println("País de Origen (S):"); String origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2,uni);
							System.out.println("Usuario Externo registrado con éxito!");
							break;

							case 2: 
							// CONTRUCTOR SIN UNI
							System.out.println("Nombre (S):"); nombre2 =  readLn();
							System.out.println("Id (N):"); id2 = (int) readLong();readLn();
							System.out.println("Correo (S):");correo2 = readLn();
							System.out.println("Telefono (N):"); tel2 = (int) readLong();readLn();
							System.out.println("Direccion (S):"); direccion2 = readLn();
							System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S):"); nac2 = readLn();
							System.out.println("País de Origen (S):"); origen2 = readLn();
							
							new Externo(nombre2,id2,correo2,tel2,direccion2, LocalDate.parse(nac2), origen2);
							System.out.println("Usuario Externo registrado con éxito!");
							break;

							case 3: break;
							default: 
							System.out.println("Opción no válida\nIntente otra vez\n");break;
							} // cierre switch - pertenece uni
							} while (u !=1 & u !=2 & u !=3); // cierre do- pertenece uni
						
						
						case 3: break;

						default:
							System.out.println("Opción no válida\nDevuelta al Menú de Registro");break;
						} // cierre de switch - casos usuario
						
						
					break;
					
					
	
					case 4: break;
				} // cierre switch - registro de datos
			} while (opcion !=4);
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
			case 2:do { 
			System.out.println("\nMUESTRA DE DATOS");
			System.out.println("¿A cuáles registros desea acceder?");
			System.out.println("-------------------------");
			System.out.println("Menú de opciones: ");
			System.out.println(" 1. Estanterías");
			System.out.println(" 2. Publicaciones");
			System.out.println(" 3. Personas");
			System.out.println(" 4. Volver al menú principal");
			System.out.println("-------------------------");
			System.out.println("Teclee la opción(N): ");
			opcion = (int) readLong();readLn();
			
			
			switch(opcion) {
			case 1: System.out.println(Estanteria.mostrarRegistros()); break;
			case 2: System.out.println(Publicacion.mostrarRegistros()); break;
			case 3: System.out.println(Persona.mostrarRegistros()); break;
			case 4: break;
			default: System.out.println("\nOpción no válida\nIntente otra vez");
			}}while (opcion != 1 & opcion != 2 & opcion != 3 & opcion != 4);
			
			break;
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
			case 3: do { 
				System.out.println("\nBORRADO DE DATOS");
				System.out.println("¿Qué tipo de dato desea eliminar?");
				System.out.println("-------------------------");
				System.out.println("Menú de opciones: ");
				System.out.println(" 1. Estanterías");
				System.out.println(" 2. Publicaciones");
				System.out.println(" 3. Personas");
				System.out.println(" 4. Volver al menú principal");
				System.out.println("-------------------------");
				System.out.println("Teclee la opción(N): ");
				opcion = (int) readLong();readLn();
				
				
				switch(opcion) {
				case 1:do {
					System.out.println("\nBORRADO DE ESTANTERIAS");
					System.out.println("-------------------------");
					System.out.println("Menú de opciones: ");
					System.out.println(" 1. Mostrar registros");
					System.out.println(" 2. Tengo el número de la estanteria");
					System.out.println(" 3. Volver al menú principal");
					System.out.println("-------------------------");
					System.out.println("Teclee la opción (N): ");
					opcion = (int) readLong();readLn();
					switch (opcion){
					case 1: System.out.println(Estanteria.mostrarRegistros()); break;
					case 2: 
						System.out.println("Ingrese el número de la estanteria (N):");
						int registro_es = (int) readLong();readLn();
						for (Estanteria es : Estanteria.getLista()) {
							if (es.getNumero() == registro_es) {Estanteria.eliminarEstanteria(es);
							System.out.println("Estantería Eliminada !!");}
						} break;
						
					case 3: break;
					}}while (opcion != 2 & opcion != 3);
					
					break;
					
				case 2: do {
					System.out.println("\nBORRADO DE PUBLICACIONES");
					System.out.println("-------------------------");
					System.out.println("Menú de opciones: ");
					System.out.println(" 1. Mostrar registros");
					System.out.println(" 2. Tengo el codigo de la publicacion");
					System.out.println(" 3. Volver al menú principal");
					System.out.println("-------------------------");
					System.out.println("Teclee la opción (N): ");
					opcion = (int) readLong();readLn();
					switch (opcion){
					case 1: System.out.println(Publicacion.mostrarRegistros()); break;
					case 2: 
						System.out.println("Ingrese el codigo de la publicacion (N):");
						int registro_publi = (int) readLong();readLn();
						for (Publicacion publi : Publicacion.getLista()) {
							if (publi.getCodigo() == registro_publi) {Publicacion.eliminarPublicacion(publi);
							System.out.println("Publicación Eliminada !!");}
						} break;
						
					case 3: break;
					}}while (opcion != 2 & opcion != 3);

					break;
					
				case 3: do {
					System.out.println("\nBORRADO DE PERSONAS");
					System.out.println("-------------------------");
					System.out.println("Menú de opciones: ");
					System.out.println(" 1. Mostrar registros");
					System.out.println(" 2. Tengo el ID de la persona");
					System.out.println(" 3. Volver al menú principal");
					System.out.println("-------------------------");
					System.out.println("Teclee la opción (N): ");
					opcion = (int) readLong();readLn();
					switch (opcion){
					case 1: System.out.println(Persona.mostrarRegistros()); break;
					case 2: 
						System.out.println("Ingrese el ID de la persona (N):");
						int registro_per = (int) readLong();readLn();
						for (Persona per : Persona.getLista()) {
							if (per.getId() == registro_per) {Persona.eliminarPersona(per);
							System.out.println("Persona Eliminada !!");}
						} break;
						
					case 3: break;
					}}while (opcion != 2 & opcion != 3);
					
					break;
					
				case 4: break;
				default: System.out.println("\nOpción no válida\nIntente otra vez");
				}}while (opcion != 1 & opcion != 2 & opcion != 3 & opcion != 4);
			
			break;
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
			case 4: 
				
				
				//LocalDate.parse(nacimiento)
				//System.out.println("Fecha de nacimiento en formato AAAA-MM-DD (S):"); String nac = readLn();
				int nprestamos;
				do {
				System.out.println("MENÚ DE PRESTAMOS");
				System.out.println("-------------------------");
				System.out.println("¿Qué tipo de usuario realizará el préstamo?: ");
				System.out.println(" 1. De la comunidad Univesitaria");
				System.out.println(" 2. Externo");
				System.out.println(" 3. Volver al menú principal");
				System.out.println("-------------------------");
				System.out.println("Teclee la opción (N): ");
				opcion = (int) readLong();
				
				System.out.println("¿Cuántos préstamos desea realizar?");
				nprestamos = (int) readLong();readLn();
				
				
			
				int codigo;
				int idprestamo;
				String fecha;
				int idusuario;
				EstudianteProfesor interno = null;
				Externo externo = null;
				switch (opcion){
				
				case 1:  
					System.out.println("ID del usuario que desea prestar (N)");idusuario =(int) readLong();readLn();
					for(EstudianteProfesor inter: EstudianteProfesor.getEstudiantesyprofesores()) {
						if (inter.getId() == idusuario) {interno = inter;}
					}
					
					
					for (int i =0 ; i < nprestamos; i++) {
						Publicacion pp = null; // Publicación a prestar
						System.out.println("Prestamo"+(i+1));
						System.out.println("Código de a publicación (N):"); codigo =(int) readLong();readLn();
						System.out.println("ID del préstamo (N):"); idprestamo =(int) readLong();readLn();
						System.out.println("Fecha en formato AAAA-MM-DD (S):"); fecha = readLn();
						
						
						for (Publicacion ppp : Publicacion.getLista()) {
							if (ppp.getCodigo() == codigo) {pp = ppp;}
						}
						// Se ejecuta el método
						interno.prestar(pp, idprestamo, LocalDate.parse(fecha));
						
					}// Para el numero de prestamos que se quieran

					
					break;
				
				case 2:  
					System.out.println("ID del usuario que desea prestar (N)");idusuario =(int) readLong();readLn();
					for(Externo exter: Externo.getUsuariosExternos()) {
						if (exter.getId() == idusuario) {externo = exter;}
					}
					
					
					for (int i =0 ; i < nprestamos; i++) {
						Publicacion pp = null; // Publicación a prestar
						System.out.println("Prestamo"+(i+1));
						System.out.println("Código de a publicación (N):"); codigo =(int) readLong();readLn();
						System.out.println("ID del préstamo (N):"); idprestamo =(int) readLong();readLn();
						System.out.println("Fecha en formato AAAA-MM-DD (S):"); fecha = readLn();
						
						
						for (Publicacion ppp : Publicacion.getLista()) {
							if (ppp.getCodigo() == codigo) {pp = ppp;}
						}
						// Se ejecuta el método
						externo.prestar(pp, idprestamo, LocalDate.parse(fecha));
						
					}// Para el numero de prestamos que se quieran

					
					break;
					
				default: break;
				}
				}while (nprestamos != 1 & nprestamos != 2 & nprestamos !=3);
				
				break;
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

	
	
	
	
	
	
	
	
	
	
	
} // cierre de la clase bibliotecario 
