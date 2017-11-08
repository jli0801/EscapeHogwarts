package areejJessRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.Inventory;
import caveExplorer.CaveRoom;

public class AreejRoom extends CaveRoom {

	public AreejRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public static void userEntered() {
		CaveExplorer.print("You've entered a treasure room"
				+ " and gained 5 galleons");
		int userMoney = Inventory.getMoney() + 5;
		Inventory.setMoney(userMoney);
		CaveExplorer.print("Your now have " + userMoney + " galleons.");
		
	}

}
