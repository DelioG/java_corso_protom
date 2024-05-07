package esercizioLibreria;

public class Autore extends Persona {
	
	private Integer nLibriScritti;

	public Autore(String nome, String cognome, String codiceFiscale) {
		super(nome, cognome, codiceFiscale);
		this.nLibriScritti = 0;
	}

	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public Integer getnLibriScritti() {
		return nLibriScritti;
	}

	public void setnLibriScritti(Integer nLibriScritti) {
		this.nLibriScritti = nLibriScritti;
	}
	
	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */
	
	@Override
	public String toString() {
		return getNome() + " " + getCognome() + " (" + getCodiceFiscale() + ") | N. LIBRI SCRITTI (" + getnLibriScritti() + ")";
	}
	
}