import java.util.ArrayList;

public class GameBoard {

	private ArrayList<String> codeRecords;
	private ArrayList<String> clueRecords;
	private String gameBoardDesign;
	
	public GameBoard() {
		codeRecords = new ArrayList<String>();
	}

	public ArrayList<String> getCodeRecords() {
		return this.codeRecords;
	}
	
	public void addCodeRecord(String code) {
		this.codeRecords.add(code);
	}
	
	public ArrayList<String> getClueRecords() {
		return this.clueRecords;
	}
	
	public void addClueRecord(String clue) {
		this.clueRecords.add(clue);
	}
	
	public String getGameBoardDesign() {
		return gameBoardDesign;
	}

	public void setGameBoardDesign(String gameBoardDesign) {
		this.gameBoardDesign = gameBoardDesign;
	}
	
	public void designGameBoard() {
		String gameBoardDesign = "";
		
		gameBoardDesign += "+-------------------+\n";
		gameBoardDesign += "| Attempts | Clues  |\n";
		gameBoardDesign += "+-------------------+\n";
		

		gameBoardDesign += "+-------------------+\n";
		
		setGameBoardDesign(gameBoardDesign);
	}
}
