package jiVickieRoom;


public class JiBackEnd implements VickieSupport {
	
	private JiVickieBoard[][] magicSquares;
	private String numbers;//a symbol showing you what is in the room... //RENAME!!!!
	
	private JiSupport frontend;

	public JiBackEnd(JiSupport frontend) {
		this.frontend = frontend;
		magicSquares = new JiVickieBoard[3][3];
		createTheBox();
	}

	private void createTheBox() {
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

	


	@Override
	public void checkTotal() {
		// TODO Auto-generated method stub
		
	}

	public void generateNumbers(int start, int finish) {
		//
	}
}
