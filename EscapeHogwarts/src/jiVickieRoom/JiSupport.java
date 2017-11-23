package jiVickieRoom;

public interface JiSupport {

	
	//create the box: foundation of the game
	void startGame(); 
	
	void directions();
	
	//void createTheGrid();
	
	//start asking questions such as what is the coordinates the user wants to put the number in
	//ask two questions: coordinates and number 
	
	//void fixedNumbersInBox(); //add one number from the 9 numbers and everytime it runs, the number will appear randomly.
	
//	void gameDialogue(); //dialogue during the game (theme)
	
	void backgroundStory(); //npc talks to harry before playing the game
	
	
	
	
	//void oneNumber(); //make sure only one number is up on the grid at a time; replace old spot with space "nothing"
	
	
	
	void endGame(); //ends game and gets reward//
	
	void getInput();
	
	void placeNumOnGrid();
	
	void displayTheGrid();
	
	//void placeNumbers(String nums);
	
	void complete();
	
	 void doNotOverride();
	 
	 void error();
}