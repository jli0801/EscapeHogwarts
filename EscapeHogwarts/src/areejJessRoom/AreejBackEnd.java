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

	public static void compMove(){
	//	int[][] arr = getBoard();
		int comp = (int)(Math.random()*6);
		System.out.println("My turn now! I'll place a Galleon here!");
		int i = board.length -1;
		while (i > 0)
		{
		if(board[1][comp] != 0)
		{
			comp = (int)(Math.random()*6);	
		//	compMove();
		}
		
			if(board[i][comp] == 0){
				board[i][comp] = 2;
				JessicaFrontEnd.placeCoord(i,comp, "computer");
				setUserMove(true);
				System.out.println("Your turn now! Enter a number from 0 to 6.");
				System.out.println((board[i][comp]));
				moveUser();
				
				//checkWinner();
				break;
			}
			else
			{
				
				i--;
				
			}
		}
		
	}
	public static int[][] getBoard() {
		
		return board;
	}
	
	//check for both user and AI
	public static void checkWinner()
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
	
	private boolean checkVertical(char user, char comp, int row, int column) {
		int possibleBottom = Math.max(0, row - 3);
		int possibleTop = possibleBottom + 4;
		int playerCount = 0;
		int opponentCount = 0;
		

		for (int checkRow = possibleBottom; checkRow < possibleTop; checkRow++){
			if (board[checkRow][column] == comp){
				opponentCount = opponentCount + 1;
			} else if (board[checkRow][column] == user){
				playerCount = playerCount + 1;
			}
		}
		 if(playerCount)
	}
	public static boolean checkDiagonalRight() {
		return false;
	}
	public static boolean checkDiagonalLeft() {
		return false;
	}
	public static boolean checkHorizontal() {
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
			if(checkValid(userInput))
			{
				int userInt = Integer.parseInt(userInput);
			//	System.out.println("in");
				
				if (board[1][userInt] == 1 && !JessicaFrontEnd.isUserWon())
				{
					System.out.println("The column is full. Pick another column!");
					moveUser();
				}
				int i = board.length -1;
				while (i > 0)
				{
				//	System.out.println("for");
					if(board[i][userInt] == 0)
					{
						board[i][userInt] = 1;
						JessicaFrontEnd.placeCoord(i,userInt, "user");
						setUserMove(false);
						
						break;
					}
					else
					{
						i--;
					}
					
				}
				if(userMove == false) {
					compMove();
				}
			}
	
			else
			{
				
				System.out.println("Pick a number between 0 and 6!");
				moveUser();
				
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
	public static boolean validateMove(int column) {
		
		return false;
	}
	
}
