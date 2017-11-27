package jiVickieRoom;

//import caveExplorer.CaveExplorer;

public class JiBackEnd implements VickieSupport {
	
	private int[][] magicSquares;
	//private String numbers;
	
	private JiSupport frontend;
	
	//private int total = 15;
	//private int currentNumber;
	//private int newNumber;
	//private String usedNumbers;
	//private String innerNumbers = "7931";
	private final static String CORNER_NUMS = "2648";
	private int iStartingNum;
	private int iStartingRow = 1;
	private int iStartingCol = 1;
	
	
	//private String SRow; //String Row #
	//private String SCol; //String Col #
	//private String SNum; //String Number #
	private int iRow;  //Integer Row #
	private int iCol;  //Integer Col #
	private int iNum;  //Integer Number #
	
	private final static int[][] ANSWER = {{2,7,6},{9,5,1},{4,3,8}};

	/*private JiBackEnd() {
	}*/
	
	public JiBackEnd(JiSupport frontend) {
		this.frontend = frontend;
		magicSquares = new int[3][3];
	}
	
	/*public static void main(String[] args) {
		VickieSupport backend = new JiBackEnd();
		
	}*/
	
	public int getRandomInitialIndex() {
		int num = 0;
		if (Math.random() >= .5) {
			num = 2;
		}
		
		return num;
	}
	
	public void chooseStartingPoint() {
		createInitiateNum();
		if (iStartingNum != 5) {
		/*if(iStartingNum == 5) {
			//magicSquares[iStartingRow][iStartingCol] = 5;
		}else {*/
			if(isCornerNumber(iStartingNum)) {
				//randomize outer starting box
				// (0,0) (0,2) (2,0) (2,2)
				
				iStartingRow = getRandomInitialIndex();
				iStartingCol = getRandomInitialIndex();
			
				//magicSquares[iStartingRow][iStartingCol] = iStartingNum;
			}
			else {
				//randomize inner starting box
				// (0,1) (1,0) (1,2) (2,1)
				int random = generateNumber(4); 
				if(random == 0) {
					//magicSquares[0][1] = iStartingNum;
					iStartingRow = 0;
					iStartingCol = 1;
					
				}else {
					if(random == 1) {
						//magicSquares[1][0] = iStartingNum;
						iStartingRow = 1;
						iStartingCol = 0;
					}
					else {
						if(random == 2) {
							//magicSquares[1][2] = iStartingNum;
							iStartingRow = 1;
							iStartingCol = 2;
						}else {
							//if(random == 3)
							//magicSquares[2][1] = iStartingNum;
							iStartingRow = 2;
							iStartingCol = 1;
						}
					}
				
				}
			}
		}
		
		magicSquares[iStartingRow][iStartingCol] = iStartingNum;
	}
	
	
	public void placeNumbers(String nums) {
		String SRow;
		String SCol;
		String SNum;
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
					resetMultiples(iNum);
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
		return iStartingNum;
	}
	
	public int getRowNum() {
		return iStartingRow;
	}
	
	public int getColNum() {
		return iStartingCol;
	}
	
	public boolean isCornerNumber(int num) {
		return CORNER_NUMS.indexOf(Integer.toString(num)) > -1;
	}
	
	public void createInitiateNum() {
		iStartingNum = (int)(Math.random() * 9) + 1;
	}

	public int generateNumber(int max) {
		return (int)(Math.random() * max);
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
	
	public void resetMultiples(int num) {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				int same = magicSquares[row][col];
				
				if(num == same) {
					magicSquares[row][col]= 0;
				}
			}
		}
		
	}
	
	public boolean checkTotal() {
		//check each row, column, diagonal == 15
		
		
		if(magicSquares[0][0] + magicSquares[0][1] + magicSquares[0][2] == 15 &&
			magicSquares[1][0] + magicSquares[1][1] + magicSquares[1][2] == 15 &&
			magicSquares[2][0] + magicSquares[2][1] + magicSquares[2][2] == 15 &&
			//^^^ ROW
			magicSquares[0][0] + magicSquares[1][0] + magicSquares[2][0] == 15 &&
			magicSquares[0][1] + magicSquares[1][1] + magicSquares[2][1] == 15 &&
			magicSquares[0][2] + magicSquares[1][2] + magicSquares[2][2] == 15 &&
			//^^^ COLUMN
			magicSquares[0][0] + magicSquares[1][1] + magicSquares[2][2] == 15 &&
			magicSquares[0][2] + magicSquares[1][1] + magicSquares[2][0] == 15) {
			//^^^^^ DIAGONAL
			return true;
		}else {
			return false;
		}
	}

	public void cheatCode() {
		/*
		//COL1
		magicSquares[0][0] = 2;
		magicSquares[1][0] = 9;
		magicSquares[2][0] = 4;
		//COL2
		magicSquares[0][1] = 7;
		magicSquares[1][1] = 5;
		magicSquares[2][1] = 3;
		//COL3
		magicSquares[0][2] = 6;
		magicSquares[1][2] = 1;
		magicSquares[2][2] = 8;
		*/
		magicSquares = ANSWER;
		frontend.displayTheGrid();
		frontend.endGame();
	}

	public int[][] getBoxes() {
		return magicSquares;
	}

}
