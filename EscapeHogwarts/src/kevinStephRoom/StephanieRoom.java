package kevinStephRoom;

import java.util.Scanner;
import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Door;
import caveExplorer.Inventory;
import caveExplorer.NPCRoom;
import caveExplorer.NPC;
//THEMATIC ROOM 3
public class StephanieRoom extends CaveRoom {
	
	public static CaveRoom[][] c = CaveExplorer.caves;

	public StephanieRoom(String description) {
		super(description);
		
	}
	public String validMoves() {
		return "wdsaeo";
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "

				+ "or you can press 'e' to interact and 'o' to ignore.");
	}
	
	private static String getUserInput()
	{
		 String input = CaveExplorer.in.nextLine().toLowerCase();
		 return input;
	}
	
	public static boolean getYesNo() {
		String input = getUserInput();
		if(input.equals("yes") || input.equals("no")){
			return true;
		}
		return false;
	}
	
	public static void answerQuestion(){
		if(CaveExplorer.in.nextLine().toLowerCase().equals("yes")) {
			recieveMoney();
		}else{
			CaveExplorer.print("Dumbledore has kicked you out of the room.");
		}
	}
	
	public static void recieveMoney() {
		int userMoney = Inventory.getMoney() + (int)(Math.random()*25);
		Inventory.setMoney(userMoney);
		CaveExplorer.print("You have recieved " + userMoney + " galleons from Dumbledore.");
	}
	
	public static void userEntered() {
		CaveExplorer.print("You enter the room and look around but nothing is inside...\n"
				+ "Suddenly, someone taps your back and you see Dumbledore behind you. Press 'e' to interact or 'o' to ignore him and leave the room.");
		String input = CaveExplorer.in.nextLine().toLowerCase();
		if(input.equals("e")) {
			CaveExplorer.print("Dumbledore says: 'What are you doing in here?? I'll give you some money if you get out!'\n"
					+ "Do you take on his ofer? Please type 'yes' or 'no'.");
			answerQuestion();
		}else if(input.equals("o")) {
			CaveExplorer.print("You have left the room.");
		}
		
	}
}	