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
	
	int generateNumber(int max);
	//generates number based on maximum integer
	
	boolean isOuterNumber();
	//returns true if outer else false
	
	int getMid();
	//outlier method when number not outer or inner, mid can only equal 5
	
	void chooseStartingPoint();
	//choose first fixed number
	
	void cheatCode();
	//cheatCode

	int[][] getBoxes();
}
//
