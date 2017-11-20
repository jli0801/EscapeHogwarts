package areejJessRoom;
import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

import java.util.Scanner;

public class JessicaFrontEnd implements AreejSupport{

	public static void setUserWon(boolean userWon) {
		JessicaFrontEnd.userWon = userWon;
	}

	public static void setComputerWon(boolean compWon)
	{
		JessicaFrontEnd.computerWon = compWon;
	}

	public static Scanner in;
	private static AreejBackEnd backend;
	private static boolean userWon = false;
	private static boolean computerWon = false;
	static CaveRoom[][] c = CaveExplorer.caves; 
	private static String [][] board;
	
	public static String[][] getBoard() {
		return board;
	}

	

	
	
	public static boolean isUserWon() {
		return userWon;
	}

	public static boolean isComputerWon() {
		return computerWon;
	}

	public JessicaFrontEnd() {
		backend = new AreejBackEnd(this);
		
	}

	public static void main(String[] args) {
		
		JessicaFrontEnd demo = new JessicaFrontEnd();
		JessicaFrontEnd.play();
	}

	static String getUserInput()
	{
		 String input = CaveExplorer.in.nextLine().toLowerCase();
		 return input;
	}
	
	public static void play() {
		
		new JessicaIntro().play();

		board = createBoard(6,7);
		CaveExplorer.in.nextLine();
		menu();
	}

	private static String[][] createBoard(int row1, int col1) {
	//	int numCol = (col1 * 2)+1;
	//	int numRow = row1 +1;
		col1 = col1*2 +1;
		
		String[][] boardC4 = new String[row1][col1];
		
		int firstNumber = 0;
		for(int i = 0; i < col1 ; i++){
			if(i%2 == 1) //odd
			{
				boardC4[0][i] = "   ";
			
			}
		} 
		
		
		for(int row =0; row<boardC4.length; row++) //rows
		{
		
			for(int col=0; col<boardC4[row].length ;col++) //columns
			{
				
				if(col%2==0)
				{
					boardC4[row][col] = "| ";
				}
				else{
					if(row!=0)
						boardC4[row][col] = "   ";
				}
			}
		}
		return boardC4;
	}

	private static void menu() {
		System.out.println("Enter 'r' for rules or 'p' to play.");
		String userInput = waitForLetterInput("rp");
		if(userInput.equals("r")){
			print("Place Galleons by choosing a column from 0 to 6. Input the number of the column you want to place your "
					+ "Galleons in. If you get FOUR in a row, either horizontally, vertically, or diagonally, you win. If not, I win."
					+ "You get all the Galleons you placed down if you win. Let the best player win! Press enter to start!");
			CaveExplorer.in.nextLine();
			menu();
		}else{
		//	board = createBoard(6,7);
			startGame();
		}
		
	}

	private static void startGame() {
		//AreejJessBoard[][] board = backend.getBoard();
		in = new Scanner(System.in);
		displayBoard(board);
		System.out.println("Where would you like to place your Galleon? Pick a number from 0 to 6.");
		
		boolean playingGame = true;
		while(playingGame)
		{
		/*	int userInt = Integer.parseInt(getUserInput());
			System.out.println(getUserInput());*/
	/*		if(checkValid(userInt))
			{
			AreejBackEnd.moveUser();	
		//	placeCoord(userInt);
			}
			else
			{
				System.out.println("Only pick numbers from 0 to 6! Try again!");
				AreejBackEnd.moveUser();	
			}*/
			AreejBackEnd.moveUser();
			
			if(userWon) //user turn
			{
				
				int moneyUser  = (int)Math.random()*15 + 1;
			//	displayBoard(board);
				System.out.println("I guess you won..Keep those Galleons! Get out of my room now!");
				Inventory.setMoney(Inventory.getMoney() + moneyUser);
				playingGame = false;
				CaveExplorer.currentRoom = c[2][1];
				CaveExplorer.currentRoom.enter();
			}
			else //our turn
			{
				AreejBackEnd.computerMove();
				System.out.println("My turn! \n");
				displayBoard(board);
				if(computerWon){
					System.out.println("I won! Now get out of my room! There'll be no prize for you!");
					
					playingGame =false;
				}
			}
		}
		
		
	}

	

	private static void getBadRes() {
		String[] badRes = {"That's not correct,", "Please try again!", "Follow the rules!"};
		System.out.println(badRes[(int)Math.random()*2]);
	}



	

	private static void displayBoard(String[][] board2) {
		
		for(int row = 0; row <board2.length;row ++)
		{
			for(int col=0; col <board2[row].length;col++)
			{
				System.out.print(board2[row][col]);
			}
			System.out.println();
		}
		System.out.println("   0    1    2    3    4    5    6   \n");
		
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

	

	public static void placeCoord(int row, int column , String input) {
		
		board = createBoard(6,7);
		
		int col = column*2 +1;
		if(input.equals("user"))
		{
			board[row][col] = "U ";
		}
		if(input.equals("computer"))
		{
			board[row][col] = "C ";
		}
		displayBoard(board);
		
	}

}