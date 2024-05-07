package eserciziVari;

public class StrutturaDati {

	public static void main(String[] args) {

		int[] arrayInteriPrecaricati = { 70, 130, 125, 120, 30 };
		int max = 0, min = arrayInteriPrecaricati[0];

		for (int i = 0; i < arrayInteriPrecaricati.length; i++) {
			if (arrayInteriPrecaricati[i] > max) {
				max = arrayInteriPrecaricati[i];
			}
			
			if(arrayInteriPrecaricati[i] < min) {
				min = arrayInteriPrecaricati[i];
			}
		}

		System.out.println("Il numero più grande è : " + max);
		System.out.println("Il numero più piccolo è: " + min);

	}

}