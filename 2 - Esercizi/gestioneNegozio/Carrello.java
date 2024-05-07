package gestioneNegozio;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotto> carrello;
	private double totaleCarrello = 0;

	public Carrello() {
		super();
		this.carrello = new ArrayList<>(10);
	}

	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public ArrayList<Prodotto> getCarrello() {
		return carrello;
	}

	public void setCarrello(ArrayList<Prodotto> carrello) {
		this.carrello = carrello;
	}
	
	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */
	
	public boolean carelloIsFull() {
		
		if(carrello.size() < 10)
			return false;
		else 
			return true;
		
	}

	public void aggiungiProdotto(Prodotto prodotto) {
		
		if(!carelloIsFull())			// Prima di aggiungere il prodotto al carrello controllo se quest'ultimo è già pieno.
		{
			carrello.add(prodotto);
			System.out.println(Main.TEXT_GREEN + " AVVISO: PRODOTTO AGGIUNTO AL CARRELLO!" + Main.TEXT_RESET);
		}
		else
		{
			System.out.println(Main.TEXT_RED + " ERRORE: IL CARRELLO E' PIENO!" + Main.TEXT_RESET);
		}
		
	}
	
	public Double getTotale() {
		double totale = 0;
		
		for(Prodotto p : carrello)
		{
			totale = totale + p.getPrezzo();
		}
		
		return totale;
	}
	
	public boolean checkUlterioreSconto() {
		
		// Controllo se il totale del carrello è > 2500.
		if(getTotale() > 2500)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void visualizzaCarrello() {
		
		int i = 1;
		
		if(carrello.size() != 0)	// Controllo prima se il carrello è vuoto, se non lo è...
		{
			System.out.println(" CI SONO [" + carrello.size() + "] PRODOTTI NEL CARRELLO");
			
			for(Prodotto p : carrello)
			{
				System.out.println(" " + p.toString());
				
				i++;
			}
						
			if(checkUlterioreSconto())
			{			
				System.out.println(Main.TEXT_GREEN + "\n ULTERIORE SCONTO APPLICATO!" + Main.TEXT_RESET);
				double sconto = (this.totaleCarrello * 5) / 100;
				this.totaleCarrello = this.totaleCarrello - sconto;
				System.out.println(" IL TOTALE E': " + getTotale() + "€");
			}
			else
			{
				System.out.println(Main.TEXT_RED + "\n ULTERIORE SCONTO NON APPLICATO!" + Main.TEXT_RESET);
				System.out.println(" IL TOTALE E': " + getTotale() + "€");
				
			}
			
		}
		else						// Il carrello è vuoto.
		{
			System.out.println(Main.TEXT_RED + " ERRORE: IL CARRELLO E' VUOTO!" + Main.TEXT_RESET);
		}
		
	}
	
}
