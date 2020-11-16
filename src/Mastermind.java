import java.util.ArrayList;
import java.util.HashMap;

public class Mastermind {

	static int LENGTH_CODE = 4;
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
	private boolean hasWinned;
	private ArrayList<String> attemptsRecord;
	private ArrayList<String> colorsToPlay;

	
	public int getAttempts() {
		return this.attempts;
	}
	
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	public ArrayList<String> getColorsToPlay() {
		return colorsToPlay;
	}
		
	public Mastermind() {
		iSecretCode = new SecretCode();
		gameBoard = new GameBoard();
		iPlayer = new Player();
		colorsToPlay = new ArrayList<String>();
		attemptsRecord = new ArrayList<String>();
	}
	
	//USES MOCKOBJECT OF SECRET CODE
	public boolean checkCode(String code) {
		return iSecretCode.checkSecretCode(code);
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
		if (this.attempts < MAX_ATTEMPTS) {
			return true;
		}
		return false;
	}
	
	//We simulate a player playing with the MOCK OBJECT - MOCKPLAYER
	public void playerPlaysGame() {
		attempts = 0;
		while(!hasFinished) {
			if(attempts < MAX_ATTEMPTS) {
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
	
	//We simulate a player setting difficult with the MOCK OBJECT - MOCKPLAYER
	public int playerSetsDifficult() {
		return iPlayer.enterDifficult(); 
	}
	
	//Sets the difficult of the game.
	public void setDifficult(int playerDifficult) {
		for (int i = 0; i < playerDifficult; i++) {
			Object firstKey = Mastermind.COLORS.keySet().toArray()[i];
			String valueForFirstKey = Mastermind.COLORS.get(firstKey);
			
			colorsToPlay.add(valueForFirstKey);
		}
	}
	
	//Initialize the game and start it
	//USES MOCKOBJECT OF SECRET CODE
	public void enterCode(String code) {
        hasFinished = false;
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
	            hasWinned = true;
	            System.out.println("You have won!");
	        }
    }
	
	//To test Path Coverage
	public int simulationPathCoverage(int A, int B, int C) {
		if (A == 50) {
			if (B > C) {
				A = B;			
			} else {
				A = C;
			}
		}		
		return A;
	}
	
	//FUNCTION TO TEST THE MOCK OBJECTS WITH OUR MOCK
	public void setSecretCode(MockSecretCode mockSecretCode) {
		this.iSecretCode = mockSecretCode;
	}
	
	//FUNCTION TO TEST THE MOCK OBJECTS WITH OUR MOCK
	public void setPlayer(MockPlayer mockPlayer) {
		this.iPlayer = mockPlayer;
	}
	
    public boolean hasFinished() {
    	return hasFinished;
    }
    
    public boolean hasWinned() {
    	return hasWinned;
    }
}