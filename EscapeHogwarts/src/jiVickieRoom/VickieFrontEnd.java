package jiVickieRoom;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class VickieFrontEnd implements JiSupport{

	private VickieSupport backend;
	
	private String input;
	private String SRow;
	private String SCol;
	private String SNum;
	
	private boolean NoOverride = false;
	
	private int iRow;
	private int iCol;
	private int iNum;
	private int fixedNum;
	private int fixedRow;
	private int fixedCol;
	private int modRow;
	
	private int [][] magicSquares;

	
	public static final void main(String[] args){
		VickieFrontEnd game = new VickieFrontEnd();
		game.startGame();
	}
	
	public VickieFrontEnd() {
		backend = new JiBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
		magicSquares =  backend.getBoxes();
	}

	public void startGame() {
		/*int i = 0;
		while (iRow == 0) {
			i++;
			=backend.createInitiateNum();
			System.out.println(backend.initiatedNum);
			if (i == 50) {
				iRow++;
			}
		}*/
		
		/*backend.chooseStartingPoint();
		displayTheGrid(magicSquares);
		CaveExplorer.in.nextLine();
		startGame();
		*/
		
		
		/*System.out.println(iNum);
		magicSquares[0][0] = 5;
		magicSquares[1][0] = 9;
		magicSquares[2][0] = 8;
		magicSquares[0][1] = 3;
		magicSquares[2][2] = 6;
		System.out.print(magicSquares[2][2]);*/
		
		
		backend.chooseStartingPoint();
		directions();
		getInput();
	}
	
	public void getInput()
	{
		CaveExplorer.print("\nWhich coordinates do you want to put a number in, and which number do you have in mind?");
		input = CaveExplorer.in.nextLine();
		placeNumbers(input);
	}

	private void placeNumbers(String nums) {
		int len = nums.length();
		 if(len > 5 || len <5) {
			error();
		 }else {
			 //make sure the numbers are numbers
			 SRow = nums.substring(0, 1);
			 SCol = nums.substring(2, 3);
			 SNum = nums.substring(4, 5);
			 
			// CaveExplorer.print(SRow + SCol + SNum); debugging purposes
		
			if(isNumeric(SCol) && isNumeric(SRow) && isNumeric(SNum) ){
				//CaveExplorer.print("true");debugging purposes
				//turn str into num
				iRow = Integer.parseInt(SRow);
				iCol = Integer.parseInt(SCol);
				iNum = Integer.parseInt(SNum);
				
				doNotOverride();
				
				//turn the Snum to int
				if(iNum<10 && iNum>0 && iRow<3 && iRow>=0 && iCol<3 && iCol>=0) {
					checkMultiples(iNum);
					magicSquares[iRow][iCol] = iNum;
					//System.out.println(iNum); debugging purposes
					//System.out.println(magicSquares[iRow][iCol]);debugging purposes
					displayTheGrid(magicSquares);
					getInput();
					
				}else
				{
					error();
				}
				
			}else {
				error();
			}
		 }
		
	}
	
	public void doNotOverride() {
		fixedNum = backend.getInitiateNum();
		fixedRow = backend.getRowNum();
		fixedCol = backend.getColNum();
		
		if(fixedRow == iRow && fixedCol == iCol) {
			NoOverride = true;
			System.out.println("That coordinate already has a fixed value from the beginning!\nSorry, but you have to enter another set of coordinates.");
			error();
			/*System.out.println("\nWhich coordinates do you want to put a number in?");
			input = CaveExplorer.in.nextLine();
			placeNumbers(input);*/
		}
		
		if(fixedNum == iNum) {
			NoOverride = true;
			System.out.println("That number was given to you from the beginning! It's in a fixed spot and cannot be changed.\nSorry, but you have to enter another number.");
			error();
			/*System.out.println("\nWhich coordinates do you want to put a number in?");
			input = CaveExplorer.in.nextLine();
			placeNumbers(input);*/
		}
	}
	
	public void checkMultiples(int num) {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				int same = magicSquares[row][col];
				
				if(iNum == same) {
					magicSquares[row][col]= 0;
				}
			}
		}
		
	}

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  //fsgfsdfgdfgd
	  {  
	    return false;  
	  }  
	  return true;  
	}

	public void error() {
		if(!NoOverride) {
			CaveExplorer.print("You entered an invalid response: \n	Ex: x,y,z \n		  x = row (0-2)\n		  y = column (0-2)\n		  z = num (1-9)\n");
		}
		NoOverride = false;
		System.out.println("\nWhich coordinates do you want to put a number in?");
		input = CaveExplorer.in.nextLine();
		placeNumbers(input);
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
		displayTheGrid(magicSquares);
	}

	public void displayTheGrid(int[][] magicSquares) {
		CaveExplorer.print("    0         1        2    ");
		CaveExplorer.print(" ________ ________ ________ ");
		//String rows = "0123456789";
		String rows = " 0  1  2  ";
		
		for(int row = 0; row < 9; row++)
		{
			System.out.print("|");
				
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
	
	public void placeNumOnGrid() {
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
	
}
	

			
	
	/*
	public void endGame() {
		backend.checkTotal();
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

