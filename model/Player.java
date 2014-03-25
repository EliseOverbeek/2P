package model;

/**
 * Player. Klasse voor het bij houden van een speler. Eindproject PentagoXL
 * Programmeren 2
 * 
 * @author Elise Overbeek en Peter Beers
 * @version $Revision: 1.0 $
 */

public abstract class Player {

	// -- Instance variables -----------------------------------------
	protected String name;
	private Stones stones;
	private int color;

	// -- Constructors -----------------------------------------------

	/**
	 * Construeert een nieuw Speler object.
	 * 
	 * @require <code>name != null</code> <br>
	 * 
	 * @ensure <code>this.getNaam() == name</code><br>
	 *         <code>this.getStones() == stones</code><br>
	 */
	public Player(String name) {
		this.name = name;
		this.stones = new Stones();
		this.color = 999; //nog bepaald
	}

	// -- Queries ----------------------------------------------------

	/**
	 * Levert de naam van deze Speler.
	 */
	protected String getName() {
		return name;
	}



	// commands-------------------------------------------------------------------


	// takeTurn(field : int, board : board) : String (Dit is een regel die volgens het protocol van een zet is. (updateField))
	public String takeTurn(Board b) {
		//for default players (opponents), no set turn can be taken locally.
		return "";
	}

	
	// takeTurn() : boolean
	/**
	 * 
	 */
	public boolean takeStone() {
		return this.stones.removeStone();
	}

	/**
	 * 
	 * @return the colornumber that this player is playing with
	 */
	public int getColorNumber(){
		return this.color;
	}
	
	// setGameValues(color : int, stones : int) : void
	/**
	 * method to initialize values for the game.
	 * the color a player is player with and the amount of stones of the that color that the player gets. 
	 * the amount must be 20 or 40. 
	 */
	public void setGameValues(int color, int stones) {
		this.color = color;
		this.stones.setStoneAmount(stones);
	}

}
