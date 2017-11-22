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
/*
	public static void createTheBox() {
		for(int row = 0; row < magicSquares.length; row++){
			for(int col = 0; col < magicSquares[row].length; col++){
				magicSquares[row][col] = new magicSquares(row, col);
			}
		}
	}
*/
	/*
	public void checkMultiples(String character) {
		if(checkValid(character) == true) {
			newNumber = currentNumber;
			if(usedNumbers().indexOf(newNumber) > -1) {
				//replace original number 'x' (FRONT END)
				//add number in new box (FRONT END)
			}else {
				usedNumbers += Integer.toString(newNumber);
				//add number in new box (FRONT END)
			}
		}
	}
	*/
	public void checkMultiples(String character) {
		if(character.length() == 1 && isNumberic(character) &&
		usedNumbers().indexOf(Integer.toString(character)) > -1) {
				//replace original number 'x' (FRONT END)
				//add number in new box (FRONT END)
			}else {
				usedNumbers += Integer.toString(Integer.toString(character));
				//add number in new box (FRONT END)
			}
		}
	}
	
	
	/*
	public boolean checkValid(String character) {
		if(validNumbers().indexOf(character) > -1 && character.length() == 1) {
			currentNumber = Integer.parseInt(character);
			return true;
		}else {
			return false;
		}
	}
	
	public String validNumbers() {
		return "1234567890";
	}
	*/
	
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
	/*
	public int getMid() {
		initiatedNum = 5;
		return initiatedNum;
	}
	*/
	public static boolean isNumeric(String str)  
	{  
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
		//VickieFrontEnd.endGame();
		
	}

	public int[][] getBoxes() {
		return magicSquares;
	}

}
