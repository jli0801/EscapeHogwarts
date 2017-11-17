package kevinStephRoom;

import caveExplorer.CaveExplorer;
import java.util.Scanner;

public class StephFrontEnd implements StephSupport{

	private static KevinSupport backend;
	private static int move;
	private static int lightsOff;
	private static String [][] board;
	
	public static String[][] getBoard() {
		return board;
	}
	
	public StephFrontEnd() {
		backend = new KevinBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
		move = 0;
		setLightsOff(0); //for now until we give it a value
	}

	public static void main(String[] args) {
		StephFrontEnd game = new StephFrontEnd();
		game.play();
	}

	public static void play() {
		new StephIntro().play();
		CaveExplorer.in.nextLine();
		menu();
	}
	
	private static void menu() {
		System.out.println("Enter 'r' for rules or 'p' to play.");
		String command = waitForLetterInput("rp");
		if(command.equals("r")){
			print("To win this game, you must turn off all the lights. The O's represent the lights that are on the and X's "
					+ "represent the lights that are off. Type out a coordinate in the form of (row, column) to toggle"
					+ "the light and its adjacent lights. Turn all the O's into X's to win the game. \n\n      - - press enter - -");
			CaveExplorer.in.nextLine();
			menu();
		}else{
			startGame();
		}

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
	
	public static String waitForLetterInput(String letters){
		String input = CaveExplorer.in.nextLine();
		while(input.length() <1 || letters.toLowerCase().indexOf(input.toLowerCase().substring(0, 1))<0){
			System.out.print("That entry is not allowed. Please type on of the following: ");
			String list = "";
			for(int i = 0 ; i < letters.length()-1; i++){
				list += letters.substring(i, i+1)+",";
			}
			list += " or "+letters.substring(letters.length()-1); 
			System.out.println(list);
			input = CaveExplorer.in.nextLine();
		}
		return input.toLowerCase().substring(0, 1);
	}

	private static void startGame() {
		KevinStephLight[][] board = backend.getBoard();
		KevinStephLight c = null; 
		
		while (getLightsOff() > 0) {
			displayBoard(board);
			displayMoveCount();
		
			print("Where would you like to turn the lights off next?");
			int[] coords = backend.getCoordInput();
			c = board[coords[0]][coords[1]];
			backend.lightSwitch(c);
			
			move++;
		}
		
		print("Congratulations, you win!");
	}
	
	private static void displayMoveCount() {
		print("You have taken " + move + " moves.");
	}

	private static void displayBoard(KevinStephLight[][] board) {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				if(board[row][col].getLightOn() == true) {
					System.out.println("O");
				}else {
					System.out.println("X");
				}	
			}
		}
	}

	public static int getLightsOff() {
		return lightsOff;
	}

	public static void setLightsOff(int lightsOff) {
		StephFrontEnd.lightsOff = lightsOff;
	}
}
