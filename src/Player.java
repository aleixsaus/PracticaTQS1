import java.util.Map.Entry;
import java.util.Scanner;

public class Player {

	private Scanner scanner = new Scanner(System.in);

    public String enterCode() {
    		System.out.println("Colors:");
    		
    		printColorsList();
    		
    		System.out.println("What is the secret code?");
    		
			if (scanner.hasNextLine()) {
				String response = scanner.nextLine().toUpperCase().trim();
				
				if(!checkEnteredCode(response)) {
					return null;
				} else {
					return response;
				}
			} else {
				return null;
			}
    }
    
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
