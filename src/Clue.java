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
		return new Clue(clue);
	}
}
