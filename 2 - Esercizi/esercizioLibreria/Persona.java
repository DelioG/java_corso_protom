package esercizioLibreria;

import java.util.Objects;

public abstract class Persona {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	
	public Persona(String nome, String cognome, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}
	
	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */
	
	@Override
	public String toString() {
		return getClass().getName() + " | Nome [" + nome + "], Cognome [" + cognome + "], C.F. [" + codiceFiscale + "].";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Persona other = (Persona) o;
		return     Objects.equals(nome, other.nome) 
				&& Objects.equals(cognome, other.cognome) 
				&& Objects.equals(codiceFiscale, other.codiceFiscale);
	}
	
}