package jiVickieRoom;

public interface JiSupport {

	void startGame(); //Starts magicSquares Minigame!
	
	void directions();//Displays the rules of the game
	
	void displayTheGrid();//Displays the grid the numbers will be shown on
	
	void placeNumOnGrid();//Updates the grid with either X's or numbers, depending on user input
	
	void getInput();//Gets user input for coordinates and the number they want on the grid
	
	void complete();//Checks if all the boxes on the grid are filled with numbers or not
	
	void doNotOverride();//The given number on the given coordinate can not be changed
	
	void error();//Prints error message
	 
	void endGame(); //Ends game and gets reward
	
	void backgroundStory(); //Peeves talks to Harry (the user) before playing the game, and then after as well as Dumbldore

	
	
	
	
	
	
	
	
	
	
	 
	
}