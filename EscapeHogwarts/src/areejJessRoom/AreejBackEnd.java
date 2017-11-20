package areejJessRoom;

import java.util.Arrays;
import areejJessRoom.JessicaFrontEnd;
import caveExplorer.CaveExplorer;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private static int[][] board;
	private static boolean userMove;
	
	
	//0 EQUALS NULL
	//1 EQUALS USER
	//2 EQUALS COMPUTER
	
	public AreejBackEnd(AreejSupport frontend) {
		this.frontend = frontend;
		board = new int[6][7];
		userMove = true;
	//	board = AreejJessBoard.getBoard();
		populateBoard(board);
	
		
	}
	public static void setUserMove(boolean userMove) {
		AreejBackEnd.userMove = userMove;
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
				
				String place = Integer.toString(board[i][j*2 +1]);
				
				if(place.equals("U ")) {
					JessicaFrontEnd.setUserWon(true);
				}
				else if(place.equals("C ")) {
					JessicaFrontEnd.setComputerWon(true);
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

	public static void moveUser() {
		

	//	String[][] boardFront = JessicaFrontEnd.getBoard();
		
		String userInput = CaveExplorer.in.nextLine();

		
		board = new int[6][7];
		populateBoard(board);
		
	//	System.out.println("Where would you like to place your Galleon? Pick a number from 0 to 6.");
		
		if(userInput.equals("voldemort"))
		{
			System.out.println("No! Not Voldemort! You win, leave my room!");
			JessicaFrontEnd.setUserWon(true);
		}
		else
		{
		
	//		int userInt = Integer.parseInt(userInput);
			if(checkValid(userInput) && userMove)
			{
				int userInt = Integer.parseInt(userInput);
			//	System.out.println("in");
				int i = board.length -1;
				if (board[1][userInt] == 1 && !JessicaFrontEnd.isUserWon())
				{
					System.out.println("The column is full. Pick another column!");
				//	moveUser();
				}
				
				while (i > 0)
				{
				//	System.out.println("for");
					if(board[i][userInt] == 0)
					{
					//	System.out.println("empty");
						board[i][userInt] = 1;
						JessicaFrontEnd.placeCoord(i,userInt, "user");
						setUserMove(false);
						break;
					//	System.out.print(Arrays.toString(board));
					}
					else
					{
						i--;
					}
					
				}
				
			}
			else
			{
				if(!userMove)
				{
					//Computer Moves
				}
				else
				{
				System.out.println("Pick a number between 0 and 6!");
				moveUser();
				}
			}
		}
	
	}
	
	private static boolean checkValid(String userInput) {
		
		try{
			int userInt = Integer.parseInt(userInput);
		}
		catch(NumberFormatException nfe){
			return false;
		}
		int userInt = Integer.parseInt(userInput);
		if( userInt <= 6 && userInt >= 0)
		{
			
			return true;
		}
		
		return false;
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