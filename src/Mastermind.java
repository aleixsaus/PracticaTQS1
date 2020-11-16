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
	
	//NEEDED FOR THE MOCKOBJECTS
	private InterfaceSecretCode isecretCode;
	private GameBoard gameBoard;
	private boolean hasFinished;
	
	public int getAttempts() {
		return this.attempts;
	}
	
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	private SecretCode secretCode;
	
	public Mastermind() {
		isecretCode = new SecretCode();
		gameBoard = new GameBoard();
	}
	
	//USES MOCKOBJECT OF CODE
	public boolean checkCode(String code) {
		return secretCode.checkSecretCode(code);
	}
	
	//USES MOCKOBJECT OF CODE
	public Clue createClue(Code code) {
		return Clue.createClue(code, secretCode);
	}
	
	//USES MOCKOBJECT OF CODE
	public String sortClue(String unsortedClue) {
		return Clue.sortClue(unsortedClue);
	}
	
	//MOCKOBJECT OF GAMEBOARD
	public void addCodeToGameBoard(Code code, GameBoard gameBoard) {
		//Add a code to the record
		gameBoard.addCodeRecord(code);
	}
	
	//MOCKOBJECT OF GAMEBOARD
	public void addClueToGameBoard(Clue clue, GameBoard gameBoard) {
		//Add a clue to the record
		gameBoard.addClueRecord(clue);
	}
	
	public void increaseAttempts() {
		this.attempts++;
	}
	
	public boolean hasAttempts() {
		return (this.attempts < MAX_ATTEMPTS);
	}
	
	public void printInstructions() {
		System.out.println("INSTRUCTIONS");
	}
	
	//Initialize the game and start it
	//USES MOCKOBJECT OF CODE AND GAMEBOARD
	public void enterCode(String code) {
		this.attempts++;
        if (hasAttempts()) {              
	        if (!checkCode(code)) {
	            System.out.println("You have failed!");
	            addCodeToGameBoard(new Code(code), gameBoard);
	            addClueToGameBoard(Clue.createClue(new Code(code), secretCode), gameBoard);
	            gameBoard.designGameBoard();
	            System.out.println(gameBoard.getGameBoardDesign());
	   
	        } else {
	        	addCodeToGameBoard(new Code(code), gameBoard);
	        	addClueToGameBoard(Clue.createClue(new Code(code), secretCode), gameBoard);
	            gameBoard.designGameBoard();
	            hasFinished = true;
	            System.out.println("You have won!");
	        }
        } else {
        	System.out.println("You have lost!");
        }
    }
	
	//FUNCTION TO TEST THE MOCK OBJECTS WITH OUR MOCK
	public void setSecretCode(MockSecretCode mockSecretCode) {
		this.isecretCode = mockSecretCode;

	}
	
    public boolean hasFinished() {
    	return hasFinished;
    }
}