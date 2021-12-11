package gestorAplicacion.obras;

import java.util.ArrayList;

public class Revista extends Publicacion {
	//ATRIBUTOS DE CLASE
	static private enum Meses { ENERO, FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE,DICIEMBRE};	
	static public ArrayList<Revista>revistas= new ArrayList();
	
	//ATRIBUTOS INSTANCIA
	private short numero;
	private Meses mes;
	private String temporada;
	
	//CONSTRUCTORES
	public Revista () {
		Publicacion.numeroPublicaciones++;
	}
	public Revista (long codigo, String nombre, short año, short ejemplar,  Estados estado, short numero,Meses mes, String temporada) {
		super(codigo,nombre,año,ejemplar,estado);
		this.numero=numero;
		this.mes=mes;
		this.temporada=temporada;
		revistas.add(this);
		Publicacion.numeroPublicaciones++;
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
	

}
