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

	public JiBackEnd(JiSupport frontend) {
		this.frontend = frontend;
		//magicSquares = magicSquares[3][3];
		magicSquares = new int[3][3];
		//createTheBox();
	}
	
	public String usedNumbers() {
		return usedNumbers;
	}

	
	
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
						}
					}
				
				}
			}
		}
	}
	
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
		
	}
	
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
		magicSquares[0][0] = 2; magicSquares[0][1] = 7; magicSquares[0][2] = 6;
		magicSquares[1][0] = 9; magicSquares[1][1] = 5; magicSquares[1][2] = 1;
		magicSquares[2][0] = 4; magicSquares[2][1] = 3; magicSquares[2][2] = 8;
	
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
