package jiVickieRoom;


public class JiBackEnd implements VickieSupport {
	
	private static JiVickieBoard[][] magicSquares;
	private String numbers;//a symbol showing you what is in the room... //RENAME!!!!
	
	private JiSupport frontend;
	
	private int total = 15;
	private int random;

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
	
	public void checkMultiples() {
		//when adding numbers to game, add in array
		
		
	}
	
	public String usedNumbers() {
		return "";
	}
	
	public void notifyNumbers() {
		System.out.println("You can only type a number.");
	}

	public String validNumbers() {
		return "1234567890";
	}


	@Override
	public void checkTotal() {
		// TODO Auto-generated method stub
	
	}

	public void generateNumbers(int max) {;
		random = (int)(Math.random() * max);
	}

	@Override
	public void cheatCode() {
		// TODO Auto-generated method stub
		
	}
//
}
