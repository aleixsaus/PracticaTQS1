import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class MockSecretCode implements InterfaceSecretCode {

	private String secretCode;

	public boolean checkSecretCode(String code) {
		if(this.secretCode.equals(code)) {
			System.out.println("The Secret Code was: " + this.secretCode);
		}
		return this.secretCode.equals(code);
	}
	
	public void setSecretCode(String code){
		this.secretCode = code;
	}
	
	public String getSecretCode() {
		return this.secretCode;
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

}
