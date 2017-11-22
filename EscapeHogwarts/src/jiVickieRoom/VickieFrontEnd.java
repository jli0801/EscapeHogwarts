package jiVickieRoom;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class VickieFrontEnd implements JiSupport{

	private VickieSupport backend;
	
	private String input;
	private String SRow; //String Row #
	private String SCol; //String Col #
	private String SNum; //String Number #

	private int iRow;  //Integer Row #
	private int iCol;  //Integer Col #
	private int iNum;  //Integer Number #
	private int fixedNum;
	private int fixedRow;
	private int fixedCol;
	private int modRow;
	
	private int [][] magicSquares;

	//SHOULD WE PROVIDE ONE INNER AND OUTER NUMBER AS WELL AS THE MIDDLE NUMBER TO MAKE IT EASIER FOR PPL TO COMPLETE GAME???
	
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
		backend.chooseStartingPoint();
		directions();
		getInput();
	}
	
	public void setSRow(String sRow) {
		SRow = sRow;
	}

	public void setSCol(String sCol) {
		SCol = sCol;
	}

	public void setSNum(String sNum) {
		SNum = sNum;
	}

	public void setiRow(int iRow) {
		this.iRow = iRow;
	}

	public void setiCol(int iCol) {
		this.iCol = iCol;
	}

	public void setiNum(int iNum) {
		this.iNum = iNum;
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
		displayTheGrid();
	}
	
	public void displayTheGrid() {
		CaveExplorer.print("	    0         1        2    ");
		CaveExplorer.print("	 ________ ________ ________ ");
		//String rows = "0123456789";
		String rows = " 0  1  2  ";
		
		for(int row = 0; row < 9; row++){
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
	
	public void getInput(){
		CaveExplorer.print("\nWhich coordinates do you want to put a number in, and which number do you have in mind?");
		input = CaveExplorer.in.nextLine();
		input= input.toLowerCase();
		if(input == "skip") {
			backend.cheatCode();
		}else {
		backend.placeNumbers(input);
		}
	}

	
	public void complete() {
		String numbersUsed = "";
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				int num = magicSquares[row][col];
				String digit = Integer.toString(num);
				numbersUsed += digit;
			}
		}
		
		if(numbersUsed.indexOf("0") == -1) {
			System.out.print("You filled in all the boxes on the grid! Do you want it to be checked?");
			input = CaveExplorer.in.nextLine();
			input = input.toLowerCase();
			if(input == "yes") {
				endGame();
				//backend.checkTotal();
			}
			if(input == "no") {
				getInput();
			}
		}else {
			getInput();
		}
	}

	public void doNotOverride() {
		fixedNum = backend.getInitiateNum();
		fixedRow = backend.getRowNum();
		fixedCol = backend.getColNum();
		
		if(fixedRow == backend.getiRow() && fixedCol == iCol) {
			System.out.println("	That coordinate already has a fixed value from the beginning!");
			System.out.println("	Sorry, but you have to enter another set of coordinates.");
			getInput();
		}
		
		if(fixedNum == iNum) {
			System.out.println("	That number was given to you from the beginning!\n	It's in a fixed spot and cannot be changed.");
			System.out.println("	Sorry, but you have to enter another number.");
			getInput();
		}
	}
	
	public void error() {
		CaveExplorer.print("	You entered an invalid response: \n		Ex: x,y,z \n		  	x = row (0-2)\n		  	y = column (0-2)\n		  	z = num (1-9)");
		getInput();
	}

	public void endGame() {
		backend.checkTotal();
		/*
		 * Reward: Galleons to buy stuff in shop: also, 1/3 of a broom?
		 * maybe make a decreaseGalleons():every time the error function or overidden function is called, -1 or -10 galleons from 100? and if it reaches zero, no money
		 * 	if galleons = 0; say oh no, you wont recieve any money, but heres the part of the broom!
		 * else say congrats: you get money and part of the broom!
		 */
	}

	public String getSRow() {
		return SRow;
	}

	public String getSCol() {
		return SCol;
	}

	public String getSNum() {
		return SNum;
	}

	public int getiRow() {
		return iRow;
	}

	public int getiCol() {
		return iCol;
	}

	public int getiNum() {
		return iNum;
	}
}


	/*@Override
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

package jiVickieRoom;

import caveExplorer.CaveExplorer;

public class JiBackEnd implements VickieSupport {
	
	private int[][] magicSquares;
	private String numbers;//a symbol showing you what is in the room... //RENAME!!!!kjk
	
	private JiSupport frontend;
	
	//private int total = 15;
	private int random;
	private int currentNumber;
	private int newNumber;
	private String usedNumbers;
	private String outerNumbers = "2648";
	private String innerNumbers = "7931";
	private int initiatedNum;
	private String StrInitiatedNum;
	private int rowNum = 1;
	private int colNum = 1;
	
	private String SRow; //String Row #
	private String SCol; //String Col #
	private String SNum; //String Number #

	private int iRow;  //Integer Row #
	private int iCol;  //Integer Col #
	private int iNum;  //Integer Number #

	public JiBackEnd(JiSupport frontend) {
		this.frontend = frontend;
		//magicSquares = magicSquares[3][3];
		magicSquares = new int[3][3];
		//createTheBox();
	}
	
	/*public String usedNumbers() {
		return usedNumbers;
	}*/

	
	
	public void chooseStartingPoint() {
		createInitiateNum();
		if(initiatedNum == 5) {
			magicSquares[rowNum][colNum] = 5;
		}else {
			if(isOuterNumber(initiatedNum)) {
				//randomize outer starting box
				// (0,0) (0,2) (2,0) (2,2)
				
				if(Math.random() < .5) {
					rowNum = 0;
				}else {
					rowNum = 2;
				}
				
				if(Math.random() < .5) {
					colNum = 0;
				}else {
					colNum = 2;
				}
				magicSquares[rowNum][colNum] = initiatedNum;
			}
			else {
				//randomize inner starting box
				// (0,1) (1,0) (1,2) (2,1)
				generateNumber(4); 
				if(random == 0) {
					magicSquares[0][1] = initiatedNum;
					rowNum = 0;
					colNum = 1;
					
				}else {
					if(random == 1) 
					{
						magicSquares[1][0] = initiatedNum;
						rowNum = 1;
						colNum = 0;
					}
					else {
						if(random == 2) {
							magicSquares[1][2] = initiatedNum;
							rowNum = 1;
							colNum = 2;
						}else {
							if(random == 3)
							magicSquares[2][1] = initiatedNum;
							rowNum = 2;
							colNum = 1;
						}//2123fgdf
					}
				
				}
			}
		}
	}
	
	
	public void placeNumbers(String nums) {
		int len = nums.length();
		 if(len > 5 || len <5) {
			frontend.error();
		 }else {
			  SRow = nums.substring(0, 1);
			  SCol = nums.substring(2, 3);
			  SNum = nums.substring(4, 5);

			if(isNumeric(SCol) && isNumeric(SRow) && isNumeric(SNum) ){
				 iRow = Integer.parseInt(SRow);
				 iCol = Integer.parseInt(SCol);
				 iNum = Integer.parseInt(SNum);
				
				frontend.doNotOverride();
				
				if(iNum<10 && iNum>0 && iRow<3 && iRow>=0 && iCol<3 && iCol>=0) {
					checkMultiples(iNum);
					magicSquares[iRow][iCol] = iNum; //create method in backend
					frontend.displayTheGrid();
					frontend.complete();
					//getInput();
				}else
				{
					frontend.error();
				}
				
			}else {
				frontend.error();
			}
		 }
		
	}
	//STOP
	public String getSRow() {
		return SRow;
	}

	public String getSCol() {
		return SCol;
	}

	public String getSNum() {
		return SNum;
	}

	public int getiRow() {
		return iRow;
	}

	public int getiCol() {
		return iCol;
	}

	public int getiNum() {
		return iNum;
	}
 //STOP
	public int getInitiateNum() {
		return initiatedNum;
	}
	
	public int getRowNum() {
		return rowNum;
	}
	
	public int getColNum() {
		return colNum;
	}
	
	public boolean isOuterNumber(int num) {
		StrInitiatedNum = Integer.toString(num);
		if(outerNumbers.indexOf(StrInitiatedNum) > -1) {
			return true;
		}else {
			if(innerNumbers.indexOf(StrInitiatedNum) > -1) {
				return false;
			}
		}
		return false;
	}
	
	public void createInitiateNum() {
		initiatedNum = (int)(Math.random() * 9) + 1;
	}

	public int generateNumber(int max) {
		random = (int)(Math.random() * max);
		return random;
	}

	public boolean isNumeric(String str) {  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public void checkMultiples(int num) {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				int same = magicSquares[row][col];
				
				if(num == same) {
					magicSquares[row][col]= 0;
				}
			}
		}
		
	}//jgjh
	
	public boolean checkTotal() {
		//check each row, column, diagonal == 15
		if(magicSquares[0][0] + magicSquares[0][1] + magicSquares[0][2] == 15 &&
			magicSquares[1][0] + magicSquares[1][1] + magicSquares[1][2] == 15 &&
			magicSquares[2][0] + magicSquares[2][1] + magicSquares[2][2] == 15 &&
			magicSquares[0][0] + magicSquares[1][1] + magicSquares[2][2] == 15 &&
			magicSquares[2][0] + magicSquares[1][1] + magicSquares[0][2] == 15 &&
			magicSquares[0][0] + magicSquares[0][1] + magicSquares[0][2] == 15 &&
			magicSquares[1][0] + magicSquares[1][1] + magicSquares[1][2] == 15 &&
			magicSquares[2][0] + magicSquares[2][1] + magicSquares[2][2] == 15) {
			return true;
		}else {
			return false;
		}
	}

	public void cheatCode() {
		
	
		/*
		for(int col = 0; col < magicSquares[row].length; col++) {
			if(col ==)
		}
	
		for(int row = 0; row < magicSquares.length; row++){
			for(int col = 0; col < magicSquares[row].length; col++){
				if()
			}
		}
	*/
	}

	public int[][] getBoxes() {
		return magicSquares;
	}

}
