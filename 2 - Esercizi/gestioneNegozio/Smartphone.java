package gestioneNegozio;

public class Smartphone extends Prodotto {

	private String sistemaOperativo;
	private int gbRam;
	private String annoProduzione;
	
	public Smartphone(String marca, String modello, double prezzo, String sistemaOperativo, int gbRam, String annoProduzione) {
		super(marca, modello, prezzo);
		this.sistemaOperativo = sistemaOperativo;
		this.gbRam = gbRam;
		this.annoProduzione = annoProduzione;
	}

	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public int getGbRam() {
		return gbRam;
	}

	public void setGbRam(int gbRam) {
		this.gbRam = gbRam;
	}

	public String getAnnoProduzione() {
		return annoProduzione;
	}

	public void setAnnoProduzione(String annoProduzione) {
		this.annoProduzione = annoProduzione;
	}
	
	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */
	
	@Override
	public void applicaSconto(double percentualeSconto) {
		super.applicaSconto(percentualeSconto);
	}

	@Override
	public String toString() {
		return super.toString() + "S.O. [" + sistemaOperativo + "], Ram [" + gbRam + "], Anno di Produzione [" + annoProduzione + "].";
	}
	
}
