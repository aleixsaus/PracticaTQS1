import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MastermindTest {
	private Mastermind mastermind;
	private GameBoard gameBoard;

	
	@Before
	public void setUp() throws Exception {
		mastermind = new Mastermind();
		gameBoard = new GameBoard();
	}

	@Test
	public void generateCodeTest() {
		String code1 = "ABCD";
		String code2 = this.mastermind.generateCode();
		
		assertEquals(code1, code2);
	}
	
	@Test
	public void addCodeGameBoardTest() {
		String code1 = "ABCD";
		String code2 = "DCBA";
		String code3 = "AAAA";

		mastermind.addCodeToGameBoard(code1, gameBoard);
		
		ArrayList<String> codeRecords = gameBoard.getCodeRecords();
		assertEquals(code1, codeRecords.get(0));
		
		codeRecords = new ArrayList<String>();
		
		codeRecords.add(code1);
		codeRecords.add(code2);
		codeRecords.add(code3);

		mastermind.addCodeToGameBoard(code2, gameBoard);
		mastermind.addCodeToGameBoard(code3, gameBoard);

		assertEquals(codeRecords, gameBoard.getCodeRecords());
	}
	
	@Test
	public void addClueGameBoardTest() {
		String clue1 = "xo--";
		String clue2 = "xxxx";
		String clue3 = "xoox";

		mastermind.addClueToGameBoard(clue1, gameBoard);
		
		ArrayList<String> clueRecords = gameBoard.getClueRecords();
		assertEquals(clue1, clueRecords.get(0));

		clueRecords = new ArrayList<String>();

		clueRecords.add(clue1);
		clueRecords.add(clue2);
		clueRecords.add(clue3);

		mastermind.addClueToGameBoard(clue2, gameBoard);
		mastermind.addClueToGameBoard(clue3, gameBoard);

		assertEquals(clueRecords, gameBoard.getClueRecords());		
	}
	
	@Test
	public void checkCodeTest() {
		
		String code1 = "ABCD";
		String code2 = "DCBA";
		String code3 = "ABCD";
		
		boolean checkCode1 = mastermind.checkCode(code1, code2);
		assertFalse(checkCode1);
		
		boolean comprovarCodi2 = mastermind.checkCode(code1, code3);
		assertTrue(comprovarCodi2);	
	}
}
