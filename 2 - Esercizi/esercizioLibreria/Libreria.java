package esercizioLibreria;
 import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Libreria {

	ArrayList<Libro> libri = new ArrayList<>();
	Set<Autore> autori = new HashSet<>();
	Map<Libro, Autore> catalogoLibri = new HashMap<>();
	
	public Libreria() {
		
	}
	
	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public ArrayList<Libro> getLibri() {
		return libri;
	}
	
	public void setLibri(ArrayList<Libro> libri) {
		this.libri = libri;
	}
	
	public Set<Autore> getAutori() {
		return autori;
	}
	
	public void setAutori(Set<Autore> autori) {
		this.autori = autori;
	}
	
	/* ------------ */
	/* ALTRI METODI */
	/* ------------ */
	
	public void checkIfZeroAutori() throws ZeroAutoriException {
		if(autori.size() <= 0) {
			throw new ZeroAutoriException("Non ci sono autori");
		}
	}
	
	public void checkIfLiberiraIsVuota() throws LibreriaVuotaException {
		if(libri.size() <= 0) {
			throw new LibreriaVuotaException("La libreria è vuota");
		}
	}
	
	public void aggiungiLibro(Libro libro) throws AutoreNonTrovatoException 
	{
		Boolean autoreTrovato = false;
		
		for(Autore a : autori)
		{
			if(a.equals(libro.getAutore()))								// Se trovo un autore che ha è "equals" all'autore del libro che è stato passato nella firma del metodo...
			{
				autoreTrovato = true;
				libri.add(libro);
				a.setnLibriScritti( a.getnLibriScritti() + 1 );
				System.out.println(Main.TEXT_GREEN + " LIBRO AGGIUNTO CORRETTAMENTE!" + Main.TEXT_RESET);		
				
				// Aggiungo il libro e l'autore al map di catalogo libri.
				catalogoLibri.put(libro, a);
				
				break;
			}
		}
		
		if(!autoreTrovato)												// Se non è stato trovato alcun autore che condivide il nome con quello del libro lancio una Exception.	
		{
			throw new AutoreNonTrovatoException("Autore non trovato.");
		}
	}

	public void setCatalogoLibri(Map<Libro, Autore> catalogoLibri) {
		this.catalogoLibri = catalogoLibri;
	}

	public void rimuoviLibro(String titolo) throws LibroNonTrovatoException, LibreriaVuotaException 
	{
		
		if(libri.size() <= 0)										// Controllo prim se la libreria è vuota o meno...
		{
			throw new LibreriaVuotaException("Libreria vuota");
		}
		else
		{
			int i = 0;
			Boolean libroTrovato = false;
			
			for(Libro l : libri) 										// Se la libreria non è vuota, inizio a ciclare l'arraylist di libri
			{
				if(l.getTitolo().equals(titolo))						// Sino a quando non trovo il libro con lo stesso titolo.
				{
					libroTrovato = true;
					libri.remove(i);
					l.getAutore().setnLibriScritti( l.getAutore().getnLibriScritti() - 1 );	// Non funziona per qualche motivo...
					System.out.println(Main.TEXT_GREEN + " LIBRO RIMOSSO CORRETTAMENTE!" + Main.TEXT_RESET);
					break;
				}
				i++;
			}
			
			if(!libroTrovato)											// Se non è stato trovato alcun libro che condivide il nome con quello del libro lancio una Exception.
			{
				throw new LibroNonTrovatoException("Libro non trovato.");
			}
		}
		
	}
	
	public Autore creazioneAutore(String nomeAutore, String cognomeAutore, String codiceFiscale) 
	{
		Autore autore = new Autore(nomeAutore, cognomeAutore, codiceFiscale);
		return autore;
	}
	
	public void aggiungiAutore(Autore autore) throws AutoreGiaEsistenteException 
	{
		if(autori.size() > 0)			// Controllo se il set possiede già qualche autore...
		{
			for(Autore a : autori)		// Se si, controllo se l'autore è già stato inserito...
			{
				if(a.getCodiceFiscale().equals(autore.getCodiceFiscale()))	// Se è già stato inserito lancio una Exception.
				{
					throw new AutoreGiaEsistenteException("Autore già esistente");
				}
			}
			
			autori.add(autore);			// Se non c'è procedo ad inserirlo
			System.out.println(Main.TEXT_GREEN + " AUTORE AGGIUNTO CORRETTAMENTE!" + Main.TEXT_RESET);
		}
		else if(autori.size() == 0)		// Se non ci sono autori nel set, è inutile che eseguo il controllo, procedo ad aggiungere direttamente l'autore.
		{
			autori.add(autore);
			System.out.println(Main.TEXT_GREEN + " AUTORE AGGIUNTO CORRETTAMENTE!" + Main.TEXT_RESET);
		}
	}
	
	public void cercaLibroPerTitolo(String titolo) throws LibroNonTrovatoException, LibreriaVuotaException 
	{
		if(libri.size() <= 0)
		{
			throw new LibreriaVuotaException("Libreria vuota");
		}
		else
		{
			Boolean libroTrovato = false;
			
			for(Libro l : libri)
			{
				if(l.getTitolo().equals(titolo))						// Se trovo nell'arraylist un libro che condivide lo stesso titolo con quello passato nella firma del metodo.
				{
					System.out.println(" " + l.toString());					// Procedo a stampare i suoi dettagli.
					libroTrovato = true;
				}
			}
			
			if(!libroTrovato)
			{
				throw new LibroNonTrovatoException("Libro non trovato.");
			}
		}
	}
	
	public void cercaLibriPerCodiceFiscale(String codiceFiscale) throws LibroNonTrovatoException, LibreriaVuotaException, AutoreNonTrovatoException 
	{
		
		if(libri.size() <= 0)
		{
			throw new LibreriaVuotaException("Libreria vuota");
		}
		else
		{
			Boolean autoreTrovato = false;
			Boolean libroTrovato  = false;
			
			for(Persona a : autori)
			{
				if(a.getCodiceFiscale().equals(codiceFiscale))					// Se il codice fiscale dell'autore della corretne iterazione è uguale a quello inserito dall'utente...
				{
					autoreTrovato = true;
					for(Libro l : libri)
					{
						if(l.getAutore() instanceof Autore && l.getAutore().getCodiceFiscale().equals(codiceFiscale))
						{
							System.out.println(l.toString());
							libroTrovato = true;
						}
					}
				}
			}
			
			if(!autoreTrovato)
			{	
				throw new AutoreNonTrovatoException("Autore non trovato.");
			}
			
			if(!libroTrovato)
			{
				throw new LibroNonTrovatoException("Libro non trovato.");
			}
		}
		
	}
	
	public void visualizzaLibreria() throws LibreriaVuotaException
	{
		if(libri.size() <= 0) 
		{
			throw new LibreriaVuotaException("Non ci sono libri nel nostro database.");
		} 
		else 
		{
			int i = 1;	
			System.out.println(" CI SONO N [" + Main.TEXT_YELLOW + libri.size() + Main.TEXT_RESET + "] LIBRI IN LIBRERIA.");
			
			for(Libro l : libri) 
			{
				System.out.println(" " + Main.TEXT_YELLOW + i + Main.TEXT_RESET+ " - " + l.toString());
				i++;
			}
			
		}
	}
	
	public void visualizzaAutori() throws SetAutoriVuotoException
	{
		if(autori.size() <= 0) 
		{
			throw new SetAutoriVuotoException("Non sono presenti autori nel set.");
		} 
		else 
		{
			int i = 1;
			System.out.println(" CI SONO N [" + Main.TEXT_YELLOW + autori.size() + Main.TEXT_RESET + "] AUTORI NEL NOSTRO DATABASE.");
			
			for(Persona a : autori) 
			{
				System.out.println(" " + Main.TEXT_YELLOW + i + Main.TEXT_RESET+ " - " + a.toString());
				i++;
			}
		}
	}
	
	public void visualizzaCatalogo() {
		for (Map.Entry<Libro, Autore> entry : catalogoLibri.entrySet())
		{
		      System.out.println(" TITOLO LIBRO: [" + entry.getKey().getTitolo() 
		    		  			+ "] | NOME AUTORE: ["  + entry.getValue().getNome() + " " 
		    		  			+ entry.getValue().getCognome() + "].");
		}
	}
	
}