package logical;

import java.util.ArrayList;

import sun.util.calendar.BaseCalendar.Date;

public class Lesiones {

	private String equipo;
	private String nombrejugador;
	private Date fechalesion;
	private String tipoLesion;
	private String comentario;
	
	public Lesiones(String equipo, String nombrejugador, Date fechalesion, String tipoLesion, String comentario) {
		super();
		this.equipo = equipo;
		this.nombrejugador = nombrejugador;
		this.fechalesion = fechalesion;
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

	public Date getFechalesion() {
		return fechalesion;
	}

	public void setFechalesion(Date fechalesion) {
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

