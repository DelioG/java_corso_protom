package gestioneGarageArrayList;
import ereditarietaFigura.Ovveride;

public class Furgone extends Veicolo {
	
	public Furgone(String targa, String nomeProprietario) {
		super(targa, nomeProprietario);
	}

	@Ovveride
	public void visualizzaDettagli() {
		System.out.println("TARGA: [" + getTarga() + "], PROPRIETARIO: [" + getNomeProprietario() + "].");
	}
	
}