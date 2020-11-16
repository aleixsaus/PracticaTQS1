import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ClueTest {
	
	private Clue clue;
	
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
		//We create a secret code directly, we will need a mockObject.
		
		//We create a code and a secret code to test.
		Code code = new Code("RBBB");	
		SecretCode secretCode = new SecretCode("RPPP");		
		//We set the expected clue returned.
		String expectedClue = "x---";	
		//We get the result clue of the function.
		clue = Clue.createClue(code, secretCode.getSecretCode());	
		//Check clue
		assertEquals(clue.getClue(), expectedClue);	
		
		//We create a code and a secret code to test.
		code = new Code("RBBB");	
		secretCode = new SecretCode("PPRP");		
		//We set the expected clue returned.
		expectedClue = "o---";
		//We get the result clue of the function.
		clue = Clue.createClue(code, secretCode.getSecretCode());		
		//Check clue.
		assertEquals(clue.getClue(), expectedClue);		
		
		//We create a code and a secret code to test.
		code = new Code("RBRB");	
		secretCode = new SecretCode("RBRB");		
		//We set the expected clue returned.	
		expectedClue = "xxxx";	
		//We get the result clue of the function.
		clue = Clue.createClue(code, secretCode.getSecretCode());		
		//Check clue
		assertEquals(clue.getClue(), expectedClue);
		
		//We create a code and a secret code to test.
		code = new Code("RBRB");
		secretCode = new SecretCode("BRBR");
		//We set the expected clue returned.			
		expectedClue = "oooo";
		//We get the result clue of the function.
		clue = Clue.createClue(code, secretCode.getSecretCode());
		//Check clue	
		assertEquals(clue.getClue(), expectedClue);
		
		//We create a code and a secret code to test.
		code = new Code("RBRB");
		secretCode = new SecretCode("PPPP");
		//We set the expected clue returned.					
		expectedClue = "----";
		//We get the result clue of the function.
		clue = Clue.createClue(code, secretCode.getSecretCode());	
		//Check clue
		assertEquals(clue.getClue(), expectedClue);
	}
	
	@Test
	public void sortClueTest() {
		//Condition coverage.
		
		//Unsorted clue.
		String unsortedClue = "-oxo";
		//Expected sorted clue.
		String sortedClue = "xoo-";
		//We execute the sort function and we store the result.
		String resultClue = Clue.sortClue(unsortedClue);	
		//We check that the expected result matches.
		assertEquals(sortedClue, resultClue);
		
		//Unsorted clue.
		unsortedClue = "----";
		//Expected sorted clue.
		sortedClue = "----";
		//We execute the sort function and we store the result.
		resultClue = Clue.sortClue(unsortedClue);	
		//We check that the expected result matches.
		assertEquals(sortedClue, resultClue);
		
		//Unsorted clue.
		unsortedClue = "---x";
		//Expected sorted clue.
		sortedClue = "x---";
		//We execute the sort function and we store the result.
		resultClue = Clue.sortClue(unsortedClue);	
		//We check that the expected result matches.
		assertEquals(sortedClue, resultClue);		
		
		//Unsorted clue.
		unsortedClue = "xoxo";
		//Expected sorted clue.
		sortedClue = "xxoo";
		//We execute the sort function and we store the result.
		resultClue = Clue.sortClue(unsortedClue);	
		//We check that the expected result matches.
		assertEquals(sortedClue, resultClue);		
		
		//Unsorted clue.
		unsortedClue = "-xo-";
		//Expected sorted clue.
		sortedClue = "xo--";
		//We execute the sort function and we store the result.
		resultClue = Clue.sortClue(unsortedClue);	
		//We check that the expected result matches.
		assertEquals(sortedClue, resultClue);
	
		//Condition coverage - Limit values. 
		
		//Clue longer than max length.
		unsortedClue = "-xo--";
		//We execute the sort function and we store the result.
		resultClue = Clue.sortClue(unsortedClue);	
		//We check that it returns the expected null value.
		assertNull(resultClue);
		
		//Clue longer than max length.
		unsortedClue = "-xo";
		//We execute the sort function and we store the result.
		resultClue = Clue.sortClue(unsortedClue);	
		//We check that it returns the expected null value.
		assertNull(resultClue);
	}
}
