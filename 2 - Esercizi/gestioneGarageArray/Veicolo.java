package gestioneGarageArray;

public class Veicolo {

	private String targa;
	private String nomeProprietario;
	
	public Veicolo(String targa, String nomeProprietario) {
		this.targa = targa;
		this.nomeProprietario = nomeProprietario;
	}
	
	/* ----------------- */
	/* Getters & Setters */
	/* ----------------- */
	
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	
	/* ----------------- */
	/*    Altri metodi   */
	/* ----------------- */
	
	public void visualizzaDettagli() {
		System.out.println("VEICOLO GENERICO");
	}
	
}
