package logical;

import java.util.ArrayList;
import java.util.Date;

public class Jugador {
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
	private double piesAltura;
	private double piesAncho;
	private ArrayList<Titulo> miTitulo;

	public Jugador() {
		// TODO Auto-generated constructor stub
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

	public double getPiesAltura() {
		return piesAltura;
	}

	public void setPiesAltura(double piesAltura) {
		this.piesAltura = piesAltura;
	}

	public double getPiesAncho() {
		return piesAncho;
	}

	public void setPiesAncho(double piesAncho) {
		this.piesAncho = piesAncho;
	}

	public ArrayList<Titulo> getMiTitulo() {
		return miTitulo;
	}

	public void setMiTitulo(ArrayList<Titulo> miTitulo) {
		this.miTitulo = miTitulo;
	}
	
	
}
