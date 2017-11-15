package areejJessRoom;

public class AreejJessBoard {

	public AreejJessBoard() {
		
	}

	public static void main(String[] args) {
		

	}

	public static String[][] makeBoard(int r, int c){
		
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
	}
}
