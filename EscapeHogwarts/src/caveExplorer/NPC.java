package caveExplorer;

public class NPC {

	//fields needed to program navigation
	private CaveRoom[][]floor; //area where NPC roams
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	//are about interaction with NPC
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	//might add more fields to make NPC behave like a chatbot
	
	
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person standing in the room, "
				+ "waiting to talk to you. Press 'e' to talk";
		this.inactiveDescription = "The person you talked to earlier is stil here.";
		//by default NPC doesn't have position use coordinate (-1,-1)
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}
	public boolean isActive() {
		
		return active;
	}

	public void interact() {
		
		CaveExplorer.print("Let's interact! The 'bye' to stop.");
		String s =CaveExplorer.in.nextLine();
		while(!s.equals("bye"))
		{
			CaveExplorer.print("Yeah..I don't wanna");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later!");
		active = false;
	}

	public String getDescription() {
		
		return activeDescription;
	}

	public String getInactiveDescription() {
	
		return inactiveDescription;
	}
	public String getSymbol()
	{
		return "P";
	}

	public void setPosition(int row, int col)
	{
		//array is from [6][6]
		if(row >= 0 && row < floor.length && col >=0 && col < floor[row].length
				&& floor[row][col] instanceof NPCRoom)
		{
			if(currentRoom != null)
			{
				currentRoom.leaveNPC();
			}
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom) floor[row][col];
		}
	}
	public void autoMove() {
	if(active)
	{
		int[] move = calculateMove();
		int newRow = move[0];
		int newCol = move[1];
		setPosition(newRow,newCol);
	}
		
	}
	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0}, {0,1}, {1,0}, {0, -1}};
		//N E S W
		int index = (int)(Math.random()*possibleMoves.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow + possibleMoves[index] [0];
		newPosition[1] = currentCol + possibleMoves[index] [1];
		while(currentRoom.getDoor(index) == null || 
				!(CaveExplorer.caves[newPosition[0]][newPosition[1]] instanceof
						NPCRoom))
		{
			index = (int)(Math.random()*possibleMoves.length);
			newPosition[0] = currentRow + possibleMoves[index] [0];
			newPosition[1] = currentCol + possibleMoves[index] [1];
		}
		return newPosition;
	}

}
