package model;

/**
 * Field. Klasse die een spelvakje bijhoudt en weet of deze stenen bevat of niet. 
 * Eindproject PentagoXL Programmeren 2
 *
 * @author Elise Overbeek en Peter Beers
 * @version $Revision: 1.0 $
 */

public class Field {
	
	private int color;
	
	/**
	 * Maakt een nieuw leeg Field object aan.
	 */
	public Field()	{
		this.color = 0;
	}
	
	/**
	 * Verandert de waarde van de instantie variabele door param color.
	 * @param color => 0 AND color =< 4
	 */
	public void fillField(int color)	{
		this.color = color;
	}
	
	/**
	 * Kijkt of de instantie variabele leeg is of niet
	 * @return
	 */
	public boolean isEmpty()	{
		boolean empty = true;
		if(this.color >= 1 && this.color <= 4){
			empty = false;
		}
		return empty;
	}
	
}
