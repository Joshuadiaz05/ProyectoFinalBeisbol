package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class LigaBeisbol implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Equipos> equipo;
	private ArrayList<Jugadores> jugador;
	private ArrayList<Partido> partido;
	private static LigaBeisbol liga = null;

	public LigaBeisbol() {
		super();
		equipo = new ArrayList<>();
		jugador = new ArrayList<>();
		partido = new ArrayList<>();
	}

	public static LigaBeisbol getInstance() {
		if (liga == null) {
			liga = new LigaBeisbol();
		}
		return liga;
	}

	public static void setLigaBeisbol(LigaBeisbol miBeisbol) {
		LigaBeisbol.liga = miBeisbol;
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

	public void insertarEquipo(Equipos _pEquipo) {
		equipo.add(_pEquipo);
	}

	public void insertarJugador(Jugadores _pJugador) {
		jugador.add(_pJugador);
	}

	public Equipos BuscarPorNombre(String pEquipo) {
		Equipos miEquipo = null;
		boolean find = false;
		int i = 0;
		while (i < equipo.size() && !find) {
			if (equipo.get(i).getNombre().equalsIgnoreCase(pEquipo)) {
				miEquipo = equipo.get(i);
				find = true;
			}
			i++;
		}
		return miEquipo;
	}

	public void insertarPartido(Partido nuevoPartido) {
		partido.add(nuevoPartido);
	}

	public Jugadores buscarjugador(String nombre) {
		Jugadores miJugador = null;
		boolean find = false;
		int i = 0;
		while (i < jugador.size() && !find) {
			if (jugador.get(i).getNombre().equalsIgnoreCase(nombre)) {
				miJugador = jugador.get(i);
				find = true;
			}
			i++;
		}
		return miJugador;
	}

	public void eliminarEquipo(Equipos miEquipo) {
		equipo.remove(miEquipo);
	}

	public Partido buscarPartido(String local, String visita, Date fecha) {
		Partido miPartido = null;
		boolean find = false;
		int i = 0;
		while (i < partido.size() && !find) {
			if (partido.get(i).getEquipoCasa().equalsIgnoreCase(local)
					&& partido.get(i).getEquipoVisita().equalsIgnoreCase(visita)
					&& partido.get(i).getFecha().equals(fecha)) {
				miPartido = partido.get(i);
				find = true;
			}
			i++;
		}
		return miPartido;
	}
	
	public boolean buscarPartidoBoolean(String local, String visita, Date fecha) {
		Partido miPartido = null;
		boolean find = false;
		int i = 0;
		while (i < partido.size() && !find) {
			if (partido.get(i).getEquipoCasa().equalsIgnoreCase(local)
					&& partido.get(i).getEquipoVisita().equalsIgnoreCase(visita)
					&& partido.get(i).getFecha().equals(fecha)) {
				find = true;
			}
			i++;
		}
		return find;
	}
	
	public void modificarEquipo(Equipos equip){
		int i = 0, pos = 0;
		boolean find = false;
		while(i<equipo.size() && find==false){
			if(equipo.get(i)==equip){
				pos=i;
				find=true;
			}
			i++;
		}
		equipo.set(pos, equip);
	}

	// ARCHIVOS
	public void cargarArchivo(LigaBeisbol beisbol) {
		try {
			FileInputStream f = new FileInputStream("Archivo.dat");
			ObjectInputStream ob = new ObjectInputStream(f);
			LigaBeisbol beisb = (LigaBeisbol) ob.readObject();
			LigaBeisbol.setLigaBeisbol(beisb);
			ob.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void guardarArchivo(LigaBeisbol beisbol) {
		File f = new File("Archivo.dat");
		FileOutputStream file = null;
		ObjectOutputStream ob = null;
		try {
			file = new FileOutputStream(f);
			ob = new ObjectOutputStream(file);
			ob.writeObject(beisbol);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ob != null) {
					ob.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
