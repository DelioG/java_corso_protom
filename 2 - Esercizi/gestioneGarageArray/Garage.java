package gestioneGarageArray;


public class Garage {
	
	Veicolo veicoli[];
	private Integer numeroVeicoli;	// n. veicoli presenti all'interno del garage, aggiornato ogni volta che si aggiunge o si rimuove un veicolo.
	
	public Garage(Integer nPostiAutoDisponibili) {
		numeroVeicoli = 0;
		veicoli = new Veicolo[nPostiAutoDisponibili];
	}
	
	/* ----------------- */
	/* Getters & Setters */
	/* ----------------- */
	
	public Veicolo[] getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(Veicolo[] veicoli) {
		this.veicoli = veicoli;
	}

	public Integer getNumeroVeicoli() {
		return numeroVeicoli;
	}

	public void setNumeroVeicoli(Integer numeroVeicoli) {
		this.numeroVeicoli = numeroVeicoli;
	}
	
	/* ----------------- */
	/*    Altri metodi   */
	/* ----------------- */
	
	public Veicolo creazioneVeicolo(Integer tipologiaVeicolo, String targa, String nomeProprietario) {
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
		for (int i = 0; i < veicoli.length; i++)
		{
			if (veicoli[i] == null) 										// Avvio un ciclo, e prendo la prima posizione disponibile (non occupata).
			{
				veicoli[i] = veicolo;
				numeroVeicoli++;											// Aumento il counter dei veicoli presenti nel garage.
				System.out.println(Main.TEXT_GREEN + " VEICOLO AGGIUNTO!" + Main.TEXT_RESET);
				break;														// Una volta aggiunto il veicolo interrompo il ciclo for.
			}
		}
	}
	
	public void sostituisciVeicolo(Integer posizioneVeicoloDaSostituire, Veicolo veicoloSostitutivo) {
		Integer indexItemVeicoli = 0;
		Boolean postoLibero = false;
		
		for (int i = 0; i < veicoli.length; i++)
		{
			indexItemVeicoli = i;												// Questa variabile funziona come una sorta di "indexOf()", dell'item attuale.
			if(posizioneVeicoloDaSostituire == i)								// Prendo prima il posto selezionato dall'utente.
			{
				if(!postoLibero)
				{
					if(posizioneVeicoloDaSostituire == i && veicoli[i] == null)
					{
						System.out.println(Main.TEXT_YELLOW + " AVVISO: IL POSTO AUTO ERA GIA' LIBERO, NUOVO VEICOLO INSERITO SENZA ESGUIRE SOSTITUZIONI." + Main.TEXT_RESET);
						veicoli[i] = veicoloSostitutivo;
						numeroVeicoli++;
						postoLibero = true;
					}
					else
					{
						for (int j = 0; j < veicoli.length; j++)				// Verifico prima se c'è un posto libero per l'auto sostituita.
						{
							if(veicoli[j] == null) 								// Nel caso ci fosse, sposto prima l'auto da sostituire nel primo posto disponibile.
							{
								veicoli[j] = veicoli[i];						// Sposto l'auto che occupa la posizione al primo posto disponibile.
								postoLibero = true;								// Se lo scambio è avvenuto setto la variabile su true.
								break;
							}
						}
						
						veicoli[i] = veicoloSostitutivo;						// Ed infine inserisco l'auto sostitutiva nel posto che si è appena liberato.
						System.out.println(Main.TEXT_YELLOW + " AVVISO: VEICOLO SOSTITUITO" + Main.TEXT_RESET);
					}
						
				}
				else if(postoLibero)
				{
					System.out.println(Main.TEXT_RED + " ERRORE: IL POSTO SELEZIONATO E' GIA' OCCUPATO, E NON CI SONO ALTRI POSTI DISPONIBILI NEL GARAGE." + Main.TEXT_RESET);
					break;
				}
				
				break;	// Chiudo il ciclo while anticipatamente
			}
		}
		
		if(!postoLibero)
		{
			System.out.println(Main.TEXT_RED + " ERRORE: POSTO AUTO NON TROVATO, NESSUNA SOSTITUZIONE EFFETTUATA!" + Main.TEXT_RESET);
		}
	}
	
	public void estraiVeicolo(Integer posizioneVeicoloDaEstrarre) {
		Integer indexItemVeicoli = 0;
		Boolean veicoloTrovato = false;
		
		for (int i = 0; i < veicoli.length; i++)
		{
			indexItemVeicoli = i;											// Questa variabile funziona come una sorta di "indexOf()", dell'item attuale.
			if(posizioneVeicoloDaEstrarre == i && veicoli[i] != null)		// Se trova il posto auto selezionato, e non è libero.
			{
				veicoli[i] = null;											// Libero il posto auto.
				System.out.println(Main.TEXT_YELLOW + " AVVISO: IL POSTO AUTO E' STATO LIBERATO!" + Main.TEXT_RESET);
				numeroVeicoli--;
				veicoloTrovato = true;
				break;
			}
			else if(posizioneVeicoloDaEstrarre == i && veicoli[i] == null)	// Se trova il posto auto selezionato, ed è libero.
			{
				System.out.println(Main.TEXT_YELLOW + " AVVISO: IL POSTO AUTO E' GIA' LIBERO, NESSUN VEICOLO VERRA' ESTRATTO." + Main.TEXT_RESET);
				veicoloTrovato = true;
				break;
			}
		}
		
		if(!veicoloTrovato)
		{
			System.out.println(Main.TEXT_RED + " ERRORE: IL POSTO AUTO SELEZIONATO NON ESISTE." + Main.TEXT_RESET);
		}
	}
	
	public void visualizzaGarage()
	{
		System.out.println(" IL GARAGE CONTIENE NUMERO [" + numeroVeicoli + "] VEICOLI.");
		
		for(int i=0; i<veicoli.length; i++)
		{
			if(veicoli[i] != null) {											// Senza if mi da errore: "can't invoke method because element is null".
				System.out.print(" " + i + " - ");
				veicoli[i].visualizzaDettagli();
			} else {
				System.out.println(" " + i + " - Posto vuoto");
			}
		}
	}
	
}
