/*
 	- Si creino le classi Prodotto, Televisore e Smartphone. 
	- Un televisore è caratterizzato da marca, modello, prezzo, numero di pollici e un booleano che indica se è smartTv o meno;
	- Uno smartphone è caratterizzato da marca, modello, prezzo, sistema operativo, anno di produzione e gb di ram.
	
	- Oggi è il black friday e il venditore applica lo sconto del 20% a tutte le tv e del 30 % a tutti gli smartphone.
	
	Rispettare il seguente caso d’uso:
		- Prodotto tvLg = new Televisore("LG", "nuovo", 1000, 48, true);
		- Prodotto umidigi = new Smartphone("Umidigi", "F2", 250, "Android 10.0", 6, "2020");
		
		- tvLg.applicaSconto();
		- umidigi.applicaSconto();
		
	- Creiamo la classe Carrello dove inseriremo i prodotti acquistati dal cliente.
	- Ogni cliente può acquistare massimo 10 prodotti. Se si tenta di acquistare l’11 prodotto verrà stampata a video un messaggio di errore.
	- Se il totale del carrello supera i 2500 euro il venditore applica un ulteriore sconto del 5%.
	- Il metodo acquista applica gli sconti previsti dal black friday.
*/
package gestioneNegozio;

import java.util.Scanner;

public class Main {

	public static final String TEXT_RESET  = "\u001B[0m";
	public static final String TEXT_GREEN  = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_RED    = "\u001B[31m";
	
	public static void main(String[] args) {

		
		// CREAZIONE DEGLI OGGETTI
		Carrello carrello = new Carrello();
		
		Prodotto tv1 = new Televisore("LG",      "LG1", 100, 48, true );
		Prodotto tv2 = new Televisore("Samsung", "SM1", 120, 32, false);
		Prodotto tv3 = new Televisore("LG",      "LG2", 250, 50, true );
		Prodotto tv4 = new Televisore("Samsung", "SM2", 320, 32, false);
		Prodotto tv5 = new Televisore("LG",      "LG3", 500, 45, true );
		Prodotto tv6 = new Televisore("Samsung", "SM3", 2600, 45, true );
		
		Prodotto sp1 = new Smartphone("Samsung", "S10",       500, "Android 10.0", 6, "2023");
		Prodotto sp2 = new Smartphone("Samsung", "S11",       750, "Android 10.0", 2, "2022");
		Prodotto sp3 = new Smartphone("Apple",   "iPhone X",  500, "Android 10.0", 3, "2022");
		Prodotto sp4 = new Smartphone("Apple",   "iPhone 11", 750, "Android 10.0", 1, "2021");
		Prodotto sp5 = new Smartphone("Xiaomi",  "11",        350, "Android 10.0", 6, "2022");
		Prodotto sp6 = new Smartphone("Xiaomi",  "12",        500, "Android 10.0", 6, "2022");
		
		
		// AGGIUNTA DEI PRODOTTI AL CARRELLO
		tv1.applicaSconto(20.0);
		carrello.aggiungiProdotto(tv1);
		tv2.applicaSconto(20.0);
		carrello.aggiungiProdotto(tv2);
		tv3.applicaSconto(20.0);
		carrello.aggiungiProdotto(tv3);
		tv4.applicaSconto(20.0);
		carrello.aggiungiProdotto(tv4);
		tv5.applicaSconto(20.0);
		carrello.aggiungiProdotto(tv5);
		
		sp1.applicaSconto(30.0);
		carrello.aggiungiProdotto(sp1);
		sp2.applicaSconto(30.0);
		carrello.aggiungiProdotto(sp2);
		sp3.applicaSconto(30.0);
		carrello.aggiungiProdotto(sp3);
		sp4.applicaSconto(30.0);
		carrello.aggiungiProdotto(sp4);
		sp5.applicaSconto(30.0);
		carrello.aggiungiProdotto(sp5);
		
		// STAMPA DELL'ERRORE CARRELLO PIENO
		sp6.applicaSconto(30.0);
		carrello.aggiungiProdotto(sp6);
		
		// STAMPA DEL CARRELLO
		System.out.println("\n ------------------------------------------------------------");
		carrello.visualizzaCarrello();
		
	}

}
