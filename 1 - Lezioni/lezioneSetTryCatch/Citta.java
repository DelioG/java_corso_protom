package lezioneSetTryCatch;

public enum Citta {
	
	// Gli enumerati si utilizzano per gestire informazioni costanti, precedentemente decise.
	// Per convenzione l'enumerato va sempre scritto in stampatello.
	
	BELLIZZI ("84092", 123456789),
	MARANO_DI_NAPOLI ("80016", 123456789),
	BATTIPAGLIA("84091", 123456789);
	
	private final String cap;
	private final Integer numeroPop;
	
	Citta(String cap, Integer numeroPop) {
		this.cap = cap;
		this.numeroPop = numeroPop;
	}
	
	public String cap() {
		return this.cap;
	}
	
	// Con gli enumerati non si usa get()
	public Integer numeroPop() {
		return this.numeroPop;
	}
	
}