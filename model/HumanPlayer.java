package model;

/**
 * HumanPlayer. Klasse voor het bijhouden van een menselijke speler
 * subklasse van Player. 
 * Eindproject PentagoXL 
 * Programmeren 2
 * @author  Elise Overbeek en Peter Beers
 * @version $Revision: 1.0 $
 */

public class HumanPlayer extends Player {

	
	public HumanPlayer(String name) {
		super(name);
	}

	
	public String takeTurn(Board b) {
		//for default players (opponents), no set turn can be taken locally.
		//PSEUDO"
		//misschien krijgt de speler ook al wel automatisch een seintje, wanneer de eigen speler aan de beurt is.
		return "todo remove";
		/* return  een functie aanroepen die de GUI activeerd, om een set terug te krijgen van de menselijke speler. */
	}
	
}





   

