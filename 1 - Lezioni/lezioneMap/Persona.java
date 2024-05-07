package lezioneMap;

public class Persona {

	private String nome;
	private String cognome;
	private Integer eta;
	
	public Persona() {
		
	}
	
	public Persona(String nome, String cognome, Integer eta) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
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
	
	public void salutami() {
		System.out.println("Ciao, io sono una Persona.");
	}
	
}