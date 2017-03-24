package logical;

import java.util.ArrayList;

public class LigaBeisbol {

	private ArrayList<Equipos> equipo;
	private ArrayList<Jugadores> jugador;
	private ArrayList<Partido> partido;
	private static LigaBeisbol cadena = null;
	
	public LigaBeisbol() {
		super();
		equipo = new ArrayList<>();
		jugador = new ArrayList<>();
		partido = new ArrayList<>();
	}
	
	public static LigaBeisbol getInstance() {
		if (cadena == null) {
			cadena = new LigaBeisbol();
		}
		return cadena;
	}
	
	public ArrayList<Equipos> getEquipo() {
		return equipo;
	}
	public void setEquipo(ArrayList<Equipos> equipo) {
		this.equipo = equipo;
	}
	public ArrayList<Jugadores> getJugador() {
		return jugador;
	}
	public void setJugador(ArrayList<Jugadores> jugador) {
		this.jugador = jugador;
	}
	public ArrayList<Partido> getPartido() {
		return partido;
	}
	public void setPartido(ArrayList<Partido> partido) {
		this.partido = partido;
	}
	
	public void insertarEquipo(Equipos _pEquipo){
		equipo.add(_pEquipo);
	}
	
	public void insertarJugador(Jugadores _pJugador){
		jugador.add(_pJugador);
	}
	
	public Equipos BuscarPorNombre(String pEquipo){
		Equipos miEquipo = null;
		boolean find = false;
		int i = 0;
		while(i < equipo.size() && !find){
			if(equipo.get(i).getNombre().equalsIgnoreCase(pEquipo)){
				miEquipo = equipo.get(i);
				find = true;
			}
			i++;
		}
		return miEquipo;
	}
}
