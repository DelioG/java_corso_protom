package ereditarietaPersona;

public class Studente extends Persona {

	private String matricola;
	private String cdl;
	
	public Studente(String nome, String cognome, Integer eta, String matricola, String cdl)  {
		super(nome, cognome, eta);
		this.matricola = matricola;
		this.cdl = cdl;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCdl() {
		return cdl;
	}

	public void setCdl(String cdl) {
		this.cdl = cdl;
	}
	
	@Override
	public void salutami() { // Questa è la firma del metodo, ovvero tutto "public", "void", salutami(), ed eventuali parametri in ingresso.
		System.out.println("Ciao, io sono uno Studente.");
	}
	
	public void stampaColore(String colore) {
		System.out.println("Questo è il colore: " + colore);
	}
	
	public String stampaColore(int a, int b, int c) {
		return "Questo è il colore in rgb: " + a + ", " + b + ", " + c + ".";
	}
	
}