import java.util.ArrayList;
import java.util.Map.Entry;

public class MockPlayer implements InterfacePlayer{

	private ArrayList<String> playerPlays = new ArrayList<String>();
	private int playsDone = 0;

	void addPlayerPlay(String play){
		this.playerPlays.add(play);
	}
	
	@Override
	public String enterCode() {
		System.out.println("Colors:");
		
		printColorsList();
		
		System.out.println("What is the secret code?");
		
		//We reed the entered code by the player (MOCKOBJECT of Player) 
		String playerCode = playerPlays.get(playsDone);
		this.playsDone++;

		if(!checkEnteredCode(playerCode)) {
			return null;
		}
		return playerCode;		
	}

	//Prints the list of colors (key, value).
    public void printColorsList() {
    	for (Entry<Character, String> color : Mastermind.COLORS.entrySet()) {
		    Character colorCode = color.getKey();
		    String colorValue = color.getValue();
		    
		    System.out.println(" " + colorCode + ": " + colorValue);
		}
    }
    
    //Checks if the entered code has the expected format.
    public boolean checkEnteredCode(String code) {
    	//Decision Coverage.
    	
    	//We check if the entered code is null.
		if(code == null) {
			System.out.println("The entered code is NULL.");
			return false;
		}
		
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
