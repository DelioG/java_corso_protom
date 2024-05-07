package gestioneGarageArrayList;

public abstract class Veicolo {
	
	private String targa;
	private String nomeProprietario;
	
	public Veicolo(String targa, String nomeProprietario) {
		this.targa = targa;
		this.nomeProprietario = nomeProprietario;
	}
	
	/* ----------------- */
	/* GETTERS & SETTERS */
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
	/*    ALTRI METODI   */
	/* ----------------- */
	
	public void visualizzaDettagli() {
		System.out.println("VEICOLO GENERICO");
	}

}