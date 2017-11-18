package jiVickieRoom;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class VickieFrontEnd implements JiSupport{

	private VickieSupport backend;
	private String input;
	private String grid;
	
	public static final void main(String[] args){
		VickieFrontEnd game = new VickieFrontEnd();
		game.startGame();
	}
	
	public VickieFrontEnd() {
		backend = new JiBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
		
	}

	public void startGame() {
		directions();
		CaveExplorer.print("Which coordinates do you want to put a number in?");
		input = CaveExplorer.in.nextLine();
		placeNumbers(input);
	}

	private void placeNumbers(String nums) {
		int len = nums.length();
		 if(len > 5 || len <5) {
			 CaveExplorer.print("Which coordinates do you want to put a number in?");
		 }
		
	}

	public void directions() {
		CaveExplorer.print("Welcome to Magic Squares! Play in order to ...... (we'll fill it in later).....");
		CaveExplorer.print("");
		CaveExplorer.print("The Rules:");
		CaveExplorer.print("	You're given a grid of nine boxes. ");
		CaveExplorer.print("	You must fill in the boxes with numbers 1-9.");
		CaveExplorer.print("	In each row, column, and diagonal, the sum of the numbers must be 15.");
		CaveExplorer.print("	To fill in a particular box, tell us the coordinates of that box, and the number you want to be in it.");
		CaveExplorer.print("		Ex: 1,2,8 --> the row, the column, and the number // maybe front end:????????????????????????????????");
		CaveExplorer.print("");
		CaveExplorer.print("When you're ready to play, press enter!");
		CaveExplorer.in.nextLine();
		JiVickieBoard[][] magicSquares = backend.getBoxes();
		displayTheGrid(magicSquares);
	}

	public void displayTheGrid(JiVickieBoard[][] magicSquares) {
		CaveExplorer.print(" ________ ________ ________ ");
		String rows = "0123456789";
		String columns = "  0123456789";
		
		for(int row = 0; row < 9; row++)
		{
			System.out.print("|");
			if (row == 2 || row == 5 || row == 8)
			{
				for(int col = 0; col < 3; col++)
				{
						System.out.print("________|");
				}
			}else
			{
				if (row == 1 || row == 4 || row == 7)
				{
					for(int col = 0; col < 3; col++)
					{
							System.out.print("    X   |");
					}
				} else {
					for(int col = 0; col < 3; col++)
					{
							System.out.print("        |");
					}
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		CaveExplorer.print("");

	}
	
}
	

			
	
	/*public void setNumber(int row, int col, int num)
	/*public void fixedNumbersInBox() {
		// TODO Auto-generated method stub
	}

	
	public void gameDialogue() {
		
	}
	
	public void endGame() {
		
	}*/


	/*public static void userEntered() {
		JiBackEnd.createTheBox();
		
	}


	@Override
	public void backgroundStory() {
		// TODO Auto-generated method stub
		
	}*/
	

/*
 * 1) Game starts
 * 2) Provide the rules
 * 3) Game starts:
 * 		a grid of nine boxes are created,
 * 		ask the user which coordinates they want to place a number in, and ask what number they want to type;
 * 		put it in
 * 
 * 		if all the nine slots are filled, ask wheether we should check if its correct
 * 
 * 		and reward is.....
 * 
 * 
 * 
 * 		STORYYY: ...... unknown
 * 
 * 		innovate: if they have the correct number in the correct place something magical will happen
 */
//

