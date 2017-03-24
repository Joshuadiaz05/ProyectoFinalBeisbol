package logical;

public class Estadisticas {

	private int jj;
	private int jg;
	private int jp;
	private int hits;
	private int homeruns;
	private int basebola;
	private int turnosjugados;
	private float slg;
	private float promediobateo;
	
	public Estadisticas(int jj, int jg, int jp, int hits, int homeruns, int basebola, int turnosjugados, float slg,
			float promediobateo) {
		super();
		this.jj = jj;
		this.jg = jg;
		this.jp = jp;
		this.hits = hits;
		this.homeruns = homeruns;
		this.basebola = basebola;
		this.turnosjugados = turnosjugados;
		this.slg = slg;
		this.promediobateo = promediobateo;
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

	public float getSlg() {
		return slg;
	}

	public void setSlg(float slg) {
		this.slg = slg;
	}

	public float getPromediobateo() {
		return promediobateo;
	}

	public void setPromediobateo(float promediobateo) {
		this.promediobateo = promediobateo;
	}

	
	
}
