package gestorAplicacion.obras;

import java.util.ArrayList;

public class Revista extends Publicacion {
	//ATRIBUTOS DE CLASE
	private static final long serialVersionUID = 1L;
	static public enum Meses { ENERO, FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE,DICIEMBRE};	
	static private ArrayList<Revista>revistas=new ArrayList<Revista>();
	
	//ATRIBUTOS INSTANCIA
	private short numero;
	private Meses mes;
	private String temporada;
	
	//CONSTRUCTORES
	public Revista (int codigo, String nombre, short año, short ejemplar, short numero,Meses mes, String temporada, Estanteria estanteria) {
		super(codigo,nombre,año,ejemplar);
		this.numero=numero;
		this.mes=mes;
		this.temporada=temporada;
		super.estanteria=estanteria;
		revistas.add(this);
		estanteria.getPublicaciones().add(this);
		Publicacion.numeroPublicaciones++;
	}
		
	//METODOS
	public String mostrarInfo() {
		return " INFORMACION DE LA REVISTA " + "\n" + "Nombre: " + this.nombre + "\n" + "Año: " + this.año + "\n" 
				+ "Mes: "+ this.mes + "\n"+ "Temporada: "+ this.temporada + "\n"
				+ "Codigo: " + this.codigo + "\n" + "Ejemplar: " + this.ejemplar + "\n" + "Estado: " + this.estado;
	}

	public String mostrarUbicacion() {
		return "Se localiza en -> " + this.estanteria.motrarInfo();
	}
	
	
	
	//GETTERS Y SETTERS
	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public Meses getMes() {
		return mes;
	}

	public void setMes(Meses mes) {
		this.mes = mes;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public static ArrayList<Revista> getRevistas() {
		return revistas;
	}
	public static void setRevistas(ArrayList<Revista> revistas) {
		Revista.revistas = revistas;
	}
	

}
