package eserciziVari;

import java.util.Scanner;
import java.util.Arrays;

public class EserciziStringhe {

	public static void main(String[] args) {
		
		Scanner scanner           = new Scanner(System.in);
		Scanner scannerScelta     = new Scanner(System.in);
		EserciziStringhe esercizi = new EserciziStringhe();
		
		System.out.println("---------------------------------------------");
		System.out.println("		MENU DI SCELTA                       ");
		System.out.println("---------------------------------------------");
		System.out.println("1 - Conteggio vocali in una stringa          ");
		System.out.println("2 - Controllo palindromo                     ");
		System.out.println("3 - Controllo anagaramma                     ");
		System.out.println("4 - Stampa numeri interi pari a partire da 50");
		System.out.println("---------------------------------------------");
		
		System.out.print("Fai la tua scelta: ");
		int scelta = scannerScelta.nextInt();
		System.out.println("---------------------------------------------");
		
		switch(scelta)
		{
			case 1:
				
				System.out.print("Inserisci una stringa: ");
				String stringaV = new String(scanner.nextLine());
				System.out.println("Il numero delle vocali è: " + esercizi.numeroVocali(stringaV));
				break;
				
			case 2:
				
				System.out.print("Inserisci una stringa: ");
				String stringaP = new String(scanner.nextLine());
				
				if(esercizi.isPalindromo(stringaP.toLowerCase().replaceAll("\\s", "")))
				{
					System.out.println("La stringa è palindroma.");
				}
				else
				{
					System.out.println("La stringa non è palindroma.");
				}
				
				break;
			
			case 3:
				
				System.out.print("Inserisci una stringa: ");
				String stringa1 = new String(scanner.nextLine());
				
				System.out.print("Inserisci una seconda stringa: ");
				String stringa2 = new String(scanner.nextLine());
				
				if(esercizi.isAnagramma(stringa1.toLowerCase(), stringa2.toLowerCase()))
				{
					System.out.println("E' un'anagramma.");
				}
				else
				{
					System.out.println("Non è un'anagramma.");
				}
									
				break;
			
			case 4:
				
				esercizi.numeriInteriPari();
				break;
				
			default:
				
				System.out.println("Scelta non disponibile, per favore riavvia il programma.");
				break;
		}
		
		scanner.close();
		scannerScelta.close();
	}
	
	// A - Conta le vocali presenti in una stringa.
	public int numeroVocali(String vocali)
	{
		int numVocali = 0;
		
		for(int i=0; i<vocali.length(); i++)
		{
			if( vocali.charAt(i) == 'a'
				|| vocali.charAt(i) == 'e'
				|| vocali.charAt(i) == 'i' 
				|| vocali.charAt(i) == 'o'
				|| vocali.charAt(i) == 'u')
			{
				numVocali++;
			}
		}
		
		return numVocali;
	}
	
	// B - Parole palindrome -> osso, esse, aerea, aveva, esose.
	public boolean isPalindromo(String stringa)
	{
		// Avvio un ciclo all'incontraio, partendo dalla lunghezza della stringa -1.
		// Creo una stringa concatenando la stringaR con il char presnete alla iesima posizione.
		// In sostanza è come se "ribaltasse" la stringa. Come se la riscostruisse all'incontrario.
		// Se le due stringhe sono uguali allora sono palindrome.
		
		
		String stringaR = new String();
		
		for(int i=stringa.length()-1; i>=0; i--)
			stringaR = stringaR + stringa.charAt(i);
		
		if(stringa.equals(stringaR))
			return true;
		else
			return false;
	}
	
	// C - Anagrammi -> Roma, Orma, Amor.
	public boolean isAnagramma(String string1, String string2)
	{
		// Prima convertiamo le stringhe in array di char.
		// Utilizzando il metodo sort della classe Arrays, ordiniamo l'array di caratteri.
		// Infine controlliamo se i due array sono uguali. Se si, le due stringhe sono anagrammi, altrimenti no.
		
		char[] c1 = string1.replaceAll(" ", "").toLowerCase().toCharArray();
		char[] c2 = string2.replaceAll(" ", "").toLowerCase().toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		if(Arrays.equals(c1, c2))
			return true;
		else
			return false;
		
	}
	
	// D - Stampa i numeri interi pari partendo da 50 fino ad arrivare a 0.
	public void numeriInteriPari() 
	{	
		for(int i=50; i>0; i--) 
		{
			if(i%2==0)
				System.out.print(i + " ");
		}
	}
	
}