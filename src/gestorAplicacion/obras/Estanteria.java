package gestorAplicacion.obras;

import java.util.ArrayList;

public class Estanteria {
	//ATRIBUTOS DE CLASE
	public static ArrayList<Estanteria> lista = new ArrayList<>();
	 static protected int numeroEstanterias;
	 
	//ATRIBUTOS INSTANCIA
	 short numero;
	 short piso;
	 String[] limites= new String[2];
	 private ArrayList<Publicacion> publicaciones;
	 
	//CONSTRUCTORES
	 Estanteria(short numero, short piso, String[] limites,ArrayList<Publicacion> publicaciones){
		 this.numero=numero;
		 this.piso=piso;
		 this.limites=limites;
		 this.publicaciones=publicaciones;
		 numeroEstanterias++;
	 }
	 
	 
	 

}
