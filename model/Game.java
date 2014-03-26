package model;

/**
 * Game. Klasse die een spel beheert met een aantal spelers en een bord
 * Eindproject PentagoXL Programmeren 2
 *
 * @author Elise Overbeek en Peter Beers
 * @version $Revision: 1.0 $
 */
public class Game {

	private Board board;
	
	/**
	 * Maakt een spel aan met een bord
	 */
	public Game()	{
		this.board = new Board();
	}
	
	/**
	 * Controleer of een zet geldig is voor een meegegeven veld
	 * @param y >= 0
	 * @param x >= 0
	 * @return TRUE als het veld leeg is, False als het veld bezet is
	 */
	public boolean checkMove(int x, int y)	{
		return board.checkField(x, y);
	}
	
	/**
	 * Vul een bepaald veld met de meegegeven waarde color
	 * @param y >= 0
	 * @param x >= 0
	 * @param color < 4 && field >=0
	 */
	public void doMove(int x, int y, int color)	{
		board.fillField(x, y, color); 
	}
	
	public void rotateFields(int x, int y, char rotation)	{
		board.rotate(x, y, rotation);
	}
}
