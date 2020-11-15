import java.util.ArrayList;

public class GameBoard {

	private ArrayList<Code> codeRecords;
	private ArrayList<Clue> clueRecords;
	
	private String gameBoardDesign;
	
	public GameBoard() {
		codeRecords = new ArrayList<Code>();
		clueRecords = new ArrayList<Clue>();
	}

	//GETTER
	public ArrayList<Code> getCodeRecords() {
		return this.codeRecords;
	}
	
	//SETTER
	public void addCodeRecord(Code code) {
		this.codeRecords.add(code);
	}
	
	//GETTER
	public ArrayList<Clue> getClueRecords() {
		return this.clueRecords;
	}
	
	//SETTER
	public void addClueRecord(Clue clue) {
		this.clueRecords.add(clue);
	}
	
	//GETTER
	public String getGameBoardDesign() {
		return gameBoardDesign;
	}

	//SETTER
	public void setGameBoardDesign(String gameBoardDesign) {
		this.gameBoardDesign = gameBoardDesign;
	}
	
	//Create the board and add the codes and clues to the document if needed
	public void designGameBoard() {
		String gameBoardDesign = "";
		
		gameBoardDesign += "+-------------------+\n";
		gameBoardDesign += "| Attempts | Clues  |\n";
		gameBoardDesign += "+-------------------+\n";
		
		for (int i = 0; i < Mastermind.MAX_ATTEMPTS; i++) {
			if (this.codeRecords.size() > i) {
				gameBoardDesign += "| ";
				for (String codiChar : codeRecords.get(i).getCode().split("")) {
					gameBoardDesign += codiChar + " ";
				}
				gameBoardDesign += ": ";
				for (String pistaChar : clueRecords.get(i).getClue().split("")) {
					gameBoardDesign += pistaChar + " ";
				}
				gameBoardDesign += "|\n";
			} else {
				gameBoardDesign += "| - - - - : - - - - |\n";
			}
		}

		gameBoardDesign += "+-------------------+\n";
		
		setGameBoardDesign(gameBoardDesign);
	}
}
