package esercizioRegistro;

import java.util.Scanner;

public class Main {

	public static final String TEXT_RESET  = "\u001B[0m";
	public static final String TEXT_GREEN  = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_RED    = "\u001B[31m";
	
	public static void main(String[] args) {

		Scanner scannerN = new Scanner(System.in); 	// Scanner per numeri.
		Scanner scannerS = new Scanner(System.in); 	// Scanner per stringhe.
		Integer nStudentiMax = 0;
		boolean nStudentiIsGood = false;
		int sceltaMenu = 0;
		int numeroStudenti = 10;
		
		do 	// Controllo prima se il numero di studenti massimo inserito è maggiore di 0.
		{
			System.out.print(" INSERISCI IL NUMERO MASSIMO DI STUDENTI PER IL REGISTRO (MAX " + numeroStudenti + "): ");
			nStudentiMax = scannerN.nextInt();

			if (nStudentiMax <= 0 || nStudentiMax > numeroStudenti)
			{
				System.out.println(TEXT_RED + " ERRORE: PER FAVORE INSERISCI UN NUMERO DI STUDENTI MASSIMO VALIDO!\n" + TEXT_RESET);
			}
			else
			{
				nStudentiIsGood = true;
				break;
			}
			
		} while (!nStudentiIsGood);
		
		RegistroStudenti registro = new RegistroStudenti(nStudentiMax);
		System.out.println(TEXT_GREEN + " AVVISO: REGISTRO CREATO CORRETTAMENTE!" + TEXT_RESET);
		
		do	// Procedo a stampare il menu del programma "principale"
		{
			System.out.println("\n -------------------------- MENU ---------------------------");
			System.out.println(" 1) AGGIUNGI STUDENTE");
			System.out.println(" 2) VISUALIZZA REGISTRO");
			System.out.println(" 3) ESCI ");
			System.out.println(" -----------------------------------------------------------  ");
			System.out.print(" LA TUA SCELTA: ");
			sceltaMenu = scannerN.nextInt();

			switch (sceltaMenu) 
			{
				case 1:
					if(registro.getNumeroStudenti() < registro.getStudenti().length)		// Controllo prima se il registro è già pieno.
					{
						Integer voto;
						Boolean votoIsGood = false;
						
						System.out.print("\n - NOME STUDENTE  : ");
						String nome = scannerS.nextLine();
						
						do {																// Controllo sul voto, deve essere compreso tra 0 e 10.
							System.out.print(" - VOTO STUDENTE  : ");
							voto = scannerN.nextInt();
							
							if(voto<0 || voto >10)											
							{
								System.out.println(TEXT_YELLOW + "   AVVISO: IL VOTO DELLO STUDENTE DEVE ESSERE COMPRESO TRA 0 E 10!" + TEXT_RESET);
							}
							else
							{
								votoIsGood = true;
								break;
							}
						} while(!votoIsGood);
						
						System.out.print(" - CLASSE STUDENTE: ");
						String classe = scannerS.nextLine();
						
						registro.aggiungiStudente(nome, voto, classe);
						break;
					
					}
					else
					{
						System.out.println(TEXT_YELLOW + "\n AVVISO: REGISTRO E' PIENO, NON PUOI AGGIUNGERE ALTRI STUDENTI!" + TEXT_RESET);
					}
					break;
					
				case 2:
					if(registro.getNumeroStudenti() > 0)									// Controllo prima se il registro è vuoto o meno.
					{
						registro.visualizzaRegistro();
					}
					else
					{
						System.out.println(TEXT_YELLOW + "\n AVVISO: IL REGISTRO E' VUOTO, PER FAVORE AGGIUNGI PRIMA DEGLI STUDENTI!" + TEXT_RESET);
					}
					break;
					
				case 3:
					System.out.println(TEXT_GREEN + "\n ARRIVEDERCI!" + TEXT_RESET);
					break;
					
				default:
					System.out.println(TEXT_RED + "\n ERRORE: SCELTA NON CONSENTITA, PER FAVORE SCEGLI UNA TRA LE OPZIONI DISPONIBILI!" + TEXT_RESET);
					break;
			}

		} while (sceltaMenu != 3);
		
		scannerN.close();
		scannerS.close();
	}

}
