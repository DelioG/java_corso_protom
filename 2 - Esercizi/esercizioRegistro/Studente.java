package esercizioRegistro;

public class Studente {

	private String nome;
	private int voto;
	private String classe;

	public Studente(String nome, int voto, String classe) {
		this.nome = nome;
		this.voto = voto;
		this.classe = classe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public void visualizzaDettagli() {
		System.out.println(
				" STUDENTE -> NOME: [" + this.nome + "], VOTO: [" + this.voto + "], CLASSE: [" + this.classe + "].");
	}

}
