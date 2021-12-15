package gestorAplicacion.obras;

import java.io.Serializable;

import java.util.ArrayList;

public class Estanteria implements Serializable {
	// ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	public static ArrayList<Estanteria> lista = new ArrayList<>();
	static protected int numeroEstanterias;

	// ATRIBUTOS INSTANCIA
	short numero;
	short piso;
	String[] limites = new String[2];
	private ArrayList<Publicacion> publicaciones= new ArrayList();

	// CONSTRUCTORES
	public Estanteria() {
	}

	public Estanteria(short numero, short piso, String[] limites) {
		this.numero = numero;
		this.piso = piso;
		this.limites = limites;
		numeroEstanterias++;
		lista.add(this);
	}

	// METODOS
	public String motrarInfo() {
		return "Estanteria número " + this.numero + " ubicada en el piso " + this.piso + " de la biblioteca.";
	}
	
	public String getPublicaciones() {
		String c= "";
		for(int i=0;i<this.publicaciones.size();i++) {
			c= c+ this.publicaciones.get(i).nombre+ "/n";
		}
		return c;
	}

	public void setPublicaciones(Publicacion publicaciones) {
		this.publicaciones.add(publicaciones);
	}
	
	
	//GETTERS SETTERS
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

}
