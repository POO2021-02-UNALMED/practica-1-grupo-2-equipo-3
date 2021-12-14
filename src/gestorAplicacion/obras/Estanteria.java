package gestorAplicacion.obras;

import java.util.ArrayList;

public class Estanteria {
	//ATRIBUTOS DE CLASE
	private static ArrayList<Estanteria> lista = new ArrayList<>();
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
		 lista.add(this);
	 }

	public static ArrayList<Estanteria> getLista() {
		return lista;
	}

	public static void setLista(ArrayList<Estanteria> lista) {
		Estanteria.lista = lista;
	}

	public static int getNumeroEstanterias() {
		return numeroEstanterias;
	}

	public static void setNumeroEstanterias(int numeroEstanterias) {
		Estanteria.numeroEstanterias = numeroEstanterias;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public short getPiso() {
		return piso;
	}

	public void setPiso(short piso) {
		this.piso = piso;
	}

	public String[] getLimites() {
		return limites;
	}

	public void setLimites(String[] limites) {
		this.limites = limites;
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	 
	 
	 

}
