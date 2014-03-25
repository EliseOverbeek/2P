package model;

/**
 * Stone. Klasse voor het bijhouden van het aantal stenen dat een speler nog
 * heeft. Eindproject PentagoXL Programmeren 2
 * 
 * @author Elise Overbeek en Peter Beers
 * @version $Revision: 1.0 $
 */

public class Stones {
	private int stoneAmount;

	/**
	 * klasse waarin de knikkers van een speler worden bijgehouden.
	 * 
	 */

	public void Stones() {
		// bij het aanmaken van de stenen is nog niet altijd bekend hoeveel
		// stenen er zijn. Daarom begin je met 0 stenen.
		stoneAmount = 0;
	}

	public void setStoneAmount(int StoneAmount) {
	
		stoneAmount = StoneAmount;
	}

	public boolean removeStone() {
		boolean gelukt = false; // het verwijderen van de steen is (nog) niet
								// gelukt.

		if (stoneAmount > 0) {
			// verwijderen van de steen lukt, tel er 1 af en geef terug dat het
			// gelukt is.
			stoneAmount--;
			gelukt = true;
		}

		return gelukt;
	}

}
