package jiVickieRoom;

public interface JiSupport {

	void createTheBox();
	//create the box: foundation of the game
	
	void giveDirections();
	
	void beginGame(); //start asking questions such as what is the coordinates the user wants to put the number in
	//ask two questions: coordinates and number 
	
	void fixedNumbersInBox();//add one number from the 9 numbers and everytime it runs, the number will appear randomly.
	
	void gameDialogue();
	
	void endGame();
}
