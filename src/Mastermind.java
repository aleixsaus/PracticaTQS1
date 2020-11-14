
public class Mastermind {

	public Mastermind() {
		
	}
	
	public boolean checkCode(String secretCode, String playerCode) {
		return secretCode.equals(playerCode);
	}
}
