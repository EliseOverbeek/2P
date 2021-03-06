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
	
	private final int DIM = 9;
	private final int DIMPART = 3;
	private ArrayList<ArrayList<Field>> fields;
	
	/**
	 * 	Maakt een bord aan met velden
	 */
	public Board()	{
		fields = new ArrayList<ArrayList<Field>>();
		for (int y=0; y<DIM; y++)	{
			fields.add(y,new ArrayList<Field>());
			for (int x=0; x<DIM; x++)	{
				fields.get(y).add(x, new Field());
			}
		}
	}
	
	/**
	 * Vul een bepaald veld met de meegegeven waarde color
	 * @param y < DIM && y >=0
	 * @param x < DIM && x >=0
	 * @param color < 4 && field >=0
	 */
	public void fillField(int x, int y, int color)	{
		fields.get(y).get(x).fillField(color);
	}
	
	/**
	 * Kijkt of een bepaald veld leeg is of niet 
	 * @param y < DIM && y >=0
	 * @param x < DIM && x >=0
	 * @return TRUE als het veld leeg is, False als het veld bezet is
	 */
	public boolean checkField(int x, int y)	{
		return fields.get(y).get(x).isEmpty();
	}
	
	/**
	 * Draai een deel van het bord de meegegeven kant op
	 * @param y >= 0
	 * @param x >= 0
	 * @param rotation is een char die door middel van 'l' aangeeft dat fieldArea links moet omkeren en door middel van 'r' aangeeft dat fieldArea recht moet omkeren
	 */
	public void rotate(int x, int y, char rotation)	{
		ArrayList<ArrayList<Field>> temporaryFields = fields;
		if(rotation == 'l')	{
			for (int i = y; i < DIMPART; i++)	{
				for (int j = x; j < DIMPART; j++)	{
					
				}
				i++;
			}
		}
		else	{
			for (int i = y; i < DIMPART; i++)	{
				for (int j = x; j < DIMPART; j++)	{
					
				}
				i++;
			}
		}
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
/*	public boolean horizontalWinner()	{
		boolean winner = false;
		int line = 0;
		ArrayList<Field> value = fields;
		while(line < 9 && winner == false)	{
			int starter = 0;
			while(starter < 5 && winner == false)	{
				int firstValue = value.get(starter).getColor();
				if(firstValue != 0)	{
					int pointer = 0;
					boolean theSame = true;
					while(pointer < 5 && theSame == true)	{
						theSame = value.get(pointer).getColor() == value.get(pointer++).getColor();
					}
					winner = theSame;
				}
				starter++;
			}
			line++;
		}
		return winner;
	}
*/
	/**
	 * Controleerd of er 5 elementen op een rij van dezelfde kleur en verticaal zijn
	 * @return TRUE als er 5 elementen van dezelfde kleur verticaal zijn, FALSE als er geen 5 elementen van dezelfde kleur verticaal zijn
	 */	
	public boolean verticalWinner()	{
		return false;
	}
}