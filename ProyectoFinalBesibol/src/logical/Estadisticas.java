package logical;

public class Estadisticas {

	private int jj;
	private int jg;
	private int jp;
	private int hits;
	private int dobles;
	private int triples;
	private int homeruns;
	private int basebola;
	private int turnosjugados;
	private int deball;
	private int errores;
	private int carreraAnotadas;
	
	public Estadisticas(int jj, int jg, int jp, int hits, int dobles, int triples, int homeruns, int basebola, int turnosjugados, int carreras) {
		super();
		this.jj = jj;
		this.jg = jg;
		this.jp = jp;
		this.hits = hits;
		this.dobles = dobles;
		this.triples = triples;
		this.homeruns = homeruns;
		this.basebola = basebola;
		this.turnosjugados = turnosjugados;
		this.carreraAnotadas = carreras;
	}

	public int getJj() {
		return jj;
	}

	public void setJj(int jj) {
		this.jj = jj;
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

	public int getTripes() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}

	public int getDeball() {
		return deball;
	}

	public void setDeball(int deball) {
		this.deball = deball;
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

	public float obtenerPromedioBateo(){
		float promediobateo=hits/turnosjugados;
		return (float) promediobateo;
	}
	
	public float obtenerSlugging(){
		float slg = ((hits+dobles)+(2*triples)+(3*homeruns))/turnosjugados;
		return slg;
	}
	
}
