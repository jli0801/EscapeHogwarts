package areejJessRoom;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private static int[][] board;
	private static String user;
	private static String computer;
	public AreejBackEnd(AreejSupport frontend) {
		this.frontend = frontend;
		user = "U";
		computer = "C";
			}


	public static void main(String[] args) {
		

	}



	public int[][] getBoard() {
		
		return board;
	}
	//create for loops
	
	//check for both user and AI
	public void checkWinner()
	{
		if(checkHorizontal() || checkVertical() ||
				checkDiagonalRight() || checkDiagonalLeft())
		{
			
		}
		
		
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

	public static void userMove(int userInt) {
		
	
			for(int i = board.length ; i <0;i--) {
				if(board[i][userInt] == 0)
				{
					board[i][userInt] = 1;
					JessicaFrontEnd.placeCoord(i,userInt,user);
				}
				
			}
	
	}

	public static void computerMove() {
		int compInt = (int)(Math.random()* 6);
		while(!validateMove(compInt))
		{
			compInt = (int)(Math.random()* 6);
		}
		for(int i = board.length ; i <0;i--) {
			if(board[i][compInt] == 0)
			{
				board[i][compInt] = 1;
				JessicaFrontEnd.placeCoord(i,compInt,user);
			}
			
		}
		}
	



	public static boolean validateMove(int column) {
		
		return false;
	}

}