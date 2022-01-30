package gestorAplicacion.obras; //Paquete Obras que almacena las clases representativas a las publicaciones o tipo de materiales, ademas las estanterias

//librerias 
import java.io.Serializable;
import java.util.ArrayList;

public class Estanteria implements Serializable { //Clase estanteria que representa las estanterias fisicas de la biblioteca donde se almacenan las publicaciones
	
	// ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L; //Serial
	private static ArrayList<Estanteria> lista = new ArrayList<Estanteria>(); //Lista dinamica donde se almacenan todas las estanterias creadaas
	static private int numeroEstanterias; //contador del total de estanterias creadas

	// ATRIBUTOS INSTANCIA
	short numero; //
	short piso;
	String[] limites = new String[2];
	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

	// CONSTRUCTORES
	public Estanteria() {
		this.numero = 0;
		lista.add(this);
	}
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
	public static String mostrarRegistros() {
		String c="Estanterias creadas: "+"\n";
		for (int i = 0; i < lista.size(); i++) {
			c = c + i+"."+"Estanteria (CP)#"+ lista.get(i).numero + "  Piso # "+ lista.get(i).piso+ "\n";
		}
		return c;
	}
	
	public String mostrarInfo() { //muestra informacion general de la estanteria
		return "INFORMACION DE ESTANTERIA" + "\n"+ "Numero: " + this.numero +"\n"+ "Limites : ["+ this.limites[0]+","+this.limites[1] +"]" +"\n"+"Piso: " + this.piso ;
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
