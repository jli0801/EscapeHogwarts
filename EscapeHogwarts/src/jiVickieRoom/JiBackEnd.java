package jiVickieRoom;


public class JiBackEnd implements VickieSupport {
	
	private JiVickieBoard[][] magicSquares;
	//gh
	
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
