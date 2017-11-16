package areejJessRoom;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private static AreejJessBoard[][] board;

	public AreejBackEnd(AreejSupport frontend) {
		this.frontend = frontend;
		board = new AreejJessBoard[6][7];
	}

	

	public static void main(String[] args) {
		

	}



	public AreejJessBoard[][] getBoard() {
		
		return board;
	}
	//create for loops
	
	//check for both user and AI
	public String checkWinner()
	{
		if(checkHorizontal() || checkVertical() ||
				checkDiagonalRight() || checkDiagonalLeft())
		{
			
		}
		return "I have won!";
		
		
	}
	
	public boolean checkHorizontal() {
		
		return false;
	}
	public boolean checkVertical() {
		
		return false;
	}
	public boolean checkDiagonalRight() {
		return false;
	}
	public boolean checkDiagonalLeft() {
		return false;
	}



	public static void putPiece(int column) {
	
		for(int row  = 0; row < board.length; row++)
		{
			for(int i =0; i <column; i++)
			{
				if( board[row][column] == null)
				{
					
				}
				else
				{
					JessicaFrontEnd.notPossiblePlace();
				}
			}
		}
	
		
	}



	public static void userMove() {
		// TODO Auto-generated method stub
		
	}



	public static boolean getValidMove() {
		// TODO Auto-generated method stub
		return false;
	}



	public static void computerMove() {
		// TODO Auto-generated method stub
		
	}

}