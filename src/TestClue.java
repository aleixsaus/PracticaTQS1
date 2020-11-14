import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestClue {
	
	private Clue clue;

	@Before
	public void setUp() throws Exception {
		clue = new Clue();
	}
	
	@Test
	public void testGetClue() {
		//Clue we expect from calling this method
		String expectedClue = "xo--";
		
		//Save what we get from the method
		Clue returnedClue = new Clue(expectedClue);
		
		//Check clue
		assertEquals(expectedClue, returnedClue.getClue());
	}
	
	@Test
	public void testCreateClue() {
		Code code = new Code("ABCD");
		SecretCode secretCode = new SecretCode("BBBB");
				
		String expectedClue = "-x--";
		clue = clue.createClue(code, secretCode);
		
		assertEquals(clue.getClue(), expectedClue);
		
		
		code = new Code("ABCD");
		secretCode = new SecretCode("ABCD");
				
		expectedClue = "xxxx";
		clue = clue.createClue(code, secretCode);
		
		assertEquals(clue.getClue(), expectedClue);
		
		
		code = new Code("ABCD");
		secretCode = new SecretCode("DCBA");
				
		expectedClue = "oooo";
		clue = clue.createClue(code, secretCode);
		
		assertEquals(clue.getClue(), expectedClue);
		
		
		code = new Code("ABCD");
		secretCode = new SecretCode("QQQQ");
				
		expectedClue = "----";
		clue = clue.createClue(code, secretCode);
		
		assertEquals(clue.getClue(), expectedClue);
	}
	
}
