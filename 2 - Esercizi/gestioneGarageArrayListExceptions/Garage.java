package gestioneGarageArrayListExceptions;

import java.util.ArrayList;
import java.util.Collections;

public class Garage {
	
	private Integer nPostiMax;
	private Integer nVeicoli;
	private ArrayList<Veicolo> veicoli;
	
	public Garage(Integer nPostiAutoDisponibili) {
		this.nVeicoli	= 0;
		this.nPostiMax 	= nPostiAutoDisponibili;
		this.veicoli 	= new ArrayList<>(Collections.nCopies (nPostiAutoDisponibili, null));	// Setto l'array con la grandezza del garage passata dall'utente nel main.
	}
	
	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public Integer getnPostiMax() {
		return nPostiMax;
	}

	public void setnPostiMax(Integer nPostiMax) {
		this.nPostiMax = nPostiMax;
	}

	public Integer getnVeicoli() {
		return nVeicoli;
	}

	public void setnVeicoli(Integer nVeicoli) {
		this.nVeicoli = nVeicoli;
	}

	public ArrayList<Veicolo> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(ArrayList<Veicolo> veicoli) {
		this.veicoli = veicoli;
	}
	
	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */

	public void controllaPostiVuoti() throws GaragePienoException {
		if(!veicoli.contains(null))
			throw new GaragePienoException(" ERRORE: IL GARAGE E' PIENO.");
	}
	
	public void controllaGarageSeVuoto() throws GarageVuotoException {
		if(nVeicoli == 0)
			throw new GarageVuotoException(" ERRORE: IL GARAGE E' VUOTO.");
	}
	
	public Veicolo creaVeicolo(Integer tipologiaVeicolo, String targa, String nomeProprietario) {
		// Questo metodo si occupa di creare un oggetto della tipologia scelta dall'utente nel main.
		
		Veicolo veicolo = null;
		
		if(tipologiaVeicolo == 1)
		{
			veicolo = new Auto(targa, nomeProprietario);
		}
		else if(tipologiaVeicolo == 2)
		{
			veicolo = new Moto(targa, nomeProprietario);
		}
		else if(tipologiaVeicolo == 3)
		{
			veicolo = new Furgone(targa, nomeProprietario);
		}
		
		return veicolo;

	}
	
	public void aggiungiVeicolo(Veicolo veicolo) {
		
		for(int i=0; i<veicoli.size(); i++) 
		{
			if(veicoli.get(i) == null)						// Trovo la prima posizione disponibile all'interno dell'arraylist
			{
				veicoli.set(i, veicolo);					// Rimpiazzo il contenuto della posizione vacante con l'oggetto creato precedentemente.
				nVeicoli++;									// Aggiorno il counter dei veicoli presenti nel garage.
				System.out.println(Main.TEXT_GREEN + " VEICOLO AGGIUNTO!" + Main.TEXT_RESET);
				break;										// Chiudo il ciclo for una volta effettuata l'operazione.
			}
		}
		
	}
	
	public void sostituisciVeicolo(Integer posVeicoloDaSostituire, Veicolo veicoloSostitutivo) {
		
		int i = 0;											// Utilizzato come contatotore.
		
		for(Veicolo v : veicoli)
		{
			if(i == posVeicoloDaSostituire)					// Se la corrente iterazione del foreach corrisponde alla posizione del veicolo da sostituire...
			{
				for(int j=0; j<veicoli.size(); j++)			// Avvio un ciclo per verificare la prima posizione libera disponibile nell'arraylist dei veicoli.
				{
					if(veicoli.get(j) == null)				// Sposto il veicolo che occupa il posto al primo posto ibero disponibile.
					{
						veicoli.set(j, v);					// Sposto il veicolo.
						veicoli.set(i, veicoloSostitutivo);	// Inserisco il veicolo sostitutivo nella posizione che si è appena liberata.
					}
				}
				
				System.out.println(Main.TEXT_GREEN + " VEICOLO AGGIUNTO CORRETTAMENTE!" + Main.TEXT_RESET);
				nVeicoli++;									// Aggiorno la variabile contente il numero dei veicoli presneti nel garage.
				break;										// Chiudo il ciclo foreach.
			}
			
			i++;											// Aumento l'iterazione per il foreach.
		}
		
	}

	public void rimuoviVeicolo(Integer posVeicolo) {
		
		int i = 0;
			
		for(Veicolo v : veicoli) 
		{
			if(i == posVeicolo)								// Se la corrente iterazione del foreach corrisponde alla posizione del veicolo da rimuovere...
			{
				if(v == null)								// Se la posizione inserita dall'utente è libera...
				{
					System.out.println(Main.TEXT_RED + " ERRORE: POSTO VUOTO, NESSUN VEICOLO DA RIMUOVERE!" + Main.TEXT_RESET);
					break;
				}
				else										// Se la posizione inserita dall'utente non è libera...
				{
					veicoli.set(i, null);					// Rimpiazzo l'oggetto da rimuovere con null, in modo da non far "shiftare" le posizioni degli altri veicoli.
					nVeicoli--;								// Aggiorno il counter dei veicoli presenti nel garage.
					System.out.println(Main.TEXT_GREEN + " VEICOLO RIMOSSO!" + Main.TEXT_RESET);
				}
				break;										// Chiudo il ciclo for una volta effettuata l'operazione.
			}
				
			i++;
		}
		
	}

	public void visualizzaGarage() throws GarageVuotoException {
		
		int i = 0;
		int cAuto = 0, cFurgoni = 0, cMoto = 0;
			
		System.out.println(" IL GARAGE CONTIENE NUMERO [" + Main.TEXT_YELLOW + nVeicoli + Main.TEXT_RESET+ "] VEICOLI.");
			
		for(Veicolo v : veicoli) 
		{
			if(v != null)
			{
				System.out.print(Main.TEXT_YELLOW + " POS." + Main.TEXT_RESET + i + " - ");
					
				if(v instanceof Auto)
				{
					System.out.print("AUTO -> ");
					cAuto++;
				}
				else if (v instanceof Furgone)
				{
					System.out.print("FURGONE -> ");
					cFurgoni++;
				}
				else if (v instanceof Moto)
				{
					System.out.print("MOTO -> ");
					cMoto++;
				}
					
				v.visualizzaDettagli();
			} 
			else 
			{
				System.out.println(Main.TEXT_YELLOW + " POS." + Main.TEXT_RESET  + i + " - VUOTO");
			}
				
			i++;
		}
			
		System.out.println("\n IL GARAGE CONTIENE NUMERO [" + Main.TEXT_YELLOW + cAuto + Main.TEXT_RESET+ "] AUTO.");
		System.out.println(" IL GARAGE CONTIENE NUMERO [" + Main.TEXT_YELLOW + cFurgoni + Main.TEXT_RESET+ "] FURGONI.");
		System.out.println(" IL GARAGE CONTIENE NUMERO [" + Main.TEXT_YELLOW + cMoto + Main.TEXT_RESET+ "] MOTO.");
			
	}

}