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

	// / /**
	// * Bepaalt het vakje voor de volgende zet.
	// * @require <code>bord != null && !bord.isVol()</code>
	// * @ensure <code>bord.isVakje(result) && bord.isLeegVakje(result)</code>
	// * @param bord het spelersbord
	// * @return keuze van het vakje van deze Speler
	//
	// public abstract int bepaalZet(Bord bord);
	// */

	// commands-------------------------------------------------------------------


	// takeTurn(field : int, board : board) : String (Dit is een regel die volgens het protocol van een zet is. (updateField))
	public String takeTurn(Board b) {
		//for default players (opponents), no set turn can be taken locally.
		return "";
	}

	
	// takeTurn() : boolean
	public boolean takeStone() {
		return this.stones.removeStone();
	}

	public int getColorNumber(){
		return this.color;
	}
	
	// setGameValues(color : int, stones : int) : void
	public void setGameValues(int color, int stones) {
		this.color = color;
		this.stones.setStoneAmount(stones);
	}

}
