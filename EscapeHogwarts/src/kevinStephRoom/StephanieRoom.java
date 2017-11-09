package kevinStephRoom;

import java.util.Scanner;
import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPCRoom;
import caveExplorer.NPC;

public class StephanieRoom extends NPCRoom {
	

	public StephanieRoom(String description) {
		super(description);
		
	}
	
/**	public String validMoves() {
		return "wdsa";
	}
	
	public void printValidMoves()
	{
		System.out.println("You can only enter 'w', 'a', 's', or 'd'");//
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printValidMoves();
			
			input = CaveExplorer.in.nextLine();
		}
		int direction =  validMoves().indexOf(input); 
		if(direction < 4) {
			goToRoom(direction);
		}else {
			performAction(direction);
		}
		
	}

	
	private boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	
	public void performAction (int direction)
	{
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				npc.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}
**/
	
	public static void userEntered() {
		CaveExplorer.print("You see a mirror in front of you. Do you want to look into it?");
		String input = CaveExplorer.in.nextLine().toLowerCase();
		if(input.equals("yes")){
			CaveExplorer.print("You see the exit of Hogwarts  ");
		}
	}
}	
	
