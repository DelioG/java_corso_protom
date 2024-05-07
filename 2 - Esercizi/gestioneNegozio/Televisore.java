package gestioneNegozio;

public class Televisore extends Prodotto {

	private double numeroPollici;
	private boolean isSmart;
	
	public Televisore(String marca, String modello, double prezzo, double numeroPollici, boolean isSmart) {
		super(marca, modello, prezzo);
		this.numeroPollici = numeroPollici;
		this.isSmart = isSmart;
	}
	
	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public double getNumeroPollici() {
		return numeroPollici;
	}

	public void setNumeroPollici(double numeroPollici) {
		this.numeroPollici = numeroPollici;
	}

	public boolean isSmart() {
		return isSmart;
	}

	public void setSmart(boolean isSmart) {
		this.isSmart = isSmart;
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
		return super.toString() + "Numero Pollici [" + numeroPollici + "], SmartTV [" + isSmart + "].";
	}
	
	
	
}
