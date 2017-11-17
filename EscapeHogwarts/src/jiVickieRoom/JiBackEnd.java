package jiVickieRoom;

import caveExplorer.CaveExplorer;

public class JiBackEnd implements VickieSupport {
	
	private static JiVickieBoard[][] magicSquares;
	private String numbers;//a symbol showing you what is in the room... //RENAME!!!!kjk
	
	private JiSupport frontend;
	
	private int total = 15;
	private int random;
	private String currentNumber;
	private int newNumber;
	private String usedNumbers;
	private String outerNumbers = "2648";
	private String innerNumbers = "7931";
	private int initiatedNum;
	private String StrInitiatedNum;

	public JiBackEnd(JiSupport frontend) {
		this.frontend = frontend;
		magicSquares = new JiVickieBoard[3][3];
		createTheBox();
	}

	public static void createTheBox() {
		for(int row = 0; row < magicSquares.length; row++){
			for(int col = 0; col < magicSquares[row].length; col++){
				magicSquares[row][col] = new JiVickieBoard(row, col);
			}
		}
	}

	public boolean checkValid(String character) {
		if(validNumbers().indexOf(character) > -1 && character.length() == 1) {
			currentNumber = character;
			return true;
		}else {
			return false;
		}
	}
	
	public void checkMultiples(String character) {
		if(checkValid(character) == true) {
			newNumber = Integer.parseInt(currentNumber);
			if(usedNumbers().indexOf(newNumber) > -1) {
				//replace original number with space (FRONT END)
				//add number in new space (FRONT END)
			}else {
				usedNumbers += Integer.toString(newNumber);
				//add number in new space (FRONT END)
			}
		}
	}
	
	public String usedNumbers() {
		return usedNumbers;
	}

	public String validNumbers() {
		return "1234567890";
	}

	public void checkTotal() {
		//check each row, column, diagonal == 15
		
	}

	public int generateNumber(int max) {;
		random = (int)(Math.random() * max);
		return random;
	}
	
	public boolean isOuterNumber() {
		initiatedNum = generateNumber(9);
		StrInitiatedNum = Integer.toString(initiatedNum);
		if(outerNumbers.indexOf(StrInitiatedNum) > -1) {
			return true;
		}else {
			if(innerNumbers.indexOf(StrInitiatedNum) > -1) {
				return false;
			}else {
				getMid();
			}
		}
		return false;
	}
	
	public int getMid() {
		return 5;
	}

	public void cheatCode() {
		//VickieFrontEnd.endGame();
		
	}

	@Override
	public JiVickieBoard[][] getBoxes() {
		return magicSquares;
	}
	
}
