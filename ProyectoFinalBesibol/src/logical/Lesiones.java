package logical;

import java.io.Serializable;
import java.util.ArrayList;

import sun.util.calendar.BaseCalendar.Date;

public class Lesiones implements Serializable{

	private String equipo;
	private String nombrejugador;
	private String fechalesion;
	private String tipoLesion;
	private String comentario;
	
	public Lesiones(String equipo, String nombrejugador, String fechalesion2, String tipoLesion, String comentario) {
		super();
		this.equipo = equipo;
		this.nombrejugador = nombrejugador;
		this.fechalesion = fechalesion2;
		this.tipoLesion = tipoLesion;
		this.comentario = comentario;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getNombrejugador() {
		return nombrejugador;
	}

	public void setNombrejugador(String nombrejugador) {
		this.nombrejugador = nombrejugador;
	}

	public String getFechalesion() {
		return fechalesion;
	}

	public void setFechalesion(String fechalesion) {
		this.fechalesion = fechalesion;
	}

	public String getTipoLesion() {
		return tipoLesion;
	}

	public void setTipoLesion(String tipoLesion) {
		this.tipoLesion = tipoLesion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}

