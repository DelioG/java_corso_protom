package lezioneSetTryCatch;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Persona studente = new Studente("Mattia", "Iovine", 28, Citta.BATTIPAGLIA, "NMAAA", "Inf");
//		System.out.println("CAP CITTA STUDENTE: " + studente.getCitta().cap());
//		System.out.println("POP CITTA STUDENTE: " + studente.getCitta().numeroPop());
//		
//		System.out.println(Citta.MARANO_DI_NAPOLI.cap())
//		System.out.println(Citta.MARANO_DI_NAPOLI.numeroPop());
//		
//		String inputCittaUtente = "Battipaglia";
//		String stampatello = inputCittaUtente.toUpperCase();
//		
//		if(stampatello.equals(Citta.BATTIPAGLIA.name())) {
//			Citta cittaDiAppartenenza = Citta.valueOf(stampatello); // Restituisce un enum avente come nome quello passato dal metodo.
//			Persona p1 = new Studente("Mattia", "Iovine", 28, Citta.valueOf(stampatello), "NMAAA", "Inf");
//		}
		
		// L'interfaccia set consente la creazione di una lista che non ammette duplicati.
		// Non ha metodi per l'ordinamento.
		// L'implementazione più "famosa" / "utilizzata" è l'HashSet.
		
		Set<Persona> listaDiPersone = new HashSet<>();
//		listaDiPersone.add(studente);
//		
//		for(Persona p : listaDiPersone)
//			if(p.equals(studente))
//				listaDiPersone.remove(p);
//		
//		try {
//			// Vanno inserite tutte le "istruzioni" e "chiamate a metodi" che lanciano una eccezione.
//			// 
//			Studente studente2 = new Studente("Mattia", "Iovine", 28, Citta.MARANO_DI_NAPOLI, "NMAAA", "Inf");
//			studente2.controlloMatricola();
//			
//		} catch(MatricolaTooShortException istanzaDiMiaEccezione) {
//			// Nelle parentesi del catch va messo il nome dell'eccezione che viene lanciata nel try
//			// E le si da un nome, nel nostro caso "istanzaDiMiaEccezione".
//			// Nel caso di più eccezioni vanno messe tutte.
//			// Esempio -> catch(MatricolaTooShortException istanzaDiMiaEccezione, IlliegalArgumentException istanzaDiMiaEccezione2)
//		
//			// Invece nel blocco catch vanno inserite le istruzioni qualora venga "catturata" una eccezione. 
//			// Cosa fare quando viene lanciata una eccezione? Si può...
//			// 1 - Continuar a far andare il programma.
//			// 2 - Far morire il programma, esempio con "System.exit(1);".
//			
//			// Se non si inscerisce nulla nel blocco catch viene stampato lo stack trace di errore, e passa alla prossima istruzione dopo il catch. Il programma continua...
//			
//			System.out.println(istanzaDiMiaEccezione.getMessage());
//			System.out.println("Il processo continua");
//			System.exit(1);
//		}
		
		try {
			Studente studente2 = new Studente("Mattia", "Iovine", 28, Citta.MARANO_DI_NAPOLI, "NMAAA", "Inf");
			studente2.controlloMatricola2();
			
		} catch(IllegalArgumentException istanzaDiMiaEccezione) {
			istanzaDiMiaEccezione.printStackTrace();
			System.out.println("Il programma continua");
		}
		
		System.out.println("Sono ancora vivo!");
	}

}
