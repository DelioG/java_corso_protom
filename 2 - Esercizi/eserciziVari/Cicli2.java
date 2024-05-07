package eserciziVari;

import java.util.Scanner;

public class Cicli2 {
	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		int numeroDiVolteDaIterare = scanner.nextInt();
//
//		while (numeroDiVolteDaIterare != 0) {
//			System.out.println("Sono ancora nel while");
//			numeroDiVolteDaIterare--;
//		}
//		
//		System.out.println("Sono fuori dal while.");
//		scanner.close();

//		Scanner tastiera2 = new Scanner(System.in);
//		System.out.println("Inserire età, solo i maggiorenni posso accedere: ");
//
//		int eta = tastiera2.nextInt();
//
//		while (eta >= 18 && eta != 100) {
//			System.out.println("Sei maggiorenne, puoi essere qui");
//		}
//
//		tastiera2.close();
//		System.out.println("Non sei maggiorenne, tornatene a casa");

//		Scanner tastiera2 = new Scanner(System.in);
//		System.out.println("Inserire età, solo i maggiorenni posso accedere: ");
//		int eta = tastiera2.nextInt();
//		
//		do {
//			System.out.println("Sono nel copro del DO");
//			eta--;
//		} while (eta >= 18 && eta != 100);
//
//		System.out.println("Sono fuori dal DO/WHILE");
//		tastiera2.close();
		// Differenze tra while e do/while: 1) Il while gestisce sia la condizione che
		// il corpo con le istruzioni
		// 2) Il do/while controlla la veridicità della condizione SOLO DOPO CHE E'
		// AVVENUTA LA PRIMA ITERAZIONE,
		// il while invece controlla la condizione PRIMA CHE PARTA LA PRIMA ITERAZIONE

		Scanner tastiera3 = new Scanner(System.in);
		int scelta = 0;

//		do {
//			System.out.println("Benvenuto! Scegli la tua opzione: \n1) Salutami\n2) Mandami un bacio\n3) Esci.");
//			scelta = tastiera3.nextInt();
//			
//			if (scelta == 1)
//				System.out.println("Ciao!");
//			else if (scelta == 2)
//				System.out.println("SMACK");
//			else if (scelta != 3)
//				System.out.println("Scelta anon valida, ripetere!");
//			
//		} while (scelta != 3);
//		
//		System.out.println("A presto!");
//
//		tastiera3.close();

		do{
			switch(scelta) {
				case 1:
					System.out.println("Ciao!");
					break;
				case 2:
					System.out.println("Smack!");
					break;
				case 3:
					System.out.println("A presto!");
					break;
				default:
						break;
			}
		} while(scelta!=3);
		
	}
}