package jiVickieRoom;

public class VickieFrontEnd implements JiSupport{

	private VickieSupport backend;
	
	public VickieFrontEnd() {
		backend = new JiBackEnd(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
