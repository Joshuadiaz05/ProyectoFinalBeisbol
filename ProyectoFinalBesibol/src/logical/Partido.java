package logical;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Partido implements Serializable{

	private String fecha;
	private String equipoCasa;
	private String equipoVisita;
	private String Estadio;
	private String hora;
	private int carrerasCasa=0;
	private int carrerasVisita=0;
	
	public Partido(String fecha, String equipoCasa, String equipoVisita, String estadio, String hora) {
		super();
		this.fecha = fecha;
		this.equipoCasa = equipoCasa;
		this.equipoVisita = equipoVisita;
		Estadio = estadio;
		this.hora = hora;
		carrerasCasa=0;
		carrerasVisita=0;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEquipoCasa() {
		return equipoCasa;
	}
	public void setEquipoCasa(String equipoCasa) {
		this.equipoCasa = equipoCasa;
	}
	public String getEquipoVisita() {
		return equipoVisita;
	}
	public void setEquipoVisita(String equipoVisita) {
		this.equipoVisita = equipoVisita;
	}
	public String getEstadio() {
		return Estadio;
	}
	public void setEstadio(String estadio) {
		Estadio = estadio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getCarrerasCasa() {
		return carrerasCasa;
	}
	public void setCarrerasCasa(int carrerasCasa) {
		this.carrerasCasa = carrerasCasa;
	}
	public int getCarrerasVisita() {
		return carrerasVisita;
	}
	public void setCarrerasVisita(int carrerasVisita) {
		this.carrerasVisita = carrerasVisita;
	}
	
	
}
