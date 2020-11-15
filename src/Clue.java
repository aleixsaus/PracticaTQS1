import java.util.Arrays;

public class Clue {

	private String clue;
	
	//Empty Constructor for Clue
	public Clue() {
		
	}
	
	//Constructor to create Clue
	public Clue(String clue) { 
		this.clue = clue;
	}
	
	public String getClue() {
		return clue;
	}
	
	public static Clue createClue(Code code, SecretCode secretCode) {

		String clue = "";

		for (int i = 0; i < Mastermind.LENGTH_CODE; i++) {
			if (code.getCode().split("")[i].equals(secretCode.getSecretCode().split("")[i])) {
				clue += "x";
			} else {
				boolean isThere = false;
				for (int j = 0; j < Mastermind.LENGTH_CODE; j++) {
					if (isThere = code.getCode().split("")[i].equals(secretCode.getSecretCode().split("")[j])) {
						clue += "o";
						break;
					}
				}
				if (!isThere) {
					clue += "-";
				}
			}
		}
		
		clue = sortClue(clue);
		
		return new Clue(clue);
	}
	
	public static String sortClue(String unsortedClue) {
		char clueChars[] = unsortedClue.toCharArray();
		
		Arrays.sort(clueChars);
		String sortedClue = "";
		
		if(clueChars.length < Mastermind.LENGTH_CODE || clueChars.length > Mastermind.LENGTH_CODE) {		
			return null;
		} else {
			for (int i = 1; i < clueChars.length + 1; i++) {
				sortedClue += clueChars[clueChars.length - i];
			}
			return sortedClue;
		}
	}
}
