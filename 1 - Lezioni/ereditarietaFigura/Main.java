/*
 * 	Crea due classi Figura e Quadrato. Figura ha un attributo String nome e un metodo calcolaArea(). 
 * 	Quadrato ha 1 attributo Integer Lato, e sovrascrive il metodo calcolaArea(). 
 * 	calcolaArea() restituisce un Integer che rappresenta il valore dell'area calcolata moltiplicando il lato per se stesso. 
 * 	Creare i getter e i setter che servono per risolvere l'esercizio.
 * 	Nel main richiamare il metodo stampaArea() su un 2 oggetti Quadrato diversi aventi uno lato 2 e l'altro lato 4
 */

package ereditarietaFigura;

public class Main {

	public static void main(String[] args) {
		
		Figura q1 = new Quadrato("Quadrato", 2);
		Quadrato q2 = new Quadrato("Quadrato", 4);
		
		System.out.println("L'area del quadrato n.1 è: " + q1.calcolaArea());
		System.out.println("L'area del quadrato n.2 è: " + q2.calcolaArea());

	}

}