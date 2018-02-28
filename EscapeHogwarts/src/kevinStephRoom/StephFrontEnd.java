package kevinStephRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

import java.util.Random;
import java.util.Scanner;

public class StephFrontEnd {

	private  int move;
	private  int toggler = 6;
	private int gridHeight = 4;
	private int gridWidth = 4;
	public boolean[][] grid;
	public static CaveRoom[][] caves;
	
	public StephFrontEnd() {
		CaveExplorer.in = new Scanner(System.in);
		move = 0;
		boolean grid[][] = new boolean[gridHeight][gridWidth];
		createBoard();
	}

	public static void main(String[] args) {
		StephFrontEnd game = new StephFrontEnd();
		game.play();
	}

	public void createBoard() {
		for (int i = 0; i < toggler; i++) {
		     //Get random position
		     Random rand = new Random();
		     int row = rand.nextInt(gridWidth);
		     int col = rand.nextInt(gridHeight);
		     while(grid[row][col]) { //if this position is true
		          //we get new position
		          row = rand.nextInt(gridWidth);
		          col = rand.nextInt(gridHeight);
		     }
		     grid[row][col] = true; //make new position
		}
		
	}
	
	public void switchRow(boolean[] row, int x) {
		row[x] = !row[x];
		if(x > 0) {
			row[x - 1] = !row[x - 1];
		}
		if(x < row.length - 1) {
			row[x + 1] = !row[x + 1];
		}
	}
	
	public void switchColumn(boolean[][] grid, int r, int c) {
		if(r > 0) {
			grid[r - 1][c] = !grid[r - 1][c];
		}
		if(r < grid.length - 1) {
			grid[r + 1][c] = !grid[r + 1][c];
		}
	}
	
	public void switcher(int r, int c) {
		switchRow(grid[r],c);
		switchColumn(grid, r, c);
		for(boolean[] row:grid) {
			for(boolean b: row) {
				if (b) return;
			}
		}
		print("You have successfully escaped from the Mirror of Erised. As you are about to leave, you see Dumbledore start to approach you...\n" 
				+ "He hands you a piece of a broom and says, 'you earned it.'"
				+ "\n- - press enter - -");
		Inventory.setBroomP2(true);
		Inventory.merge();
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
		
		print("Do you Know the magic word?");
		if(skip() == true) {
			cheatcode();
			displayBoard(grid);
			displayMoveCount();
			print("You have successfully escaped from the Mirror of Erised. As you are about to leave, you see Dumbledore start to approach you...\n"
					+ "He hands you a piece of a broom and says, 'you earned it.'"
					+ "\n- - press enter - -");
			Inventory.setBroomP2(true);
			Inventory.merge();
		}else {
			if(move < 15) {
				displayBoard(grid);
				displayMoveCount();
				
				print("Where would you like to turn the lights off next?");
				int[] coords = getCoordInput();
				c = grid[coords[0]][coords[1]];
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
	
	public void cheatcode() {
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col++){
				grid[row][col] = true;
			}
		}
	}

	private void displayMoveCount() {
		print("You have taken " + move + " moves.");
	}

	private void displayBoard(boolean[][] grid) {
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col++){
				
				System.out.print(" | ");
				
				if(grid[row][col] == true) {
					System.out.print("O");
				}else {
					System.out.print("X");
				}	
				
				System.out.print(" ");
			}
			
			System.out.print("|\n");
		}
	}

	public int[] getCoordInput() {
		String input = CaveExplorer.in.nextLine();
		int[] coords = toCoords(input);
		while(coords == null){
			System.out.println("You must enter cordinates of the form:\n          <row>,<col>" //kevin
					+ "\n<row> and <col> should be integers.");
			input = CaveExplorer.in.nextLine();
			coords = toCoords(input);
		}
		return coords;
	}

	private int[] toCoords(String input) {
		try{
			int a = Integer.parseInt(input.substring(0,1));
			int b = Integer.parseInt(input.substring(2,3));
			if(input.substring(1,2).equals(",") && input.length() ==3){
				int[] coords = {a,b};
				return coords;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
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