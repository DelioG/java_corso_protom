package gestioneGarageArray;
import ereditarietaFigura.Ovveride;

public class Moto extends Veicolo {

	public Moto(String targa, String nomeProprietario) {
		super(targa, nomeProprietario);
	}

	@Ovveride
	public void visualizzaDettagli() 
	{
		System.out.println("MOTO - Targa: [" + getTarga() + "], Proprietario: [" + getNomeProprietario() + "].");
	}
	
}