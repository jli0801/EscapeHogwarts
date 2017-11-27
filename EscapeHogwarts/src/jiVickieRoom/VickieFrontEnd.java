package jiVickieRoom;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.Inventory;

public class VickieFrontEnd implements JiSupport{
	
	private static VickieSupport backend;
	
	public static CaveExplorer cave;
	
	private String input;

	private int fixedNum;
	private int fixedRow;
	private int fixedCol;
	private int modRow;
	
	private boolean endOfStory = false;
	
	public static final void main(String[] args){
		VickieFrontEnd game = new VickieFrontEnd();
		game.startGame();
	}
	
	public VickieFrontEnd() {
		backend = new JiBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
	}

	public void startGame() {
		backend.chooseStartingPoint();
		backgroundStory();
		directions();
		getInput();
	}
	
	public void directions() {									//Displays the rules
		CaveExplorer.print("The Rules:");
		CaveExplorer.print("	You're given a grid of nine boxes. ");
		CaveExplorer.print("	You must fill in the boxes with numbers 1-9.");
		CaveExplorer.print("	In each row, column, and diagonal, the sum of the numbers must be 15.");
		CaveExplorer.print("	To fill in a particular box, tell us the coordinates of that box, and the number you want to be in it.");
		CaveExplorer.print("		Ex: 1,2,8 --> the row, the column, and the number ");
		CaveExplorer.print("");
		CaveExplorer.print("When you're ready to play, press enter!");
		CaveExplorer.in.nextLine();
		displayTheGrid();
	}
	
	public void displayTheGrid() { 								//Creates and displays the grid
		CaveExplorer.print("	    0         1        2    ");
		CaveExplorer.print("	 ________ ________ ________ ");
		//String rows = "0123456789";
		String rows = " 0  1  2  ";
		
		for(int row = 0; row < 9; row++)
		{
			System.out.print("	|");
			if (row == 2 || row == 5 || row == 8){
				for(int col = 0; col < 3; col++){
					System.out.print("________|");
				}
			}
			if(row == 0 || row == 3 || row == 6){
				for(int col = 0; col < 3; col++){
					System.out.print("        |");
				}
			}
			if (row == 1 ){
				modRow = 0;
				placeNumOnGrid();
			}
			if (row == 4 ){
				modRow = 1;
				placeNumOnGrid();
			}
			if (row == 7){
				modRow = 2;
				placeNumOnGrid();
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		CaveExplorer.print("");
	}
	
	public void placeNumOnGrid() {							//Prints number or x's on grid based on array value
		int[][] magicSquares = backend.getBoxes();
		for(int col = 0; col < 3; col++){
			
			if(magicSquares[modRow][col]==0) {
				System.out.print("    X   |");
				//System.out.print("        |");
			}else {
				int val = magicSquares[modRow][col];
				System.out.print("    "+val+"   |");
			}
		} 
	}
	
	public void getInput(){									//Gets row, col and num from user
		CaveExplorer.print("\nWhich coordinates do you want to put a number in, and which number do you have in mind?");
		input = CaveExplorer.in.nextLine();
		input= input.toLowerCase();
		String skip = "skip";
		if(input.indexOf(skip) ==0) { 						//triggers cheat code
			backend.cheatCode();
		}else {
		backend.placeNumbers(input);
		}
	}

	public void complete() { 								//Is the grid completed?
		int[][] magicSquares = backend.getBoxes();
		String numbersUsed = "";							//creates string of the current values in the array
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				int num = magicSquares[row][col];
				String digit = Integer.toString(num);
				numbersUsed += digit;
			}
		}
		
		if(numbersUsed.indexOf("0") == -1) { 			//if there is no 0 in the string, the whole grid is filled with numbers 1-9
			System.out.print("You filled in all the boxes on the grid! Do you want it to be checked?\n\n");
			input = CaveExplorer.in.nextLine();
			input = input.toLowerCase();
			if(input.equals("yes")) {					//checks if every row, col, and diagonal equals 15 
				endOfStory = backend.checkTotal();
				if(endOfStory == true) {
					endGame();
				}else {
					System.out.print("	Sorry! Not all the rows, columns, and diagonals add up to 15!\n");
					getInput();
				}
			}
			if(input.equals("no")) {
				getInput();
			}
		}else {
			getInput();
		}
	}

	public void doNotOverride() {		//The given number on the given coordinate can not be changed
		fixedNum = backend.getInitiateNum();
		fixedRow = backend.getRowNum();
		fixedCol = backend.getColNum();
		
		if(fixedRow == backend.getiRow() && fixedCol == backend.getiCol()) {
			System.out.println("	That coordinate already has a fixed value from the beginning!");
			System.out.println("	Sorry, but you have to enter another set of coordinates.");
			getInput();
		}
		
		if(fixedNum == backend.getiNum()) {
			System.out.println("	That number was given to you from the beginning!\n	It's in a fixed spot and cannot be changed.");
			System.out.println("	Sorry, but you have to enter another number.");
			getInput();
		}
	}
	
	public void error() { 				//Prints error message
		CaveExplorer.print("	You entered an invalid response: \n		Ex: x,y,z \n		  	x = row (0-2)\n		  	y = column (0-2)\n		  	z = num (1-9)");
		getInput();
	}

	public void endGame() {
		System.out.println("	CONGRATULATIONS!!! YOU'VE SOLVED THE PUZZLE!!\n");
		Inventory.setMoney(Inventory.getMoney() +50);
		Inventory.setBroomP3(true);
		backgroundStory();
		Inventory.merge();
	}

	public void backgroundStory() {
		if(!endOfStory) {
			endOfStory = true;
			CaveExplorer.print("********************A storyline will appear. To move the story along, PRESS ENTER********************");
			CaveExplorer.print("");
			CaveExplorer.print("	You enter the room and see Peeves, the poltergeist, floating in the air and holding a wooden puzzle grumbling to himself.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES:(Mumbling to himself) Stupid Dumbledore and his stupid spell ...(Incoherent words).");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	He notices you and widens his eyes in surprise. \n	Then a slow smile appears on his face, a smile that makes warning bells go off in your head.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: Hellllooooo Potter! Loook at this puzzle!");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	He shakes the wooden puzzle at you.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: It's IMPOSSIBLE to solve.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("YOU:(Warily) Really?");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	Peeves explodes (figuratively).");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: Ohh what, you think YOU can solve itt??");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: (To himself) Harry Potter, the boy who lived, eh?");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: (To You) Prove it then.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	He tosses the wooden puzzle at you, which you catch.\n	You glance at it and notice it's a board game with a surface that changes every now and then.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: Now, if you don't solve it - ");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	Peeves whizzes around the room and the door you just entered through slams shut.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: - you'll be trapped in this room for eternity! MUAHAHAHAHAHAHAHAAAA!!!");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	He gives you a smirk and then vanishes into thin air.\n	Groaning inwardly, you prepare to solve the puzzle.");//\n	The surface of the puzzle changes and you see it diplays the rules.");
			CaveExplorer.in.nextLine();
		}else {
			CaveExplorer.print("	Peeves reappears into the room.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES:(Dumbfounded) You did it, you actually solved it! WHOOHOO!!");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	He raises and shakes his fist into the air.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: Take that Dumbledore!! Now, I'm free!");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	Just as he says that, a wave of magic is released from the puzzle and hits Peeves.\n	An invisible bubble, hidden to you before, appears around him. \n	It flickers for a few seconds, and then it pops. *POP* ");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: FINALLLYY! Now I can roam the halls and prank students again!!");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	He whizzes around the room, cackling with mischeif. Then he disappears.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("YOU: HEY!! I solved your puzzle! Now let me out!!");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	Peeves's smug disembodied voice reaches your ear, and disbelief washes over your features at what you hear. ");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("PEEVES: The door was never locked!! Tricked ya! Bye now, Potter! AHAHAHHAAA!");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	Chagrinned, you are about to throw the puzzle across the room when you notice the surface has changed.\n	It now shows Dumbledore's face.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("DUMBLEDORE: Don't worry, Peeves won't get far. He didn't solve the puzzle himself so he's still bound to this room. He's only out temporarily.\n            Here's your reward for completing the puzzle: 50 galleons and a part of the broom.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	He winks.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("DUMBLEDORE: Don't drink too much butterbeer now, you hear? \n\n	And with that, the surface of the puzzle becomes blank.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	You walk to the door and turn the doorknob. The door opens away easily, and you walk through.");
			CaveExplorer.in.nextLine();
			CaveExplorer.print("	-----GAME OVER-----");
			//CaveExplorer.startExploring(); //IN ORDER FOR THIS TO WORK, YOU MUST RUN CAVEROOM FILE AND THEN GO TO ROOM "M" FOR THIS MINIGAME!!!!!
		}
	}
	
}