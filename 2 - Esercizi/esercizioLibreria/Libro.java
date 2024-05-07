package esercizioLibreria;

import java.util.Objects;

public class Libro {

	private String titolo;
	private Autore autore;
	private GenereLibro genere;
	
	public Libro(String titolo, Autore autore, GenereLibro genere) {
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
	}

	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public GenereLibro getGenere() {
		return genere;
	}

	public void setGenereLibro(GenereLibro genereLibro) {
		genere = genereLibro;
	}

	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */
	
	@Override
	public String toString() {
		return "Titolo: [" + getTitolo() + "], Autore: [" + getAutore() + "], GenereLibro: [" + getGenere() + "].";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Libro other = (Libro) o;
		return     Objects.equals(titolo, other.titolo) 
				&& Objects.equals(autore, other.autore) 
				&& Objects.equals(genere, other.genere);
	}
}
