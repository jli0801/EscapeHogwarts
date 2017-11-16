package jiVickieRoom;

import caveExplorer.CaveExplorer;

public class JiBackEnd implements VickieSupport {
	
	private static JiVickieBoard[][] magicSquares;
	private String numbers;//a symbol showing you what is in the room... //RENAME!!!!
	
	private JiSupport frontend;
	
	private int total = 15;
	private int random;
	private String currentNumber;
	private int newNumber;
	private String usedNumbers;
	private String[] outerNumbers = {};
	private String[] innerNumbers = {};

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
		
		//method for inputting number
	}

	public void setNumbers(String numbers) { //rename!!!!!
		this.numbers = numbers;
	}
	
	public String getNumbers() {
		return numbers;
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
				//replace original number with space
				//add number in new space
			}else {
				usedNumbers += Integer.toString(newNumber);
				//add number in new space
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

	public void generateNumbers(int max) {;
		random = (int)(Math.random() * max);
	}

	public void cheatCode() {
		//VickieFrontEnd.endGame();
		
	}
	//
}
