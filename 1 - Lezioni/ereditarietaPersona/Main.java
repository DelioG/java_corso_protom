// Ereditarietà e Polimorfismo (Override - Overload)
// L'override si riferisce ai metodi di due classi differenti.
// L'overload invece, si riferisce a due metodi della stessa classe.

// Se creo student = new student: ho a disposizione tutti i metodi che sono inseriti sia in studente che in persona.
// Se creo persona = new student: ho a disposizione i solo i metodi in comune.
// Se creo persona = new persona: ho a disposizione solo i metodi di persona.

// L'override si crea con l'annotation @Override, ed è relativo ad un metodo del figlio che esiste anche nella classe padre, 
// che ha stessa visibilità, tipo di ritorno, nome e parametri in ingresso.
// L'overload NON usa annotations, è relativo a due o più metodi della stessa classe, e prende in considerazione il nome del metodo, 
// mentre i paramentri di ingresso, la visibilità e il tipo di ritorno possono essere diversi.
// Annotazione Ovveride -> sovrascrivere. Sovrascrive il metodo salutami() della classe Persona.

/*
	Esercizi:
		Crea due classi Figura e Quadrato. 
		- Figura ha un attributo String nome e un metodo calcolaArea(). 
		- Quadrato ha 1 attributo Integer Lato, e sovrascrive il metodo calcolaArea(). 
		  CalcolaArea() restituisce un Integer che rappresenta il valore dell'area calcolata moltiplicando il lato per se stesso. 
		- Creare i getter e i setter che servono per risolvere l'esercizio. 
		- Nel main richiamare il metodo stampaArea() su 2 oggetti Quadrato diversi aventi uno lato 2 e l'altro lato 4.
*/
package ereditarietaPersona;

public class Main {

	public static void main(String[] args) {

		Persona p1 = new Persona();
		Persona p2 = new Persona("Delio", "Graziano", 25);
		Persona p3 = new Studente("Delio", "Graziano", 25, "123", "Informatica");
		Studente s1 = new Studente("Delio", "Graziano", 25, "123", "Informatica");
		
		p1.salutami();
		p2.salutami();
		p3.salutami();
		
		s1.stampaColore("rosso");
		System.out.println(s1.stampaColore(1, 2, 3));
		
	}

}
