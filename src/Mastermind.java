import java.util.HashMap;

public class Mastermind {

	static final int LENGTH_CODE = 4;
	
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
	
	public Mastermind() {
		
	}
	
	public boolean checkCode(String secretCode, String playerCode) {
		return secretCode.equals(playerCode);
	}
	
	public String generateCode() {
		return "ABCD";
	}
}
