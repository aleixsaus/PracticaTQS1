import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class SecretCode implements InterfaceSecretCode{

	private final String secretcode;
	
	public SecretCode() {
		secretcode = createRandomCode();
	}
	
	public String createRandomCode() { 
        
		String randomCode = "";
        Random random = new Random();
        List<Character> keys = new ArrayList<Character>(Mastermind.COLORS.keySet());
		
        for (int i = 0; i < Mastermind.LENGTH_CODE; i++) { 
        	randomCode += keys.get(random.nextInt(keys.size()));
         } 
        return randomCode; 
    }
	
	public boolean checkCode(String code) {
		System.out.println("Secret Code: "+this.secretcode);
		if(this.secretcode.equals(code)) {
			System.out.println("The Secret Code was: "+this.secretcode);
		}
		return this.secretcode.equals(code);
	}
	
	public Clue createClue(Code code) {

		String exitClue = "";

		for (int i = 0; i < Mastermind.LENGTH_CODE; i++) {
			if (code.getCode().split("")[i].equals(this.secretcode.split("")[i])) {
				exitClue += "x";
			} else {
				boolean isThere = false;
				for (int j = 0; j < Mastermind.LENGTH_CODE; j++) {
					if (code.getCode().split("")[i].equals(this.secretcode.split("")[j])) {
						exitClue += "o";
						isThere = true;
						break;
					}
				}
				if (!isThere) {
					exitClue += "-";
				}
			}
		}
		return new Clue(orderClue(exitClue));
	}
}
