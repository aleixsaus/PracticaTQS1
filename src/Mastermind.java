public class Mastermind {

	public Mastermind() {
		
	}
	
	public boolean checkCode(String secretCode, String playerCode) {
		return secretCode.equals(playerCode);
	}
	
	public String generateCode() {
		return "ABCD";
	}
	
	public void addCodeToGameBoard(String code, GameBoard gameBoard) {
		gameBoard.addCodeRecord(code);
	}
	
	public void addClueToGameBoard(String clue, GameBoard gameBoard) {
		gameBoard.addClueRecord(clue);
	}
}
