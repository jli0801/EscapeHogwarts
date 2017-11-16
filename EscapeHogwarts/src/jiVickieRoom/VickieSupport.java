package jiVickieRoom;

public interface VickieSupport {

	void checkMultiples(String character);
	//when adding numbers to game, add in array
	
	String usedNumbers();
	//checks throughout the string to see if the number is used, and if it is, replace the number on the game (front end)

	//void startGame();
	
	void checkTotal();
	//compare rows to total
	
	String validNumbers();
	//gives valid numbers
	
	//*** FRONT END
	//void notifyNumbers(); 
	//tells to use only numbers
	//*** FRONT END
	//public void notifyNumbers() {
		//	System.out.println("You can only type a number.");
		//}
	
	void cheatCode();
	//cheatCode
}
//
