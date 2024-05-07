/*
 * 	Crea una classe Automobile con un metodo avvia(). 
 * 	Crea due classi AutoSportiva e AutoFamiliare figlie di Automobile che sovrascrivono il metodo avvia() 
 * 	che stampa il messaggio "Automobile avviata!".
 * 	per Automobile, "Auto sportiva avviata!" per AutoSportiva e "Auto familiare avviata!" per AutoFamiliare.
 * 	Nel main creare un array di tipo Automobile che contiene sia oggetti AutoSportiva che AutoFamiliare e 
 * 	attraverso un ciclo for chiamare il metodo avvia() per tutte le auto nell'array.
 */
package ereditarietaAutomobile;

public class Main {

	public static void main(String[] args) {
		
		Automobile a1 = new AutoSportiva();
		Automobile a2 = new AutoFamiliare();
		Automobile a3 = new AutoSportiva();
		Automobile a4 = new AutoFamiliare();
		
		Automobile[] automobili = new Automobile[] {a1, a2, a3, a4};
		
		for(int i=0; i<automobili.length; i++) {
			automobili[i].avvia();
		}
		
	}

}