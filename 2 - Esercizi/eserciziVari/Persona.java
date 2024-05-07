package eserciziVari;

public class Persona {

	private String nome;
	private String cognome;
	private Integer eta;
	private String regione;
	
	public Persona() {
		
	}
	
	public Persona(String nome, String cognome, Integer eta, String regione) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.regione = regione;
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

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) { // Questa è la firma del metodo, comprende tutto su questa linea di codice.
		this.regione = regione;
	}
	
}