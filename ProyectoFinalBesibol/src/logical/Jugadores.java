package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Jugadores implements Serializable{
	private int numero;
	private String nombre;
	private String apellido;
	private double peso;
	private String posicion;
	private double altura;
	private boolean lesion;
	private Date fechanacimiento;
	private String lugarciudadNacimiento;
	private String lugarpaisNacimiento;
	private String universidad;
	private String equipo;
	private boolean titular;
	private ArrayList<Estadisticas> estadistica;
	
	public Jugadores(int numero, String nombre, String apellido, double peso, String posicion, double altura,
			Date fechanacimiento, String lugarciudadNacimiento, String lugarpaisNacimiento,
			String universidad, String equipo) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.apellido = apellido;
		this.peso = peso;
		this.posicion = posicion;
		this.altura = altura;
		lesion = false;
		titular = false;
		this.fechanacimiento = fechanacimiento;
		this.lugarciudadNacimiento = lugarciudadNacimiento;
		this.lugarpaisNacimiento = lugarpaisNacimiento;
		this.universidad = universidad;
		this.equipo = equipo;
		estadistica = new ArrayList<Estadisticas>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public boolean isLesion() {
		return lesion;
	}

	public void setLesion(boolean lesion) {
		this.lesion = lesion;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getLugarciudadNacimiento() {
		return lugarciudadNacimiento;
	}

	public void setLugarciudadNacimiento(String lugarciudadNacimiento) {
		this.lugarciudadNacimiento = lugarciudadNacimiento;
	}

	public String getLugarpaisNacimiento() {
		return lugarpaisNacimiento;
	}

	public void setLugarpaisNacimiento(String lugarpaisNacimiento) {
		this.lugarpaisNacimiento = lugarpaisNacimiento;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public ArrayList<Estadisticas> getEstadistica() {
		return estadistica;
	}

	public void setEstadistica(ArrayList<Estadisticas> estadistica) {
		this.estadistica = estadistica;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}
	
}
