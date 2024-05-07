package esercizioLibreria;
 import Exceptions.*;
import java.util.Scanner;

public class Main {
	
	public static final String TEXT_RESET  = "\u001B[0m";
	public static final String TEXT_GREEN  = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_RED    = "\u001B[31m";
	
	public static void main(String[] args) {

		Scanner scannerN  = new Scanner(System.in); 		// Scanner per numeri.
		Scanner scannerS  = new Scanner(System.in); 		// Scanner per stringhe.
		Libreria libreria = new Libreria();
		int sceltaMenu = 0;

		do {
			
			System.out.println("\n ---------------- " + TEXT_YELLOW + "MENU" + TEXT_RESET +" -----------------");
			System.out.println(" [" + TEXT_YELLOW + "1" + TEXT_RESET + "] | AGGIUNGI AUTORE					  ");
			System.out.println(" [" + TEXT_YELLOW + "2" + TEXT_RESET + "] | AGGIUNGI LIBRO					  ");
			System.out.println(" [" + TEXT_YELLOW + "3" + TEXT_RESET + "] | RIMUOVI LIBRO				 	  ");
			System.out.println(" [" + TEXT_YELLOW + "4" + TEXT_RESET + "] | CERCA LIBRO PER TITOLO			  ");
			System.out.println(" [" + TEXT_YELLOW + "5" + TEXT_RESET + "] | CERCA LIBRI PER C.F. DELL'AUTORE  ");
			System.out.println(" [" + TEXT_YELLOW + "6" + TEXT_RESET + "] | VISUALIZZA ELENCO AUTORI		  ");
			System.out.println(" [" + TEXT_YELLOW + "7" + TEXT_RESET + "] | VISUALIZZA ELENCO LIBRI			  ");
			System.out.println(" [" + TEXT_YELLOW + "8" + TEXT_RESET + "] | STAMPA CATALOGO LIBRI			  ");
			System.out.println(" [" + TEXT_YELLOW + "9" + TEXT_RESET + "] | ESCI							  ");
			System.out.println(" ---------------------------------------  ");
			System.out.print  (TEXT_YELLOW + " LA TUA SCELTA" + TEXT_RESET + ": ");
			sceltaMenu = scannerN.nextInt();
			
			switch(sceltaMenu) {
			
			// AGGIUNTA DI UN AUTORE AL SET DEGLI AUTORI
				case 1:
					try
					{
						System.out.print(" INSERISCI IL NOME DELL'AUTORE: ");
						String nomeAutore = scannerS.nextLine().toUpperCase();
						
						System.out.print(" INSERISCI IL COGNOME DELL'AUTORE: ");
						String cognomeAutore = scannerS.nextLine().toUpperCase();
						
						System.out.print(" INSERISCI IL CODICE FISCALE DELL'AUTORE: ");
						String cf2 = scannerS.nextLine().toUpperCase();
						
						libreria.aggiungiAutore( libreria.creazioneAutore(nomeAutore, cognomeAutore, cf2) );
					}
					catch(AutoreGiaEsistenteException e)
					{
						System.out.println(TEXT_RED + " L'AUTORE E' GIA' STATO INSERITO NEL DATABASE" + TEXT_RESET);
					}
					break;
				
				// AGGIUNTA DI UN LIBRO
				case 2:
					try
					{
						libreria.checkIfZeroAutori();		// Controllo prima che ci siano degli autori inseriti, altrimenti non faccio inziare proprio l'inserimento.
						
						Autore autore        = null;		// A questo oggetto di tipo Persona assegnerò il valore dell'autore a cui appartiene il c.f.
						Boolean genereIsGood  = false;		// Utilizzato per verificare se il genere inserito dall'utente è valido.
						GenereLibro genere    = null;		// A questo enum assegnerò il valore del genere del libro scelto dall'utente.
						
						
						System.out.print(" DIGITA IL TITOLO DEL LIBRO CHE VUOI INSERIRE: ");
						String titoloLibro = scannerS.nextLine().toUpperCase();
						
						System.out.print(" DIGITA IL CODICE FISCALE DELL'AUTORE DEL LIBRO: ");
						String cf1 = scannerS.nextLine().toUpperCase();
						
						
						// In questo foreach mi occupo di controllare se il codice fiscale inserito 
						// risulta essere presente nel nostro set di autori.
						// Se presente, procedo a creare un oggetto di tipo "Persona" con gli attributi 
						// appartenenti all'autore proprietario del codice fiscale inserito dall'utente.
						// Gli attributi vengono dunque recuperati direttamente dal set di autori.
						
						for(Persona a : libreria.getAutori())													
						{																						
							if(a.getCodiceFiscale().equals(cf1))												
							{																					
								autore = new Autore(a.getNome(), a.getCognome(), a.getCodiceFiscale());			
							}
						}
						
						// Faccio scegliere all'utente il genere del libro.
						do
						{
							System.out.print(" SCEGLI IL GENERE DEL LIBRO: 1 [GIALLO], 2 [ROMANZO], 3 [FANTASTY], 4 [BIOGRAFIA]. -> ");
							Integer genereLibro = scannerN.nextInt();
							
							if(genereLibro <= 0 || genereLibro > 4)
							{
								System.out.println(TEXT_RED + " PER FAVORE SCEGLI DI LIBRO UN GENERE VALIDO!" + TEXT_RESET);
							}
							else
							{
								if(genereLibro == 1) 
								{
									genere = GenereLibro.GIALLO;
								} 
								else if(genereLibro == 2) 
								{
									genere = GenereLibro.ROMANZO;
								} 
								else if(genereLibro == 3) 
								{
									genere = GenereLibro.FANTASY;
								} 
								else if(genereLibro == 4) 
								{
									genere = GenereLibro.BIOGRAFIA;
								}
								
								genereIsGood = true;
							}
							
						} while(!genereIsGood);
						
						
						// Procedo creando il libro con i dati inseriti dall'utente.
						Libro libro = new Libro(titoloLibro, autore, genere);
						
						// Passo il libro alla funzione aggiungiLibro(), e dopo gestisco eventuali eccezioni.
						libreria.aggiungiLibro(libro);
					}
					catch(ZeroAutoriException e)
					{
						System.out.println(TEXT_RED + " NON CI SONO AUTORI NEL NOSTRO DATABASE, PER FAVORE INSERISCI PRIMA DEGLI AUTORI." + TEXT_RESET);
					}
					catch(AutoreNonTrovatoException e)
					{
						System.out.println(TEXT_RED + " L'AUTORE INSERITO NON E' STATO TROVATO." + TEXT_RESET);
					}
					break;
				
				// RIMOZIONE DI UN LIBRO
				case 3:
					try
					{
						libreria.checkIfLiberiraIsVuota();
						
						System.out.print(" INSERISCI IL TITOLO DEL LIBRO CHE VUOI RIMUOVERE: ");
						String nomeLibroDaRimuovere = scannerS.nextLine().toUpperCase();
						
						libreria.rimuoviLibro(nomeLibroDaRimuovere);
					}
					catch(LibroNonTrovatoException e)
					{
						System.out.println(TEXT_RED + " LIBRO NON TROVATO ALL'INTERNO DEL DATABASE" + TEXT_RESET);
					}
					catch(LibreriaVuotaException e)
					{
						System.out.println(TEXT_RED + " LIBRERIA E' VUOTA" + TEXT_RESET);
					}
					break;

				// CERCA LIBRO PER TITOLO
				case 4:
					try
					{
						libreria.checkIfLiberiraIsVuota();
						
						System.out.print(" INSERISCI IL TITOLO DEL LIBRO: ");
						String titolo = scannerS.nextLine().toUpperCase();
						
						libreria.cercaLibroPerTitolo(titolo);
					} 
					catch(LibroNonTrovatoException e)
					{
						System.out.println(TEXT_RED + " LIBRO NON TROVATO" + TEXT_RESET);
					}
					catch(LibreriaVuotaException e)
					{
						System.out.println(TEXT_RED + " LIBRERIA VUOTA" + TEXT_RESET);
					}
					break;
					
				// CERCA LIBRI IN BASE AL C.F. DELL'AUTORE
				case 5:
					try
					{
						libreria.checkIfLiberiraIsVuota();
						
						System.out.print(" CERCA LIBRI PER C.F. AUTORE: ");
						String cf3 = scannerS.nextLine().toUpperCase();
						
						libreria.cercaLibriPerCodiceFiscale(cf3);
					}
					catch(LibreriaVuotaException e)
					{
						System.out.println(TEXT_RED + " LIBRERIA VUOTA" + TEXT_RESET);
					}
					catch(AutoreNonTrovatoException e)
					{
						System.out.println(TEXT_RED + " AUTORE NON TROVATO" + TEXT_RESET);
					}
					catch(LibroNonTrovatoException e)
					{
						System.out.println(TEXT_RED + " NESSUN LIBRO TROVATO PER IL CODICE FISCALE INSERITO" + TEXT_RESET);
					}
					break;
					
				// VISUALIZZA ELENCO DEGLI AUTORI PRESENTI NEL SET "AUTORI"
				case 6:
					try
					{
						libreria.visualizzaAutori();
					}
					catch(SetAutoriVuotoException e)
					{
						System.out.println(TEXT_RED + " NON SONO PRESENTI AUTORI NEL DATABASE" + TEXT_RESET);
					}
					break;
					
				// VISUALIZZA ELENCO DI TUTTI I LIBRI ED I RELATIVI DETTAGLI
				case 7:
					try
					{
						libreria.visualizzaLibreria();
					}
					catch(LibreriaVuotaException e)
					{
						System.out.println(TEXT_RED + " LIBRERIA VUOTA" + TEXT_RESET);
					}
					break;
				
				// STAMPA DEL CATALOGO DEI LIBRI
				case 8:
					libreria.visualizzaCatalogo();
					break;
					
				// USCITA DAL PROGRAMMA
				case 9:
					System.out.println(TEXT_GREEN + " ARRIVEDERCI! " + TEXT_RESET);
					break;
				
				// GESTIONE DI ALTRI EVENTI NUMERICI
				default:
					System.out.println(TEXT_RED + " SCELTA NON CONSENTITA" + TEXT_RESET);
					break;
					
			}
			
			System.out.println("\n");
			
		} while(sceltaMenu != 9);
		
		scannerN.close();
		scannerS.close();
	}

}