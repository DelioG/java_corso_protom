package ereditarietaFigura;

public class Quadrato extends Figura {

	public Integer lato;

	public Quadrato(String nome, Integer lato) {
		super(nome);
		this.lato = lato;
	}

	public Integer getLato() {
		return lato;
	}

	public void setLato(Integer lato) {
		this.lato = lato;
	}
	
	@Ovveride
	public Integer calcolaArea() {
		Integer area = this.lato * this.lato;
		return area;
	}
	
}