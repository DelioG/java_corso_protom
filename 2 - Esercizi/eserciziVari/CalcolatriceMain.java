package eserciziVari;

import java.util.*;

public class CalcolatriceMain {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Calcolatrice calcolatrice = new Calcolatrice();

		int scelta = 0;
		float num1 = 0;
		float num2 = 0;

		do {
			System.out.println("---------------------------------------");
			System.out.println("            CALCOLATRICE               ");
			System.out.println("---------------------------------------");
			System.out.print("Inserisci il primo numero  : ");
			num1 = scanner.nextInt();
			System.out.print("Inserisci il secondo numero: ");
			num2 = scanner.nextInt();
			System.out.println("-------------------------------------");

			System.out.println("1 - (+) Somma");
			System.out.println("2 - (-) Differenza");
			System.out.println("3 - (*) Prodotto");
			System.out.println("4 - (/) Quoziente");
			System.out.println("5 - Esci");
			System.out.println("-------------------------------------");
			System.out.print("Scegli tra le opzioni disponibili: ");
			scelta = scanner.nextInt();

			switch (scelta) {
			case 1:
				calcolatrice.somma(num1, num2);
				break;
			case 2:
				calcolatrice.differenza(num1, num2);
				break;
			case 3:
				calcolatrice.prodotto(num1, num2);
				break;
			case 4:
				calcolatrice.quoziente(num1, num2);
				break;
			case 5:
				System.out.println("Hai scelto di terminare l'esecuzione!");
				scelta = 5;
				break;
			default:
				System.out.println("Per favore inserisci un'opzione valida!");
				break;
			}

		} while (scelta != 5);

		scanner.close();
		
	}
}