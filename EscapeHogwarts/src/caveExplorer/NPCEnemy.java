package caveExplorer;

public class NPCEnemy extends NPC {

	//fields needed to program navigation
	private CaveRoom[][]floor; //area where NPC roams
	private int currentRow;
	private int currentCol;
	private static NPCRoomEnemy currentRoom;
	//are about interaction with NPC
	private static boolean active;
	private String activeDescription;
	private String inactiveDescription;
	private static boolean defeat;
	private static int enemyHealth; //NPCEnemy
	
	
	//might add more fields to make NPC behave like a chatbot
	public NPCEnemy() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "Why are you here!? You'll have to fight me to get past me!";
		this.inactiveDescription = "You have defeated me already. Begone!";
		//by default NPC doesn't have position use coordinate (-1,-1)
		this.currentCol = -1;
		this.currentRow = -1;
		enemyHealth = 100;
		currentRoom = null;
		active = true;
		defeat = false;
		startInteraction();
	}

	public boolean isActive() {
			
			return active;
		}
	
	public void startInteraction()
	{
		if(!defeat && active)
		{
			startFight();
		}
		else
		{
			System.out.println(inactiveDescription);
		}
	}
	
	public static void startFight() {
		boolean defendE = false;
		boolean defendU = false;
		
		
		int playerHealth = Inventory.getHp();
		int attackP = Inventory.getAttack(); //make sure its random
		while(playerHealth > 0 || enemyHealth > 0 )
		{
			int attackE = (int)(Math.random()*10)+1; 
			
			if(active)
			{
				CaveExplorer.print("My turn! Take this!");
				playerHealth -= attackE;
				CaveExplorer.print("Snape's health decreased by " + attackE + " points. His health is " + playerHealth + ".");
				active = false;
			}
			else
			{
				CaveExplorer.print("Your turn now! Not like you can defeat me.");
				enemyHealth -= attackP;
			}
		}
		
	}
	
	
	public String getDescription() {
		
		return activeDescription;
	}
	
	public String getInactiveDescription() {
	
		return inactiveDescription;
	}
	public String getSymbol()
	{
		return "E";
	}
	
	public void setPosition(int row, int col)
	{
		//array is from [6][6]
		if(row >= 0 && row < floor.length && col >=0 && col < floor[row].length
				&& floor[row][col] instanceof NPCRoomEnemy)
		{
			if(currentRoom != null)
			{
				currentRoom.leaveNPC();
			}
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoomEnemy) floor[row][col];
			
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
		while(currentRoom.getDoor(index) == null || 
				!(CaveExplorer.caves[newPosition[0]][newPosition[1]] instanceof
						NPCRoomEnemy))
		{
			index = (int)(Math.random()*possibleMoves.length);
			newPosition[0] = currentRow + possibleMoves[index] [0];
			newPosition[1] = currentCol + possibleMoves[index] [1];
		}
		return newPosition;
	}

}
