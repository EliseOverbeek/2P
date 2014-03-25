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
	/**
	 * Kijkt of een bepaald veld leeg is of niet 
	 * @param field is een integer voor een bepaald veld
	 * @return TRUE als het veld leeg is, False als het veld bezet is
	 */
	public boolean checkField(int field)	{
		boolean check = false;
		if(fields.get(field).isEmpty())	{
			check = true;
		}
		return check;
	}
	
	/**
	 * Draai een deel van het bord de meegegeven kant op
	 * @param fieldArea is een int van 0 t/m 8 die een bepaald gedeelte van het bord representeerd
	 * @param rotation is een char die door middel van 'l' aangeeft dat fieldArea links moet omkeren en door middel van 'r' aangeeft dat fieldArea recht moet omkeren
	 */
	public void rotate(int fieldArea, char rotation)	{
		int[] area = fieldsArea(fieldArea);
		int areaPoint = 0;
		while (areaPoint < 9)	{
			// slimme implementatie nog voor verzinnen
		}
	}
	
	/**
	 * Maakt een lijst aan met daarin de velden van een bepaal gebied
	 * @param fieldArea < 9 && fieldArea >=0
	 * @return een array
	 */
	private int[] fieldsArea(int fieldArea)	{
		int[] area = new int[9];
		int pointer = 0;
		int lastfield;
		
		if (fieldArea < 3)	{
		lastfield = fieldArea * 3;	
		}
		else if (fieldArea < 6)	{
		lastfield = (27 + (fieldArea - 3) * 3);	
		}
		else	{
		lastfield = (54 + (fieldArea - 3) * 3);
		}
		area[pointer] = lastfield;
		pointer++;
		
		//code technisch verbeteren
		while (pointer < area.length)	{
			area[pointer] = lastfield++;
			area[pointer] = lastfield++;
			area[pointer] = lastfield + 7;
			area[pointer] = lastfield++;
			area[pointer] = lastfield++;
			area[pointer] = lastfield + 7;
			area[pointer] = lastfield++;
			area[pointer] = lastfield++;
		}
		return area;
	}
	
	/**
	 * Controleerd of er 5 elementen op een rij van dezelfde kleur en diagonaal zijn
	 * @return TRUE als er 5 elementen van dezelfde kleur diagonaal zijn, FALSE als er geen 5 elementen van dezelfde kleur diagonaal zijn
	 */
	public boolean diagonalWinner()	{
		return false;
	}

	/**
	 * Controleerd of er 5 elementen op een rij van dezelfde kleur en horizontaal zijn
	 * @return TRUE als er 5 elementen van dezelfde kleur horizontaal zijn, FALSE als er geen 5 elementen van dezelfde kleur horizontaal zijn
	 */
	public boolean horizontalWinner()	{
		int[] line = new int[5];
		
	}

	/**
	 * Controleerd of er 5 elementen op een rij van dezelfde kleur en verticaal zijn
	 * @return TRUE als er 5 elementen van dezelfde kleur verticaal zijn, FALSE als er geen 5 elementen van dezelfde kleur verticaal zijn
	 */	
	public boolean verticalWinner()	{
		return false;
	}
}