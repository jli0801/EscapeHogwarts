package kevinStephRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

import java.util.Scanner;

public class StephFrontEnd implements KevinSupport{

	private  StephSupport backend;
	private  int move;
	private  int lightsOff;
	private  KevinStephLight[][] board;
	public static CaveRoom[][] caves;
	
	public KevinStephLight[][] getBoard() {
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
	
	public void play() {
		new StephIntro().play();
		CaveExplorer.in.nextLine();
		menu();
		skip();
	}
	
	private boolean skip() {
		String input = CaveExplorer.in.nextLine().toLowerCase();
		if(input.equals("finish")){
			return true;
		}
		return false;
	}

	private void menu() {
		System.out.println("Enter 'r' for rules or 'p' to play.");
		String command = waitForLetterInput("rp");
		if(command.equals("r")){
			print("To win this game, you must turn off all the lights. The O's represent the lights that are on the and X's "
					+ "represent the lights that are off. Type out a coordinate in the form of (row, column) to toggle"
					+ " the light and its adjacent lights. Turn all the O's into X's to win the game. \n\n      - - press enter - -");
			CaveExplorer.in.nextLine();
			menu();
		}else{
			startGame();
		}

	}
	
	private void startGame() { //START GAME
		board = backend.createBoard();
		KevinStephLight c = null; 
		
		print("Do you Know the magic word?");
		if(skip() == true) {
			backend.cheatcode();
			displayBoard(board);
			displayMoveCount();
			print("You have successfully escaped from the Mirror of Erised. As you are about to leave, you see Dumbledore start to approach you...\n"
					+ "He hands you a piece of a broom and says, 'you earned it.'"
					+ "\n- - press enter - -");
			Inventory.setBroomP2(true);
			Inventory.merge();
		}else {
			if(getLightsOff() == 0) {
				print("You have successfully escaped from the Mirror of Erised. As you are about to leave, you see Dumbledore start to approach you...\n" 
						+ "He hands you a piece of a broom and says, 'you earned it.'"
						+ "\n- - press enter - -");
				Inventory.setBroomP2(true);
				Inventory.merge();
			}else {
				while (getLightsOff() > 0) {
					if(move < 15) {
						displayBoard(board);
						displayMoveCount();
					
						print("Where would you like to turn the lights off next?");
						int[] coords = backend.getCoordInput();
						c = board[coords[0]][coords[1]];
						backend.lightSwitch(c);
						
						move++;
					}else {
						print("Your eyes are forever locked onto the mirror.... \n"
								+ "Thankfully, Dumbledore has opened the door snapping you out of it. "
								+ "However, you end up losing 20 hp from staring too long."
								+ "\n- - press enter - -");
						int userHp = Inventory.getHp() - 20;
						Inventory.setHp(userHp);
						CaveExplorer.print("Your HP is now: " + userHp + ".");
						break;
					}
				}
			}
		}
	}
	
	private void displayMoveCount() {
		print("You have taken " + move + " moves.");
	}

	private void displayBoard(KevinStephLight[][] board) {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				
				System.out.print(" | ");
				
				if(board[row][col].getLightOn() == true) {
					System.out.print("O");
				}else {
					System.out.print("X");
				}	
				
				System.out.print(" ");
			}
			
			System.out.print("|\n");
		}
	}

	public  int getLightsOff() {
		int counter = 0;
		
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				if(board[row][col].getLightOn()) {
					counter++;
				}
			}
		}
		return counter;
	}

	public void setLightsOff(int lightsOff) {
		this.lightsOff = lightsOff;
	}
	
	public static void print(String s){
		String printString = "";
		int cutoff = 75;
		while(s.length() > 0){
			String currentLine = "";
			String nextWord = "";
			while(currentLine.length() + 
					nextWord.length() <= cutoff &&
					s.length() > 0){
				currentLine += nextWord;
				s = s.substring(nextWord.length());
				int endOfWord = s.indexOf(" ");
				if(endOfWord == -1){
					endOfWord = s.length() -1;
				}
				nextWord = s.substring(0, endOfWord+1);
			}
			printString += currentLine +"\n";

		}

		System.out.println(printString);
	}
	
	public String waitForLetterInput(String letters){
		String input = CaveExplorer.in.nextLine();
		while(input.length() <1 || letters.toLowerCase().indexOf(input.toLowerCase().substring(0, 1))<0){
			System.out.print("That entry is not allowed. Please type on of the following: ");
			String list = "";
			for(int i = 0 ; i < letters.length()-1; i++){
				list += letters.substring(i, i+1);
			}
			list += " or "+letters.substring(letters.length()-1); 
			System.out.println(list);
			input = CaveExplorer.in.nextLine();
		}
		return input.toLowerCase().substring(0, 1);
	}
}
