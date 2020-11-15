import java.util.HashMap;

public class Mastermind {

	static final int LENGTH_CODE = 4;
	static final int MAX_ATTEMPTS = 12;
	
	static final HashMap<Character, String> COLORS = new HashMap<Character, String>();
	
	static {
		COLORS.put('R', "Red");
		COLORS.put('B', "Blue");
		COLORS.put('G', "Green");
		COLORS.put('Y', "Yellow");
		COLORS.put('O', "Orange");
		COLORS.put('V', "Violet");
		COLORS.put('W', "White");
		COLORS.put('P', "Pink");
	}
	
	private int attempts;
	
	public int getAttempts() {
		return this.attempts;
	}
	
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	private SecretCode secretCode;

	
	public Mastermind() {
		secretCode = new SecretCode();
	}
	
	public boolean checkCode(String code) {
		return secretCode.checkSecretCode(code);
	}
	
	public Clue createClue(Code code) {
		return Clue.createClue(code, secretCode);
	}
	
	public void addCodeToGameBoard(Code code, GameBoard gameBoard) {
		gameBoard.addCodeRecord(code);
	}
	
	public void addClueToGameBoard(Clue clue, GameBoard gameBoard) {
		gameBoard.addClueRecord(clue);
	}
	
	public void increaseAttempts() {
		this.attempts++;
	}
	
	public boolean hasAttempts() {
		return (this.attempts < MAX_ATTEMPTS);
	}
}