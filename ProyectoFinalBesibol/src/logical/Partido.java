package logical;

import java.util.Date;

public class Partido {

	private Date fecha;
	private String equipoCasa;
	private String equipoVisita;
	private String Estadio;
	private String hora;
	private int carrerasCasa;
	private int carrerasVisita;
	public Partido(Date fecha, String equipoCasa, String equipoVisita, String estadio, String hora, int carrerasCasa,
			int carrerasVisita) {
		super();
		this.fecha = fecha;
		this.equipoCasa = equipoCasa;
		this.equipoVisita = equipoVisita;
		Estadio = estadio;
		this.hora = hora;
		this.carrerasCasa = carrerasCasa;
		this.carrerasVisita = carrerasVisita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
