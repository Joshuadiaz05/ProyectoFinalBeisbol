package logical;

import java.util.ArrayList;


public class Equipos {

	private String nombre;
	private String agnocreacion;
	private String manager;
	private String region;
	private int victorias;
	private int derrotas;
	private String estadio;
	private ArrayList<Jugadores> jugador;
	private int jj;
	private int jg;
	private int jp;
	
	public Equipos(String nombre, String agnocreacion, String manager, String region, String estadio) {
		super();
		this.nombre = nombre;
		this.agnocreacion = agnocreacion;
		this.manager = manager;
		this.region = region;
		this.estadio = estadio;
		jugador = new ArrayList<>();
		jj=0;
		jg=0;
		jp=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAgnocreacion() {
		return agnocreacion;
	}

	public void setAgnocreacion(String agnocreacion) {
		this.agnocreacion = agnocreacion;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public ArrayList<Jugadores> getJugador() {
		return jugador;
	}

	public void setJugador(ArrayList<Jugadores> jugador) {
		this.jugador = jugador;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public String toString(){
		return nombre;
	}
	
	public void agregarjugador(Jugadores nuevojugador){
		jugador.add(nuevojugador);
	}
	
	public void JuegosGanados(){
		jj++;
		jg++;
	}
	
	public void JuegosPerdidos(){
		jj++;
		jp++;
	}
}
