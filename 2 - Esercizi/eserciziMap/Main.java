package eserciziMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// Scrivi un programma Java che conta quante volte ciascuna parola appare in una data stringa.

public class Main {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

// 		NUMERO 1
//		Map<String, Integer> mappaOccorrenze = new HashMap<>();
//		
//		
//		// Prendo la frase in input
//		System.out.print("Inserisci una frase: ");
//		String frase = scanner.nextLine();
//		
//		
//		// Rimuovo tutti i caratteri speciali, come virgole e punti.
//		// Converto tutte le parole in lowercase.
//		// Ed infine rimuovo gli spazi e separo le parole.
//		frase  = frase.replaceAll("[^a-zA-Z0-9]", " ");
//		frase  = frase.toLowerCase();
//		String parole[] = frase.split("\\s+");
//		
//		
//		for(String parola : parole)
//		{
//			if(!mappaOccorrenze.containsKey(parola)) 	// Inserisco la parola nella mappa.
//			{
//				mappaOccorrenze.put(parola, 1);
//			}
//			else 										// Aggiorno il valore dell'occorrenza
//			{
//				mappaOccorrenze.put(parola, mappaOccorrenze.get(parola) + 1);
//			}
//		}
//		
//		
//		System.out.println(mappaOccorrenze);


		

		
//		NUMERO 2
//		
//		Map<Character, Integer> mappaOccorrenzeLettere = new HashMap<>();
//		
//		
//		// Prendo la frase in input
//		System.out.print("Inserisci una frase: ");
//		String frase = scanner.nextLine();
//		
//		
//		// Rimuovo tutti i caratteri speciali, come virgole e punti.
//		// Converto tutte le parole in lowercase.
//		// Rimuovo gli spazi e separo le parole.
//		// Inserisco in un array di char tutti i caratteri della frase.
//		frase = frase.replaceAll("[^a-zA-Z0-9]", " ");
//		frase = frase.toLowerCase();
//		frase = frase.replaceAll("\\s", "");
//		char[] lettere = frase.toCharArray();
//		
//		for(char lettera : lettere)
//		{
//			if(!mappaOccorrenzeLettere.containsKey(lettera)) 	// Inserisco la parola nella mappa.
//			{
//				mappaOccorrenzeLettere.put(lettera, 1);
//			} 
//			else 												// Aggiorno il valore dell'occorrenza
//			{
//				mappaOccorrenzeLettere.put(lettera, mappaOccorrenzeLettere.get(lettera) + 1);
//			}
//		}
//		
//		// Questa parte l'ho trovata su internet -> Map.Entry<Character, Integer>.
//		for (Map.Entry<Character, Integer> entry : mappaOccorrenzeLettere.entrySet()) {
//		      System.out.println("Chiave: [" + entry.getKey() + "] | Valore: [" + entry.getValue() + "].");
//		}
//		

		scanner.close();
	}

}
