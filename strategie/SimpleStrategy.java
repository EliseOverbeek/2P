package strategie;

import model.Board;

public class SimpleStrategy {
	private String name = "SimpleStrategy";

	public SimpleStrategy(String name){
		this.name = name;
	}
		
	public String getName(){
		return name;
	}
	
	public String getBestMove(Board board){
		return name + " " + pickField(board) + " " + makeTurn(board);
	}
	
	
	private String pickField(Board board){
		int x = 0;
		int y = 0;
		for (int i = 0; i < board.getNumberofFields; i++){
			if (board.checkField(i) == true){
				x = board.fieldGetX(i);
				y = board.fieldGetY(i);
			}
		}
		return x + " " + y + "";
	}
	
	private String makeTurn(Board board){
		//Bereken de beste kansen, maar voor nu draaien we het middelste van naar links
		return "5 links";
	}
}
