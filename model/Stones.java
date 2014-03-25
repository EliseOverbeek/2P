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
	 * constructor for the class Stones initialize the value of stones at 0
	 * 
	 */
	public void Stones() {
		// bij het aanmaken van de stenen is nog niet altijd bekend hoeveel
		// stenen er zijn. Daarom begin je met 0 stenen.
		stoneAmount = 0;
	}

	/**
	 * Method to set the amount of stones a player has
	 * 
	 * @param StoneAmount
	 */
	public void setStoneAmount(int StoneAmount) {

		stoneAmount = StoneAmount;
	}

	/**
	 * 
	 * @return wether or not the removal of a stone from the total stone amount
	 *         was succesful.
	 */
	public boolean removeStone() {
		boolean removal = false; // het verwijderen van de steen is (nog) niet
									// gelukt.

		if (stoneAmount > 0) {
			// verwijderen van de steen lukt, tel er 1 af en geef terug dat het
			// gelukt is.
			stoneAmount--;
			removal = true;
		}

		return removal;
	}

}
