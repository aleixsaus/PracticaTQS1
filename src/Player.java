import java.util.Map.Entry;
import java.util.Scanner;

public class Player {

    public String insertCode() {
    		System.out.println("Colors:");
    		
    		for (Entry<Character, String> color : Mastermind.COLORS.entrySet()) {
    		    Character colorCode = color.getKey();
    		    String colorValue = color.getValue();
    		    
    		    System.out.println(" " + colorCode + ": " + colorValue);
    		}
    		
    		System.out.println("What is the secret code?");
    		
    		try (Scanner scanner = new Scanner(System.in)) {
				String code = scanner.nextLine().toUpperCase();
				
				return code;
			}
    }
}
