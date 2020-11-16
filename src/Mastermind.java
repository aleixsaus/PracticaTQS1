import java.util.ArrayList;
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
	private InterfaceSecretCode iSecretCode;
	private InterfacePlayer iPlayer;
	private GameBoard gameBoard;
	private boolean hasFinished;
	private ArrayList<String> attemptsRecord;

	
	public int getAttempts() {
		return this.attempts;
	}
	
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
		
	public Mastermind() {
		iSecretCode = new SecretCode();
		gameBoard = new GameBoard();
		iPlayer = new Player();
		
		attemptsRecord = new ArrayList<String>();
	}
	
	//USES MOCKOBJECT OF SECRET CODE
	public boolean checkCode(String code) {
		return iSecretCode.checkSecretCode(code);
	}
	
	//USES MOCKOBJECT OF SECRET CODE
	public Clue createClue(Code code) {
		return Clue.createClue(code, iSecretCode.getSecretCode());
	}
	
	public String sortClue(String unsortedClue) {
		return Clue.sortClue(unsortedClue);
	}
	
	public void addCodeToGameBoard(Code code, GameBoard gameBoard) {
		//Add a code to the record
		gameBoard.addCodeRecord(code);
	}
	
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
	
	//We simulate a player playing with the MOCK OBJECT - MOCKJUGADOR
	public void playerPlaysGame() {
		attempts = 0;
		while(!hasFinished) {
			if(attempts <= MAX_ATTEMPTS) {
				String playerCode = iPlayer.enterCode(); 
				attemptsRecord.add(playerCode);
				while(playerCode == null) {
					playerCode = iPlayer.enterCode();
				}
				enterCode(playerCode);
				attempts++;
			} else {
				hasFinished = true;
				System.out.println("HAS PERDUT! INTENTS ESGOTATS!");
			}
		}
	}
	
	//Initialize the game and start it
	//USES MOCKOBJECT OF SECRET CODE
	public void enterCode(String code) {
        hasFinished = false;
		this.attempts++;
        if (hasAttempts()) {              
	        if (!checkCode(code)) {
	            System.out.println("You have failed!");
	            addCodeToGameBoard(new Code(code), gameBoard);
	            addClueToGameBoard(Clue.createClue(new Code(code), iSecretCode.getSecretCode()), gameBoard);
	            gameBoard.designGameBoard();
	            System.out.println(gameBoard.getGameBoardDesign());
	   
	        } else {
	        	addCodeToGameBoard(new Code(code), gameBoard);
	        	addClueToGameBoard(Clue.createClue(new Code(code), iSecretCode.getSecretCode()), gameBoard);
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
		this.iSecretCode = mockSecretCode;
	}
	
    public boolean hasFinished() {
    	return hasFinished;
    }
}