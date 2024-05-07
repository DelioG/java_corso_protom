/*
 	Gestione di un garage seguendo le seguenti specifiche:
 		- Il garage ha massimo 15 posti, ogni posto è identificato da un progressivo (da 0 a 14).
 		- Il garage può ospitare solo auto, moto e furgoni.
 		- Implementare una funzione che inserisce un nuovo veicolo nel garage nel primo posto disponibile effettuando gli opportuni controlli.
 		- Implementare una funzione che inserisce un nuovo veicolo in un determinato posto preso in input effettuando gli opportuni controlli.
 		- Implementare una funzione che estrae un veicolo nel garage prendendo in input il numero del posto e ritornando in output l’istanza del veicolo stesso.
 		- Implementare una funzione che stampi la situazione corrente dei posti nel garage
 		- Implementare in ogni classe il metodo toString() o un metodo mostraDettagli().
 */
package gestioneGarageArray;

import java.util.Scanner;

public class Main {
	
	public static final String TEXT_RESET  = "\u001B[0m";
	public static final String TEXT_GREEN  = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_RED    = "\u001B[31m";
	
	public static void main(String[] args) {
		
		Scanner scannerN = new Scanner(System.in); 	// Scanner per numeri.
		Scanner scannerS = new Scanner(System.in); 	// Scanner per stringhe.
		int sceltaMenu = 0;							// Utilizzata per lo switch del menu.
		
		Integer nPostiAutoDisponibili = 0;			// Aggiornata con il valore inserito dall'utente.
		boolean nPostiAutoIsGood = false;			// Utilzzata per verficare se il numero di posti auto disponibili inserti è valido.
		int numeroMaxPostiAuto = 15;				// Numero massimo di posti auto selezionabili.
		
		do
		{
			System.out.print(" INSERISCI IL NUMERO DI POSTI AUTO DISPONIBILI NEL GARAGE (MAX. " + numeroMaxPostiAuto + " POSTI AUTO): ");
			nPostiAutoDisponibili = scannerN.nextInt();
			
			if (nPostiAutoDisponibili <= 0 || nPostiAutoDisponibili > numeroMaxPostiAuto)
			{
				System.out.println(TEXT_RED + " ERRORE: PER FAVORE INSERISCI UN NUMERO DI POSTI AUTO MASSIMO VALIDO!\n" + TEXT_RESET);
			}
			else
			{
				nPostiAutoIsGood = true;
			}
			
		} while (!nPostiAutoIsGood);				// Verifica validità numero posti auto disponibili inseriti (>0 & <15)
		
		// Creazione Garage
		Garage garage = new Garage(nPostiAutoDisponibili);
		System.out.println(TEXT_GREEN + " AVVISO: GARAGE CREATO CORRETTAMENTE!" + TEXT_RESET);
		
		// Procedo con la stampa del menu principale.
		do
		{
			System.out.println("\n -------------------------- MENU ---------------------------");
			System.out.println(" 1) AGGIUNGI VEICOLO										  ");
			System.out.println(" 2) AGGIUNGI VEICOLO CON SOSTITUZIONE POSTO					  ");
			System.out.println(" 3) ESTRAI VEICOLO DAL GARAGE								  ");
			System.out.println(" 4) VISUALIZZA GARAGE										  ");
			System.out.println(" 5) ESCI 													  ");
			System.out.println(" -----------------------------------------------------------  ");
			System.out.print(" LA TUA SCELTA: ");
			sceltaMenu = scannerN.nextInt();

			switch (sceltaMenu) 
			{
				case 1:
					if(garage.getNumeroVeicoli() < garage.getVeicoli().length)			// Controllo prima se il garage è già pieno.
					{																	// Ovvero se il numero dei veicoli aggiunti è minore della grandezza dell'array dei veicoli.
						System.out.print(" INSERISCI LA TARGA DEL VEICOLO: ");
						String targa = scannerS.nextLine();
						
						System.out.print(" INSERISCI IL NOME DEL PROPRIETARIO: ");
						String nomeProprietario = scannerS.nextLine();
						
						Boolean tipologiaIsGood  = false;
						do {
							System.out.print(" SCEGLI LA TIPOLOGIA DI VEICOLO DA AGGIUNGERE: 1 [AUTO], 2 [MOTO], 3 [FURGONE]. -> ");
							Integer tipologiaVeicolo = scannerN.nextInt();
							
							if(tipologiaVeicolo == 1 || tipologiaVeicolo == 2 || tipologiaVeicolo == 3)
							{
								garage.aggiungiVeicolo(garage.creazioneVeicolo(tipologiaVeicolo, targa, nomeProprietario));
								tipologiaIsGood = true;
							}
							else
							{
								System.out.println(TEXT_RED + " ERRORE: PER FAVORE INSERISCI UNA TIPOLOGIA DI VEICOLO VALIDA" + TEXT_RESET);
							}
						} while(!tipologiaIsGood);
						
					}
					else
					{
						System.out.println(TEXT_RED + " ERRORE: GARAGE PIENO, NON PUOI AGGIUNGERE ALTRI VEICOLI!" + TEXT_RESET);
					}
					break;
				
				case 2:
					System.out.print(" SCEGLI LA POSIZIONE DEL VEICOLO CHE VUOI SOSTITUIRE: ");
					Integer posizioneVeicoloDaSostituire = scannerN.nextInt();
						
					if(posizioneVeicoloDaSostituire < 0 || posizioneVeicoloDaSostituire > nPostiAutoDisponibili)
					{
						System.out.println(TEXT_RED + " ERRORE: LA POSIZIONE INSERITA NON E' VALIDA." + TEXT_RESET);
					}
					else
					{
						System.out.print(" INSERISCI LA TARGA DEL VEICOLO: ");
						String targa = scannerS.nextLine();
						
						System.out.print(" INSERISCI IL NOME DEL PROPRIETARIO: ");
						String nomeProprietario = scannerS.nextLine();
						
						Boolean tipologiaIsGood  = false;
						do {
							System.out.print(" SCEGLI LA TIPOLOGIA DI VEICOLO DA AGGIUNGERE: 1 [AUTO], 2 [MOTO], 3 [FURGONE]. -> ");
							Integer tipologiaVeicolo = scannerN.nextInt();
								
							if(tipologiaVeicolo == 1 || tipologiaVeicolo == 2 || tipologiaVeicolo == 3)
							{
								garage.sostituisciVeicolo(posizioneVeicoloDaSostituire, garage.creazioneVeicolo(tipologiaVeicolo, targa, nomeProprietario));
								tipologiaIsGood = true;
							}
							else
							{
								System.out.println(TEXT_RED + " ERRORE: PER FAVORE INSERISCI UNA TIPOLOGIA DI VEICOLO VALIDA" + TEXT_RESET);
							}
						} while(!tipologiaIsGood);
					}
					break;
					
				case 3:
					if(garage.getNumeroVeicoli() == 0) 
					{
						System.out.println(TEXT_RED + " ERRORE: NESSUNA AUTO ESTRAIBILE, IL GARAGE E' VUOTO, PER FAVORE AGGIUNGI PRIMA DEI VEICOLI!" + TEXT_RESET);
					}
					else
					{
						System.out.print(" PER FAVORE DIGITA LA POSIZIONE DEL VEICOLO CHE VUOI ESTRARRE DAL GARAGE: ");
						Integer posizioneVeicoloDaEstrarre = scannerN.nextInt();
						garage.estraiVeicolo(posizioneVeicoloDaEstrarre);
					}
					break;
					
				case 4:
					if(garage.getNumeroVeicoli() > 0)	// Controllo se il garage è vuoto o meno.
					{
						garage.visualizzaGarage();
					}
					else
					{
						System.out.println(TEXT_RED + " ERRORE: IL GARAGE E' VUOTO, PER FAVORE AGGIUNGI PRIMA DEI VEICOLI!" + TEXT_RESET);
					}
					break;
					
				case 5:
					System.out.println(TEXT_GREEN + " ARRIVEDERCI!" + TEXT_RESET);
					break;
					
				default:
					System.out.println(TEXT_RED + " ERRORE: SCELTA NON CONSENTITA, PER FAVORE SCEGLI UNA TRA LE OPZIONI DISPONIBILI!" + TEXT_RESET);
					break;
			}
			
		} while (sceltaMenu != 5);
		
		scannerN.close();
		scannerS.close();
	}
	
}