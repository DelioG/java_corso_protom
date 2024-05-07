package lezioneSetTryCatch;

import java.util.Objects;

public class Persona {

	private String nome;
	private String cognome;
	private Integer eta;
	private Citta citta;
	
	public Persona() {
		
	}
	
	public Persona(String nome, String cognome, Integer eta, Citta citta) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.citta = citta;
	}

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

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}
	
	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public void salutami() {
		System.out.println("Ciao, io sono una Persona.");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return citta == other.citta && Objects.equals(cognome, other.cognome) && Objects.equals(eta, other.eta)
				&& Objects.equals(nome, other.nome);
	}
	
}