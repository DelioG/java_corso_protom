package gestioneGarageArray;
import ereditarietaFigura.Ovveride;

public class Auto extends Veicolo {
	
	public Auto(String targa, String nomeProprietario) {
		super(targa, nomeProprietario);
	}
	
	@Ovveride
	public void visualizzaDettagli() 
	{
		System.out.println("AUTO - Targa: [" + getTarga() + "], Proprietario: [" + getNomeProprietario() + "].");
	}
	
}