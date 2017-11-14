package areejJessRoom;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private AreejJessBoard[][] board;

	public AreejBackEnd(AreejSupport frontend) {
		this.frontend = frontend;
		board = new AreejJessBoard[6][7];
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	public AreejJessBoard[][] getPlots() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void checkHorizontal() {
		
	}
	public void checkVertical() {
		
	}
	public void checkDiagonalRight() {
	
	}
	public void checkDiagonalLeft() {
	
	}

}
