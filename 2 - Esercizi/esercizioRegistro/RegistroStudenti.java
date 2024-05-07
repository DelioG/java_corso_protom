package esercizioRegistro;

public class RegistroStudenti {

	public static final String TEXT_RESET  = "\u001B[0m";
	public static final String TEXT_GREEN  = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	
	private Studente[] studenti;
	private Integer numeroStudenti;

	public RegistroStudenti(Integer nMaxStudenti)
	{
		numeroStudenti = 0;
		studenti = new Studente[nMaxStudenti];
	}
	
	/* GETTERS & SETTERS */
	public Studente[] getStudenti() 
	{
		return studenti;
	}

	public void setStudenti(Studente[] studenti) 
	{
		this.studenti = studenti;
	}

	public Integer getNumeroStudenti() 
	{
		return numeroStudenti;
	}

	public void setNumeroStudenti(Integer numeroStudenti) 
	{
		this.numeroStudenti = numeroStudenti;
	}
	
	/* ALTRI METODI */

	public void aggiungiStudente(String nome, int voto, String classe)
	{
		for (int i = 0; i < studenti.length; i++)
		{
			if (studenti[i] == null) 										// Avvio un ciclo, e prendo la prima posizione disponibile (non occupata).
			{
				Studente studente = new Studente(nome, voto, classe);
				studenti[i] = studente;
				numeroStudenti++;											// Aumento il counter degli studenti presenti nel registro.
				System.out.println(TEXT_GREEN + "\n STUDENTE AGGIUNTO!" + TEXT_RESET);
				break;														// Una volta aggiunto lo studente interrompo il ciclo for.
			}
		}
	}
	
	public void visualizzaRegistro()
	{
		System.out.println("\n IL REGISTRO CONTIENE NUMERO [" + numeroStudenti + "] STUDENTI.");
		
		for(int i=0; i<studenti.length; i++)
		{
			if(studenti[i] != null)											// Senza if mi da errore: "can't invoke method because element is null".
				studenti[i].visualizzaDettagli();
		}
	}
	
}