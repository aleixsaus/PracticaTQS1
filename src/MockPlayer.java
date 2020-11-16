import java.util.ArrayList;
import java.util.Map.Entry;

public class MockPlayer implements InterfacePlayer{

	private ArrayList<String> playerPlays = new ArrayList<String>();
	private String playerDifficult;
	private int playsDone = 0;

	public void addPlayerPlay(String play){
		this.playerPlays.add(play);
	}
	
	public void setPlayerDifficult(String playerDifficult){
		this.playerDifficult = playerDifficult;
	}
	
	@Override
	public String enterCode() {
		System.out.println("Colors:");
		
		printColorsList();
		
		System.out.println("What is the secret code?");
		
		//We read the entered code by the player (MOCKOBJECT of Player) 
		String playerCode = playerPlays.get(playsDone);
		this.playsDone++;

		if(!checkEnteredCode(playerCode)) {
			return null;
		}
		return playerCode;		
	}
	
	@Override
    public int enterDifficult() {
    		System.out.println("Select  difficult:");
    		
    		printColorsList();
    		
    		System.out.println("What difficulty do you want to play on? 1 - 8");
    		
    		//We read the entered difficult by the player (MOCKOBJECT of Player) 
    		return checkDifficult(Integer.parseInt(playerDifficult));
    }

	//Prints the list of colors (key, value).
    public void printColorsList() {
    	for (Entry<Character, String> color : Mastermind.COLORS.entrySet()) {
		    Character colorCode = color.getKey();
		    String colorValue = color.getValue();
		    
		    System.out.println(" " + colorCode + ": " + colorValue);
		}
    }
    
    //Checks if the entered difficult has the expected format.
    public int checkDifficult(int difficult) {
    	//Decision Coverage.
    		
		//We check that the entered difficult has the possible values.
		if(difficult <= 8 && difficult > 0) {			
			System.out.print("Difficult set to: " + difficult);
			return difficult;
		} else {
			System.out.println("The difficult must be between 1 and 8.");
			return 0;
		}
	}
    
    //Checks if the entered code has the expected format.
    public boolean checkEnteredCode(String code) {
		//We check that the entered code has the expected length.
		if(code.length() == Mastermind.LENGTH_CODE ) {	
			//We loop all the entered characters.
			for (int i = 0; i < code.length(); i++) {
				char caracterC = code.charAt(i);
			
				//Checks if every character matches with the possible characters. 
				if(!Mastermind.COLORS.containsKey(caracterC)) {
					System.out.print("The code must be the combination the following colors:");
					
					//Shows all colors.
					printColorsList();
					
					return false;
				}
			}
			return true;
		} else {
			System.out.println("The code must have a length of " + Mastermind.LENGTH_CODE + ".");
			return false;
		}
	}

}
