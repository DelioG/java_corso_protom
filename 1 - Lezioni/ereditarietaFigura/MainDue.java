package ereditarietaFigura;
import java.util.Scanner;

public class MainDue {
	
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		
		// Input lato - Quadrato n.1
		System.out.print("Inserisci il lato del quadrato n.1 : ");
		Integer lato1 = scanner.nextInt();
		
		// Input lato - Quadrato n.2
		System.out.print("Inserisci il lato del quadrato n.2 : ");
		Integer lato2 = scanner.nextInt();
		
		Quadrato q1 = new Quadrato("Quadrato", lato1);
		Quadrato q2 = new Quadrato("Quadrato", lato2);
		
		System.out.println("L'area del quadrato n.1 è: " + q1.calcolaArea());
		System.out.println("L'area del quadrato n.2 è: " + q2.calcolaArea());
		
		scanner.close();
	}
	
}