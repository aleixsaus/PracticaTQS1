import java.util.Map.Entry;
import java.util.Scanner;

public class Player implements InterfacePlayer{

	private Scanner scanner = new Scanner(System.in);
	
	//User interaction, we use the mockObject to testing.
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
    
    //Can not be tested.
    public void printColorsList() {
    	for (Entry<Character, String> color : Mastermind.COLORS.entrySet()) {
		    Character colorCode = color.getKey();
		    String colorValue = color.getValue();
		    
		    System.out.println(" " + colorCode + ": " + colorValue);
		}
    }
    
	//User interaction, we use the mockObject to testing.
    public int enterDifficult() {
    		System.out.println("Select  difficult:");
    		
    		printColorsList();
    		
    		System.out.println("What difficulty do you want to play on? 1 - 8");
    		
			if (scanner.hasNextLine()) {
				String response = scanner.nextLine().toUpperCase().trim();
				
		    	//We check if the entered difficult is null.
				if(response == null || !tryParseInt(response)) {
					System.out.println("The entered difficult is NULL.");
					return 0;
				}
				
				return checkDifficult(Integer.parseInt(response));
			} else {
				return 0;
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
    
    //Utility function to check if a string can be converted to integer.
    public boolean tryParseInt(String value) {  
        try {  
            Integer.parseInt(value);  
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
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
