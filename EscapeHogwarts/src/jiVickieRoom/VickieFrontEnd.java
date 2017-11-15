package jiVickieRoom;

public class VickieFrontEnd implements JiSupport{

	private VickieSupport backend;
	
	public VickieFrontEnd() {
		backend = new JiBackEnd(this);
	}


	@Override
	public void giveDirections() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fixedNumbersInBox() {
		// TODO Auto-generated method stub
	}

	
	public void gameDialogue() {
		
	}
	
	public void endGame() {
		
	}


	public static void userEntered() {
		JiBackEnd.createTheBox();
		
	}


	@Override
	public void backgroundStory() {
		// TODO Auto-generated method stub
		
	}
	

}
