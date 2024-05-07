package eserciziVari;

import java.util.*;

public class Cicli {

	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		Cicli cicli = new Cicli();
		cicli.inputArray();

	}

	// Somma dei primi dieci numeri interi positivi
	public void cicloFor() {
		int somma = 0;
		for (int i = 0; i <= 10; i++) {
			somma = somma + i;
		}
		System.out.println("La somma dei primi dieci numeri naturali è: " + somma);
	}

	// Tabellina del 5
	public void cicloWhile() {
		int num = 5;
		while (num != 51) {
			if (num % 5 == 0)
				System.out.println(num);
			num++;
		}
	}
	
	public void doWhile() {
		int num = 0, count=0, somma=0;
		System.out.println("Digita i numeri di cui vuoi avere la media.");
		System.out.println("Digita un numero negativo per uscire.");
		System.out.println("-------------------------------------------");
		
		do {
			System.out.print("Digita un numero intero positivo: ");
			num = scanner.nextInt();
			if(num>0) {
				count++;
				somma = somma + num;
			}
		} while(num>0);
		
		System.out.println("La media è: " + somma/count);
		
	}

	public void inputArray() {
		
		int[] arrayInteri = new int[5];
		
		for(int i=0; i<arrayInteri.length; i++) {
			System.out.print("Digita un numero: ");
			arrayInteri[i] = scanner.nextInt();
		}
		
		for(int i=0; i<arrayInteri.length; i++) {
			System.out.println("Posizione n. " + i + ": " + arrayInteri[i]);
		}
		
	}
}
