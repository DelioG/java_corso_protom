package esercizioLibreria;

public enum GenereLibro {

	GIALLO    ("Questo è un libro giallo, di trama non di colore."),
	ROMANZO   ("Questo è un romanzo"),
	FANTASY   ("Questa è un libro fantasy"),
	BIOGRAFIA ("Questa è una biografia");
	
	private final String descrizione;
	
	private GenereLibro(String descrizione) {
		this.descrizione = descrizione;
	}

	/* ----------------- */
	/* GETTERS & SETTERS */
	/* ----------------- */
	
	public String getDescrizione() {
		return descrizione;
	}
	
}