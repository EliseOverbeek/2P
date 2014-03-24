package protocol;
/**
 * <p>
 * Enumeratie van foutmeldingen die de server naar de client kan sturen via de
 * methode <tt>error(Error)</tt>. Als er een error opgetreden heeft dan wordt de verbinding met de server verbroken.
 * Een standaard beschrijving van de fout kan worden verkregen met
 * <tt>toString()</tt>.
 * </p>
 * <p>
 * Let op: enums worden automatisch aangemaakt en kunnen daarna behandeld worden
 * als constantes, zoals <tt>Error.DEFAULT</tt>. Het heeft geen zin om de
 * constructor aan te roepen.
 * </p>
 * 
 * @author Paul Velthuis
 * @version 20140312
 * het opsturen van een ongeldig aantal spelers zal ook moeten resulteren in het kicken van de client net als het opsturen van onbekende commando's.
 */
public enum Error {INVALID_MOVE("Ongeldige zet"), INVALID_NAME("Ongeldige naam"), INVALID_PLAYERS("Ongeldig aantal spelers"),
 UNKNOWN_COMMAND("Onbekend commando"), WINNER("Je kan geen zet meer doen"), DEFAULT("Error");
 
 /**
	 * Beschrijving van de foutmelding
	 */
	private final String beschrijving;
	
	
	/**
	 * Interne constructor voor het initialiseren van de enum-objecten.
	 * 
	 * @param beschrijving
	 *            Beschrijving van de foutmelding
	 *
	 */
	private Error( String beschrijving) {
		this.beschrijving = beschrijving;
	}
	
	/**
	 * Geeft een beschrijving van de foutmelding
	 * 
	 * @return De beschrijving van de foutmelding
	 */
	public String toString() {
		return beschrijving;
	}
}