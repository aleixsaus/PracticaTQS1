import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecretCode {

	private final String secretcode;
	
	public SecretCode(String secretCode) {
		secretcode = secretCode;
	}
	
	public SecretCode() {
		secretcode = createRandomCode();
	}
	
	public String getSecretCode() { 
		return secretcode;
	}
	
	//Creates a random secret code.
	public String createRandomCode() { 
        
		String randomCode = "";
        Random random = new Random();
        List<Character> keys = new ArrayList<Character>(Mastermind.COLORS.keySet());
		
        for (int i = 0; i < Mastermind.LENGTH_CODE; i++) { 
        	randomCode += keys.get(random.nextInt(keys.size()));
        } 
        
        return randomCode; 
    }
	
	//Checks if the entered code and the secret code are equals.
	public boolean checkSecretCode(String code) {	
		if(this.secretcode.equals(code)) {
			System.out.println("The Secret Code was: " + this.secretcode); 
		}
		return this.secretcode.equals(code);
	}
}