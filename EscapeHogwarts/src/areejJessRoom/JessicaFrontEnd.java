package areejJessRoom;


import caveExplorer.CaveExplorer;


import java.util.Scanner;

public class JessicaFrontEnd implements AreejSupport{

	private AreejBackEnd backend;
	
	
	public JessicaFrontEnd() {
		backend = new AreejBackEnd(this);
	}

	public static void main(String[] args) {
		
		JessicaFrontEnd demo = new JessicaFrontEnd();
		demo.play();
	}

	private static String getUserInput()
	{
		 String input = CaveExplorer.in.nextLine().toLowerCase();
		 return input;
	}
	
	private void play() {
		new JessicaIntro().play();
		CaveExplorer.in.nextLine();
		menu();
	}

	private void menu() {
		System.out.println("Enter 'r' for rules or 'p' to play.");
		String userInput = waitForLetterInput("rp");
		if(userInput.equals("r")){
			print("Place Galleons by choosing a column from 0 to 6. Input the number of the column you want to place your "
					+ "Galleons in. If you get FOUR in a row, either horizontally, vertically, or diagonally, you win. If not, I win."
					+ "You get all the Galleons you placed down if you win. Let the best player win! Press enter to start!");
			CaveExplorer.in.nextLine();
			menu();
		}else{
			startGame();
		}
		
	}

	private void startGame() {
		AreejJessBoard[][] board = backend.getBoard();
		displayBoard(board);
		System.out.println("Where would you like to place your Galleon? Pick a number from 0 to 6.");
		if(checkValid(getUserInput()))
		{
			displayMove();
		}
		else
		{
			getBadRes();
		}
		
		
	}

	

	private void getBadRes() {
		String[] badRes = {"That's not correct,", "Please try again!", "Follow the rules!"};
		System.out.println(badRes[(int)Math.random()*2]);
	}

	private void displayMove() {
		// TODO Auto-generated method stub
		
	}

	private boolean checkValid(String userInput) {
		// TODO Auto-generated method stub
		return false;
	}

	private void displayBoard(AreejJessBoard[][] board) {
		
		String columns = "0 1 2 3 4 5 6 ";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()){
					if(plots[row][col].containsTreasure()){
						System.out.print("X");
					}else{
						System.out.print(" ");	
					}

				}else{
					System.out.print(".");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
		
	}

	public static String waitForLetterInput(String letters){
		String input = getUserInput();
		while(input.length() <1 || letters.toLowerCase().indexOf(input.toLowerCase().substring(0, 1))<0){
			System.out.print("That entry is not allowed. Please type one of the following: ");
			String list = "";
			for(int i = 0 ; i < letters.length()-1; i++){
				list += letters.substring(i, i+1)+",";
			}
			list += " or "+letters.substring(letters.length()-1); 
			System.out.println(list);
			input = getUserInput();
		}
		return input.toLowerCase().substring(0, 1);
	}
	
	public static void print(String s){
		//create a multi-line String
		String printString = "";
		int cutoff = 55;
		//check to see if there are words to add
		//(IOW, is the length of s > 0
		while(s.length() > 0){
			String currentLine = "";
			String nextWord = "";
			//while the currentLine and nextWord are less
			//than the cuttoff, AND there are still 
			//words to add do the following loop
			while(currentLine.length() + 
					nextWord.length() <= cutoff &&
					s.length() > 0){
				//add the next word to the line
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				//get the following word
				int endOfWord = s.indexOf(" ");
				//check to see if this is the last word
				if(endOfWord == -1){
					endOfWord = s.length() -1;
				}
				//get the next word and space
				nextWord = s.substring(0, endOfWord+1);
			}
			printString += currentLine +"\n";

		}

		System.out.println(printString);
	}
}
