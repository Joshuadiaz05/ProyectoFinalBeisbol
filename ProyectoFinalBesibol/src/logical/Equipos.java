package logical;

import java.io.Serializable;
import java.util.ArrayList;


public class Equipos implements Serializable{

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
	
	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getJj() {
		return jj;
	}

	public void setJj(int jj) {
		this.jj = jj;
	}

	public int getJg() {
		return jg;
	}

	public void setJg(int jg) {
		this.jg = jg;
	}

	public int getJp() {
		return jp;
	}

	public void setJp(int jp) {
		this.jp = jp;
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
	
	public void agregarLesion(String nom, boolean less, boolean titular, Lesiones lesion){
		int i=0; boolean find = false;
		while(i<jugador.size() && find == false){
			if(jugador.get(i).getNombre().equalsIgnoreCase(nom)){
				jugador.get(i).setLesion(less);
				jugador.get(i).setTitular(titular);
				jugador.get(i).setLesiones(lesion);
				find = true;
			}
			i++;
		}
	}
	
	public void quitarLesion(String nom, boolean less, boolean titular, Lesiones lesion){
		int i=0; boolean find = false;
		while(i<jugador.size() && find == false){
			if(jugador.get(i).getNombre().equalsIgnoreCase(nom)){
				jugador.get(i).setLesion(less);
				jugador.get(i).setTitular(titular);
				jugador.get(i).setLesiones(lesion);
				find = true;
			}
			i++;
		}
	}

	public Jugadores buscarJugadorbyposicion(String posicion) {
		Jugadores aux = null;
		boolean find = false;
		int i=0;
		while(i<jugador.size() && find==false){
			if(jugador.get(i).getPosicion().equalsIgnoreCase(posicion) && jugador.get(i).isTitular()==true){
				aux=jugador.get(i);
				find=true;
			}
		   i++;
		}
		return aux;
	}

	public Jugadores buscarJugadorbynombre(String jugador2) {
		Jugadores aux = null;
		boolean find = false;
		int i=0;
		while(i<jugador.size() && find==false){
			if(jugador.get(i).getNombre().equalsIgnoreCase(jugador2)){
				aux=jugador.get(i);
				find=true;
			}
		   i++;
		}
		return aux;
	}
	
	public void eliminarJugador(String nombre){
		Jugadores aux = buscarJugadorbynombre(nombre);
		jugador.remove(aux);
	}
	
	public double promedioBateoEquipo(){
		double promedioTotalJugadores = 0;
		for(Jugadores aux : jugador){
			promedioTotalJugadores += aux.getEstadistica().obtenerPromedioBateo();
		}
		return promedioTotalJugadores = (double)promedioTotalJugadores/jugador.size();	
		
	}
	
	public double porcenajeSLGequipo(){
		double pocentajetotal = 0;
		for(Jugadores aux : jugador){
			pocentajetotal += aux.getEstadistica().obtenerSlugging();
		}
		return pocentajetotal = (double)pocentajetotal/jugador.size();	
		
	}
}
