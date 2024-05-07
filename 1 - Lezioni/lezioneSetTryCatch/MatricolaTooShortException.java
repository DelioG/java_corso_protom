// L'eccezione è una classe come le altre.
// Estende la classe Exception di Java.
// CREARE UN PACKAGE CONTENENTE TUTTE LE EXCEPTION.

package lezioneSetTryCatch;

public class MatricolaTooShortException extends Exception {

	// msg ce l'ha di base exception.
	// Infatti passa al padre la variabile msg.
	
	public MatricolaTooShortException(String msg) {
		super(msg);
	}
	
}
