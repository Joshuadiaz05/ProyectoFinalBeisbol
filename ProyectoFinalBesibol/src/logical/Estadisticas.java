package logical;

import java.io.Serializable;

public class Estadisticas implements Serializable{

	private int jg;
	private int jp;
	private int hits;
	private int dobles;
	private int triples;
	private int homeruns;
	private int basebola;
	private int turnosjugados;
	private int carreraAnotadas;
	private int RBI;
	
	public Estadisticas(int hits, int dobles, int triples, int homeruns, int basebola, int turnosjugados, int carreras, int rbi) {
		super();
		this.jg = 0;
		this.jp = 0;
		this.hits = hits;
		this.dobles = dobles;
		this.triples = triples;
		this.homeruns = homeruns;
		this.basebola = basebola;
		this.turnosjugados = turnosjugados;
		this.carreraAnotadas = carreras;
		this.RBI = rbi;
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

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getDobles() {
		return dobles;
	}

	public void setDobles(int dobles) {
		this.dobles = dobles;
	}
	
	public int getTriples() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}

	public int getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(int homeruns) {
		this.homeruns = homeruns;
	}

	public int getBasebola() {
		return basebola;
	}

	public void setBasebola(int basebola) {
		this.basebola = basebola;
	}

	public int getTurnosjugados() {
		return turnosjugados;
	}

	public void setTurnosjugados(int turnosjugados) {
		this.turnosjugados = turnosjugados;
	}

	public int getCarreraAnotadas() {
		return carreraAnotadas;
	}

	public void setCarreraAnotadas(int carreraAnotadas) {
		this.carreraAnotadas = carreraAnotadas;
	}

	public int getRBI() {
		return RBI;
	}

	public void setRBI(int rBI) {
		RBI = rBI;
	}

	public double obtenerPromedioBateo(){
		double promediobateo = (double)hits/turnosjugados;
		return (double) promediobateo;
	}
	
	public float obtenerSlugging(){
		float slg = ((hits+dobles)+(2*triples)+(3*homeruns))/turnosjugados;
		return slg;
	}
	
	public void masDatos(int turnosJ, int hit){
		this.turnosjugados+=turnosJ;
		this.hits+=hit;
	}
	
	public void juegoGanado(){
		jg++;
	}
	
	public void juegoPerdido(){
		jp++;
	}
	
}
