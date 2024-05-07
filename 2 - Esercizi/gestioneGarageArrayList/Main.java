package gestioneGarageArrayList;

import java.util.Scanner;

public class Main {
	
	public static final String TEXT_RESET  = "\u001B[0m";
	public static final String TEXT_GREEN  = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_RED    = "\u001B[31m";
	
	public static void main(String[] args) {
		
		Scanner scannerN = new Scanner(System.in); 		// Scanner per numeri.
		Scanner scannerS = new Scanner(System.in); 		// Scanner per stringhe.
		int sceltaMenu = 0;								// Utilizzata per lo switch del menu.
		
		Integer nPostiAutoDisponibili = 0;				// Aggiornata con il valore inserito dall'utente.
		boolean nPostiAutoIsGood = false;				// Utilzzata per verficare se il numero di posti auto disponibili inserti è valido.
		int numeroMaxPostiAuto = 15;					// Numero massimo di posti auto selezionabili.
		
		
		// Faccio scegliere all'utente la grandezza del suo garage.
		// Verificando la validità del numero dei posti auto disponibili inseriti (>0 & <15).
		do {
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
		} while (!nPostiAutoIsGood);
		
		
		// Creazione Garage
		Garage garage = new Garage(nPostiAutoDisponibili);
		System.out.println(TEXT_GREEN + " GARAGE CREATO CORRETTAMENTE!" + TEXT_RESET);

		
		// Procedo con la stampa del menu principale.
		do {
			
			System.out.println("\n -------------------------- MENU ---------------------------");
			System.out.println(" 1) AGGIUNGI VEICOLO										  ");
			System.out.println(" 2) AGGIUNGI VEICOLO CON SOSTITUZIONE POSTO					  ");
			System.out.println(" 3) RIMUOVI VEICOLO DAL GARAGE								  ");
			System.out.println(" 4) VISUALIZZA GARAGE										  ");
			System.out.println(" 5) ESCI 													  ");
			System.out.println(" -----------------------------------------------------------  ");
			System.out.print  (" LA TUA SCELTA: ");
			sceltaMenu = scannerN.nextInt();
			
			
			switch (sceltaMenu) 
			{
			
				// Aggiunta di un nuovo veicolo al garage
				case 1:
					if(garage.getnVeicoli() < garage.getnPostiMax())					// Se ci sono posti disponibili nel garage...
					{
						System.out.print(" INSERISCI LA TARGA DEL VEICOLO: ");
						String targa = scannerS.nextLine();
						
						System.out.print(" INSERISCI IL NOME DEL PROPRIETARIO: ");
						String nomeProprietario = scannerS.nextLine();
						
						Boolean tipologiaIsGood  = false;
						
						do 
						{
							System.out.print(" SCEGLI LA TIPOLOGIA DI VEICOLO DA AGGIUNGERE: 1 [AUTO], 2 [MOTO], 3 [FURGONE]. -> ");
							Integer tipologiaVeicolo = scannerN.nextInt();
							
							if(tipologiaVeicolo == 1 || tipologiaVeicolo == 2 || tipologiaVeicolo == 3)
							{
								garage.aggiungiVeicolo(garage.creaVeicolo(tipologiaVeicolo, targa, nomeProprietario));
								tipologiaIsGood = true;
							}
							else
							{
								System.out.println(TEXT_RED + " ERRORE: PER FAVORE INSERISCI UNA TIPOLOGIA DI VEICOLO VALIDA" + TEXT_RESET);
							}
						} while(!tipologiaIsGood);
					} 
					else 																// Se non ci sono posti disponibili nel garage...
					{
						System.out.println(TEXT_RED + " ERRORE: IL GARAGE E' PIENO!" + TEXT_RESET);
					}
					break;

				// Aggiunta di un veicolo con sostituzione posto
				case 2:
					System.out.print(" SCEGLI LA POSIZIONE DEL VEICOLO CHE VUOI SOSTITUIRE: ");
					Integer posizioneVeicoloDaSostituire = scannerN.nextInt();
						
					if(posizioneVeicoloDaSostituire < 0 || posizioneVeicoloDaSostituire > nPostiAutoDisponibili)
					{
						System.out.println(TEXT_RED + " ERRORE: POSIZIONE INSERITA NON VALIDA." + TEXT_RESET);
					}
					else
					{
						if(garage.checkPostiVuoti())		// Verificare se ci sono posti vuoti.
						{
							System.out.print(" INSERISCI LA TARGA DEL VEICOLO: ");
							String targa = scannerS.nextLine();
							
							System.out.print(" INSERISCI IL NOME DEL PROPRIETARIO: ");
							String nomeProprietario = scannerS.nextLine();
							
							Boolean tipologiaIsGood  = false;
							
							do
							{
								System.out.print(" SCEGLI LA TIPOLOGIA DI VEICOLO DA AGGIUNGERE: 1 [AUTO], 2 [MOTO], 3 [FURGONE]. -> ");
								Integer tipologiaVeicolo = scannerN.nextInt();
									
								if(tipologiaVeicolo == 1 || tipologiaVeicolo == 2 || tipologiaVeicolo == 3)
								{
									garage.sostituisciVeicolo(posizioneVeicoloDaSostituire, garage.creaVeicolo(tipologiaVeicolo, targa, nomeProprietario));
									tipologiaIsGood = true;
								}
								else
								{
									System.out.println(TEXT_RED + " ERRORE: PER FAVORE INSERISCI UNA TIPOLOGIA DI VEICOLO VALIDA!" + TEXT_RESET);
								}
							} while(!tipologiaIsGood);
						}
						else
						{
							System.out.println(TEXT_RED + " ERRORE: NON CI SONO POSTI LIBERI DISPONIBILI!" + TEXT_RESET);
						}
					}
					break;
					
				// Rimozione di un veicolo dal garage	
				case 3:
					if(garage.getnVeicoli() == 0) 
					{
						System.out.println(TEXT_RED + " ERRORE: IL GARAGE E' VUOTO!" + TEXT_RESET);
					}
					else
					{
						Boolean posizioneIsGood  = false;
						
						do
						{
							System.out.print(" PER FAVORE DIGITA LA POSIZIONE DEL VEICOLO CHE VUOI RIMUOVERE DAL GARAGE: ");
							Integer posizioneVeicoloDaEstrarre = scannerN.nextInt();
							
							if(posizioneVeicoloDaEstrarre >= 0 && posizioneVeicoloDaEstrarre < nPostiAutoDisponibili)
							{
								garage.rimuoviVeicolo(posizioneVeicoloDaEstrarre);
								posizioneIsGood = true;
							}
							else
							{
								System.out.println(TEXT_RED + " POSIZIONE NON VALIDA, PER FAVORE INSERISCI UNA POSIZIONE VALIDA..." + TEXT_RESET);
							}
						} while(!posizioneIsGood);
					}
					break;
				
				// Stampa dello stato del garage
				case 4:
					garage.visualizzaGarage();
					break;
					
				
				// Uscita dal programma
				case 5:
					System.out.println(TEXT_GREEN + " ARRIVEDERCI!" + TEXT_RESET);
					break;
					
				
				// Altri casi / Input non valido
				default:
					System.out.println(TEXT_RED + " ERRORE: SCELTA NON CONSENTITA!" + TEXT_RESET);
					break;
					
					
			}
			
		} while (sceltaMenu != 5);
		
		scannerN.close();
		scannerS.close();
		
	}
	
}