package eserciziVari;

public class Calcolatrice {

	public Calcolatrice() {

	}

	public void somma(float num1, float num2) {
		float somma = num1 + num2;
		System.out.println("La somma è: " + somma + "\n");
	}

	public void differenza(float num1, float num2) {
		float differenza = num1 - num2;
		System.out.println("La differenza è: " + differenza + "\n");
	}

	public void prodotto(float num1, float num2) {
		float prodotto = num1 * num2;
		System.out.println("Il prodotto è: " + prodotto + "\n");
	}

	public void quoziente(float num1, float num2) {
		float quoziente = num1 / num2;
		System.out.println("Il quoziente è: " + quoziente + "\n");
	}

}