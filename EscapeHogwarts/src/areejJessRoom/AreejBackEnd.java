package areejJessRoom;

import java.util.Arrays;
import areejJessRoom.JessicaFrontEnd;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private static int[][] board;
	
	
	//0 EQUALS NULL
	//1 EQUALS USER
	//2 EQUALS COMPUTER
	
	public AreejBackEnd(AreejSupport frontend) {
		this.frontend = frontend;
		board = new int[6][7];
	//	board = AreejJessBoard.getBoard();
		populateBoard(board);
		
	}
	private int row;
	private int col;

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
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
		for(int i =0; i< board.length; i ++) {
			for(int j = 0; j <board[i].length; j++) {
				
			if(checkHorizontal() || checkVertical() ||
					checkDiagonalRight() || checkDiagonalLeft())
			{
				//i have no idea if this logic even makes sense
				String place = Integer.toString(board[i][j]);
				
				if(place.equals("U")) {
					JessicaFrontEnd.isUserWon(true);
				}
				else if(place.equals("C")) {
					JessicaFrontEnd.isComputerWon(true);
				}
			}
		}
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

	public static void moveUser(int userInt) {
		
	//	int[][] board = AreejJessBoard.getBoard();
	//	populateBoard(board);
		String[][] boardFront = JessicaFrontEnd.getBoard();
		board = new int[6][7];
		populateBoard(board);
		//maybe no boolean arr but just string array
		
				if(board[5][userInt] == 0)
				{
					board[5][userInt] = 1;
					JessicaFrontEnd.placeCoord(5,userInt, "user");
				//	System.out.print(Arrays.toString(board));
				}
			
			
	
	}

	private static void populateBoard(int[][] board2) {
		//System.out.println(board2.length);
		for(int i = 0; i < board2.length; i++) {
			for(int j =0; j < board2[i].length; j++) {
				board2[i][j] = 0;
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
				//JessicaFrontEnd.placeCoord(i,compInt, "computer");
			}
			
		}
		}
	

	public static boolean validateMove(int column) {
		
		return false;
	}

}