package areejJessRoom;

import java.util.Arrays;
import areejJessRoom.JessicaFrontEnd;
import caveExplorer.CaveExplorer;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private static int[][] mainBoard;
	private static boolean userMove;

	public AreejBackEnd(JessicaFrontEnd jessicaFrontEnd) {
	}
	public static void initialize()
	{
		mainBoard = new int[6][7];
		userMove = true;
		populateBoard(mainBoard);
		moveUser();
	
	}
	public static void setUserMove(boolean userMove) {
		AreejBackEnd.userMove = userMove;
	}
	
	public static void compMove(){
		int comp = (int)(Math.random()*6);
		System.out.println("My turn now! I'll place a Galleon here!");
		int rowNum = getIndex(mainBoard,comp);
		
		if (rowNum == 0)
		{
			while (mainBoard[0][comp] != 0 && !JessicaFrontEnd.isComputerWon())
			{
				int comp1 = (int)(Math.random()*6);
			}
		}
		mainBoard[rowNum][comp] = 2;
		JessicaFrontEnd.placeCoord(rowNum,comp, "computer");
		checkWinner(rowNum,comp,2);
		setUserMove(true);
		System.out.println("Your turn now! Enter a number from 0 to 6.");
				
		moveUser();
				
	}

	public static void moveUser() {
	
		String userInput = CaveExplorer.in.nextLine();
		if(userInput.equals("voldemort"))
		{
			System.out.println("No! Not Voldemort! You win!");
			JessicaFrontEnd.setUserWon(true);
		}
		else
		{
		
			if(checkValid(userInput))
			{
				
					int userInt = Integer.parseInt(userInput);
					int rowNum = getIndex(mainBoard,userInt);
					if (rowNum == 0)
						
					{
						if(mainBoard[0][userInt] != 0 && !JessicaFrontEnd.isUserWon())
						{
						System.out.println("The column is full. Pick another column!");
						return;
						}
					}
					
						mainBoard[rowNum][userInt] = 1;
						JessicaFrontEnd.placeCoord(rowNum,userInt, "user");
						checkWinner(rowNum,userInt,1);
						setUserMove(false);
					
				
				if(userMove == false) {
					
					compMove();
				}
			} 
			else
			{
				System.out.println("Pick a number between 0 and 6!");
			}
		}
	
	}
	
	//public static void debugPrint(String s) {
//		System.out.println(s);
	//}
	
	public static int getIndex(int[][] board, int col) {
		for(int[] a: board) {
		//	debugPrint(Arrays.toString(a));
		}
		for(int i = board.length - 1; i > 0; i--) {
			int value = getValue(board, i, col);
			if(value == 0 )
			{
			//	debugPrint("Found next empty space is "+i);
				return i;
				
			}
		}
		return 0;
	//	  return -1;
	}
	
	public static int getValue(int[][] board, int row, int col) {
		return board[row][col];
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
	public static void checkWinner(int r, int c, int player)
	{
		int v = 1;
		int dL = 1;
		int dR = 1;
		int h = 1;
		
		h += checkHoriz(r,c,player);
		v+= checkVert(r,c,player);
		dL+= checkDiagLeft(r,c,player);
		dR+= checkDiagRight(r,c,player);
		
		if(h==4||v==4||dL==4||dR==4){
			switch(player){
				case 2:
						JessicaFrontEnd.setComputerWon(true);
						break;
				case 1:
						JessicaFrontEnd.setUserWon(true);
						break;
			}
		}
		
	}
	
	public static int checkDiagRight(int r, int c,int p){
		
	
		int row = r+1;
		int col = c+2;
		int count = 0;
		while(row<mainBoard.length && col<mainBoard[r].length){
			if(mainBoard[row][col]==p)
				count++;
			else
				break;
			row++;
			col+=2;
		}
		
		row = r-1;
		col = c-1;
		while(row>0 && col>-1){
			if(mainBoard[row][col]==p)
				count++;
			else
				break;
			row--;
			col-=2;
		}
		return count;
	}
	public static int checkDiagLeft(int r,int c,int p){
		
		
		int row = r+1;
		int col = c-2;
		int count = 0;
		while(row<mainBoard.length && col>-1){
			if(mainBoard[row][col]==(p))
				count++;
			else
				break;
			row++;
			col-=2;
		}
		
		row = r-1;
		col = c+2;
		while(row>0 && col<mainBoard[r].length){
			if(mainBoard[row][col]==p)
				count++;
			else
				break;
			row--;
			col+=2;
		}
		return count;
	}
	public static int checkVert(int r, int c, int p) {
		int count = 0;
		for(int row = r-1;row>0;row--){
			if(mainBoard[row][c]==p)
				count++;
			else
				break;
		}
		for(int row = r+1;row<mainBoard.length;row++){
			if(mainBoard[row][c]==p)
				count++;
			else
				break;
		}
		return count;
	}
	public static int checkHoriz(int r, int c,int p) {
		int count=0;
		for(int col = c-2;col>-1;col-=2){
			if(mainBoard[r][col]==p)
				count++;
			else
				break;
		}
		for(int col = c+2;col<mainBoard[0].length;col+=2){
			if(mainBoard[r][col]==p)
				count++;
			else
				break;
		}
		return count;
	}
}
