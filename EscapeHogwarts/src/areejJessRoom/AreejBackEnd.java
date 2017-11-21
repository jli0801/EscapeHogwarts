package areejJessRoom;

import java.util.Arrays;
import areejJessRoom.JessicaFrontEnd;
import caveExplorer.CaveExplorer;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private static int[][] mainBoard;
	private static boolean userMove;
	private static int[][]tempBoard;
	//0 EQUALS NULL
	//1 EQUALS USER
	//2 EQUALS COMPUTER
	
	public AreejBackEnd(AreejSupport frontend) {
		this.frontend = frontend;
		mainBoard = new int[6][7];
		userMove = true;
	//	board = AreejJessBoard.getBoard();
		populateBoard(mainBoard);
		
		
	
		
	}
	public static void setUserMove(boolean userMove) {
		AreejBackEnd.userMove = userMove;
	}
	
	public static int[][] getMainBoard()
	{
		
		return mainBoard;
	}
	public static void compMove(){
		int[][] mainBoard1 = getBoard();
		int comp = (int)(Math.random()*6);
		System.out.println("My turn now! I'll place a Galleon here!");
		int y = mainBoard1.length - 1;
		if(mainBoard1[1][comp] != 0)
		{
			comp = (int)(Math.random()*6);	
		//	compMove();
		}
		while (y > 0)
		{
		
		
			if(mainBoard1[y][comp] == 0)
			{
				mainBoard1[y][comp] = 2;
				
				JessicaFrontEnd.placeCoord(y,comp, "computer");
				setUserMove(true);
				System.out.println("Your turn now! Enter a number from 0 to 6.");
				System.out.println((mainBoard1[y][comp]));
				moveUser();
				
				//checkWinner();
				break;
			}
			else
			{
				
				y--;
				
			}
		}
		
	}
	public static int[][] getBoard() {
		
		return mainBoard;
	}
	
	//check for both user and AI
	/*public static void checkWinner()
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
	*/
	public static void moveUser() {
		
	//	String[][] boardFront = JessicaFrontEnd.getBoard();
		
		String userInput = CaveExplorer.in.nextLine();
		
	//	int[][] mainBoard1 = getBoard();
		
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
				int[][]tempBoard = getMainBoard();
				
				if (tempBoard[1][userInt] == 1 && !JessicaFrontEnd.isUserWon())
				{
					System.out.println("The column is full. Pick another column!");
					moveUser();
				}
				int i = tempBoard.length -1;
				while (i > 0)
				{
				//	System.out.println("for");
					if(tempBoard[i][userInt] == 0 ) 
					{
						tempBoard[i][userInt] = 1;
					//	mainBoard1[i][userInt] = 1;
					//	board1[i][userInt] = 1;
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
					
					int comp = (int)(Math.random()*6);
					System.out.println("My turn now! I'll place a Galleon here!");
					int y = tempBoard.length - 1;
					if(tempBoard[1][comp] != 0)
					{
						comp = (int)(Math.random()*6);	
					//	compMove();
					}
					while (y >= 0)
					{
					
					
						if(tempBoard[y][comp] == 0)
						{
							tempBoard[y][comp] = 2;
							
							JessicaFrontEnd.placeCoord(y,comp, "computer");
							setUserMove(true);
							System.out.println("Your turn now! Enter a number from 0 to 6.");
							System.out.println((tempBoard[y][comp]));
							moveUser();
							
							//checkWinner();
							break;
						}
						else
						{
							
							y--;
							
						}
					}
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
