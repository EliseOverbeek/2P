package strategie;

import model.Board;
import model.Player;


public class AIPlayer extends Player {

	private SimpleStrategy strategy; 
	public AIPlayer(String name) {
		super(name);
		this.strategy = new SimpleStrategy(name + "AI");
	}

	
	public String takeTurn(Board board) {
		//for default players (opponents), no set turn can be taken locally.
		
		return this.strategy.getBestMove(board);
		/* return  een functie aanroepen van simplestrategy. */
	}

	
}