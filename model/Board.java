package model;
import java.util.ArrayList;

/**
 * Board. Klasse die een bord bijhoudt voor het spel met Field objecten
 * Eindproject PentagoXL Programmeren 2
 *
 * @author Elise Overbeek en Peter Beers
 * @version $Revision: 1.0 $
 */

public class Board {
	
	private ArrayList<Field> fields;
	
	/**
	 * 	Maakt een bord aan met velden
	 */
	public Board()	{
		fields = new ArrayList<Field>();
		while (fields.size() <81)	{
			fields.add(new Field());
		}
	}
	
	/**
	 * Vul een bepaald veld met de meegegeven waarde color
	 * @param field <= 81 && field >=0
	 * @param color <= 4 && field >=0
	 */
	public void fillField(int field, int color)	{
		fields.get(field).fillField(color);
	}
	
	public boolean checkField(int field)	{
		boolean check = false;
		if()
		return check;
	}
	
	public void rotate(int fieldArea, char rotation)	{
		
	}
	
	public boolean diagonalWinner()	{
		return false;
	}
	
	public boolean horizontalWinner()	{
		return false;
	}
	
	public boolean verticalWinner()	{
		return false;
	}
}