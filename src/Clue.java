public class Clue {

	private String clue;
	
	//Empty Constructor for Clue
	public Clue() {
		
	}
	
	//Constructor to create Clue
	public Clue(String clue) {
		this.clue = clue;
	}
	
	public String createClue() {
		return "xo--";
	}
	
	public String getClue() {
		return clue;
	}
}
