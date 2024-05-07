package gestioneGarageArray;
import ereditarietaFigura.Ovveride;

public class Furgone extends Veicolo {
	
	public Furgone(String targa, String nomeProprietario) {
		super(targa, nomeProprietario);
	}

	@Ovveride
	public void visualizzaDettagli() 
	{
		System.out.println("FURGONE - Targa: [" + getTarga() + "], Proprietario: [" + getNomeProprietario() + "].");
	}
	
}