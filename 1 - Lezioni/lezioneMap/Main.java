package lezioneMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Map<Integer, Persona> mappaDiNomi = new HashMap<>();
		Map<Integer, Integer> mappaDiInteri = new HashMap<>();

		Persona mattia = new Persona();
		Persona davide = new Persona();

		/* INSERT, GET, DELETE, SOSTITUZIONE */
		mappaDiNomi.put(1, mattia); 										// add
		mappaDiNomi.put(2, davide);

		mappaDiNomi.get(1); 												// get sulla "key" restituisce -> mattia
		Boolean esisteKey = mappaDiNomi.containsKey(1); 					// restituisce true o false se la mappa contiene la chiave
																			// specificata
		Boolean esisteValore = mappaDiNomi.containsValue(200); 				// restituisce true o false se la mappa contiene il value
																			// specificato

		mappaDiNomi.remove(1, mattia); 										// remove per coppia K-V
		mappaDiNomi.remove(1); 												// remove per k
		Integer oldValue = mappaDiInteri.replace(1, 300);					// .set() rimpiazza la chiave esistente con il nuovo valore,
																			// restituisce il vecchio valore
		mappaDiInteri.replace(2, 20, 300); 									// rimpiazza per la chiave il vecchio valore con il nuovo

		/* INSIEME DELLE CHIAVI, INSIEME DEI VALORI */
		Set<Integer> valoreDelleKey = mappaDiNomi.keySet(); 				// restituisce tutte le "chiavi" in un set -> 1,2
		Collection<Persona> listaDeiValori = mappaDiNomi.values(); 			// restituisce tutti i "values" -> mattia, davide

		/* CICLO FOR CON KEYSET e VALUES */
		for (Integer k : valoreDelleKey) {
			if (k == 1) {
				System.out.println(mappaDiNomi.get(1));
			}
		}

		for (Persona p : listaDeiValori) {

		}

		/* OPERAZIONI CONDIZIONALI */
		mappaDiInteri.putIfAbsent(3, 200); 									// se la chiave 3 non esiste la crea con valore 200

		mappaDiInteri.computeIfAbsent(3, k -> 200); 						// sarebbe come fare mappaDiInteri.put(3, 200);

		mappaDiInteri.computeIfPresent(2, (k, v) -> v + 1); 				// se la chiave 2 esiste aumenta il valore del "value" di 1
		mappaDiInteri.computeIfPresent(2, (chiave, valore) -> chiave + 3); 	// se la chiave 2 esiste aumenta il valore
																			// della "chiave" di 3

	}

}
