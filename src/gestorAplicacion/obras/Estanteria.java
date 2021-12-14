package gestorAplicacion.obras;

import java.util.ArrayList;

class Estanteria {
	//ATRIBUTOS DE CLASE
	 static protected int numeroEstanterias;
	 
	//ATRIBUTOS INSTANCIA
	 short numero;
	 short piso;
	 String[] limites= new String[2];
	 private ArrayList<Revista> publicaciones= new ArrayList();
	 
	//CONSTRUCTORES
	 Estanteria(short numero, short piso, String[] limites,ArrayList<Revista> publicaciones){
		 this.numero=numero;
		 this.piso=piso;
		 this.limites=limites;
		 this.publicaciones=publicaciones;
		 numeroEstanterias++;
	 }
	 
	 
	 

}
