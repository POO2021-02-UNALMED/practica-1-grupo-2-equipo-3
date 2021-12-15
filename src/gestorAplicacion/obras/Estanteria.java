package gestorAplicacion.obras;

import java.io.Serializable;

import java.util.ArrayList;

public class Estanteria implements Serializable {
	
	// ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	public static ArrayList<Estanteria> lista = new ArrayList<Estanteria>();
	static protected int numeroEstanterias;

	// ATRIBUTOS INSTANCIA
	short numero;
	short piso;
	String[] limites = new String[2];
	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

	// CONSTRUCTORES

	public Estanteria(short numero, short piso, String[] limites) {
		
		this.numero = numero;
		this.piso = piso;
		this.limites = limites;
		numeroEstanterias++;
		Estanteria.lista.add(this);
	}

	// METODOS
	public static void eliminarEstanteria(Estanteria e) { // elimina un registro de Estanteria
		lista.remove(lista.indexOf(e));
	}
	public String mostrarInfo() { //muestra informacion general de la estanteria
		return "Estanteria número " + this.numero + " con limites ["+ this.limites[0]+","+this.limites[1] +"] ubicada en el piso " + this.piso + " de la biblioteca.";
	}
	public String mostrarContenido() { // muestra las publicaciones que hay en la estanteria
		String c = "";
		for (int i = 0; i < this.publicaciones.size(); i++) {
			c = c + this.publicaciones.get(i).nombre + "  Codigo "+ this.publicaciones.get(i).codigo+ "\n";
		}
		if (this.publicaciones.isEmpty()) {
			c= "Estanteria vacia";

		} else {
			if (this.publicaciones.get(0) instanceof Libro) {
				c = "La Estanteria contiene los siguientes libros: " + "\n" + c;
			} else if (this.publicaciones.get(0) instanceof Revista) {
				c = "La Estanteria contiene las siguientes revistas: " + "\n" + c;
			} else if (this.publicaciones.get(0) instanceof Folleto) {
				c = "La Estanteria contiene los siguientes folletos: " + "\n" + c;
			}
		}
		return c;
	}
	
	public void agregarPublicacion(Publicacion publicaciones) {
		this.publicaciones.add(publicaciones);
	}

	// GETTERS SETTERS
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
