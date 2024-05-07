package gestioneNegozio;

public abstract class Prodotto {
	
	private String marca;
	private String modello;
	private double prezzo;
	
	public Prodotto(String marca, String modello, double prezzo) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
	}
	
	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */
	
	public void applicaSconto(double percentualeSconto) {
		double sconto = (this.prezzo * percentualeSconto) / 100;
		this.prezzo = this.prezzo - sconto;
	}

	@Override
	public String toString() {
		return getClass().getName() + " | Marca [" + marca + "], Modello [" + modello + "], Prezzo [" + prezzo + "], ";
	}
	
}