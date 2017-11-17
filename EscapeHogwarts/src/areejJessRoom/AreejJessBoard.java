package areejJessRoom;

public class AreejJessBoard {

	private static String[][] board;
	public AreejJessBoard() {
		board = new String[6][7];
		populateBoard(board);
	}

	public static void main(String[] args) {
		

	}

	private int row;
	private int col;
	
	public AreejJessBoard(int row, int col) {
		
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	
	
	private void populateBoard(String[][] board2) {
		for(int i = 0; i < board.length; i++) {
			for(int j =0; j < board[i].length; j++) {
				board[i][j] = "";
			}
		}
		
	}
	
	/*public static String[][] makeBoard(int r, int c){
		
		String[][] board = new String[r][c];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(j%2 == 0) {
					board[i][j] = "|";
				}
				else if(i != 0) {
					board[i][j] = " ";
				}
			}
		}
		return board;
	}

	public boolean placesPiece(int col) {
		AreejBackEnd.putPiece(col);
		return false;
	}*/
}
