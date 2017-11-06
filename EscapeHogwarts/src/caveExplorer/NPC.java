package caveExplorer;

public class NPC {

	//fields needed to program navigation
	protected CaveRoom[][]floor; //area where NPC roams
	public int currentRow;
	protected int currentCol;
	private NPCRoom currentRoom;
	//are about interaction with NPC
	private boolean active;
	private String activeDescription; //Changesdd from private to protected
	protected String inactiveDescription;
	//might add more fields to make NPC behave like a chatbot
	
	
	public NPC() {
		this.setFloor(CaveExplorer.caves);
		this.setActiveDescription("There is a person standing in the room, "
				+ "waiting to talk to you. Press 'e' to talk");
		this.inactiveDescription = "The person you talked to earlier is stil here.";
		//by default NPC doesn't have position use coordinate (-1,-1)
		this.currentCol = -1;
		this.currentRow = -1;
		setCurrentRoom(null);
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
		
		return getActiveDescription();
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
		if(row >= 0 && row < getFloor().length && col >=0 && col < getFloor()[row].length
				&& getFloor()[row][col] instanceof NPCRoom)
		{
			if(getCurrentRoom() != null)
			{
				getCurrentRoom().leaveNPC();
			}
			currentRow = row;
			currentCol = col;
			setCurrentRoom((NPCRoom) getFloor()[row][col]);
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
	public int[] calculateMove() {
		int[][] possibleMoves = {{-1,0}, {0,1}, {1,0}, {0, -1}};
		//N E S W
		int index = (int)(Math.random()*possibleMoves.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow + possibleMoves[index] [0];
		newPosition[1] = currentCol + possibleMoves[index] [1];
		while(getCurrentRoom().getDoor(index) == null || 
				!(CaveExplorer.caves[newPosition[0]][newPosition[1]] instanceof
						NPCRoom))
		{
			index = (int)(Math.random()*possibleMoves.length);
			newPosition[0] = currentRow + possibleMoves[index] [0];
			newPosition[1] = currentCol + possibleMoves[index] [1];
		}
		return newPosition;
	}
	public NPCRoom getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(NPCRoom currentRoom) {
		this.currentRoom = currentRoom;
	}
	public CaveRoom[][] getFloor() {
		return floor;
	}
	public void setFloor(CaveRoom[][] floor) {
		this.floor = floor;
	}
	public String getActiveDescription() {
		return activeDescription;
	}
	public void setActiveDescription(String activeDescription) {
		this.activeDescription = activeDescription;
	}

}
