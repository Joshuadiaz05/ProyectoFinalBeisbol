package logical;

import java.util.ArrayList;

public class LigaBeisbol {

	private ArrayList<Equipos> equipo;
	private ArrayList<Jugadores> jugador;
	private ArrayList<Partido> partido;
	
	public LigaBeisbol(ArrayList<Equipos> equipo, ArrayList<Jugadores> jugador, ArrayList<Partido> partido) {
		super();
		this.equipo = equipo;
		this.jugador = jugador;
		this.partido = partido;
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

}
