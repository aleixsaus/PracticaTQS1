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
	public void testCreateClue() {
		//Clue we expect from calling this method
		String expectedClue = "xo--";
		
		//Save what we get from the method
		Clue returnedClue = new Clue(expectedClue);
		
		//Check clue
		assertEquals(expectedClue, returnedClue.getClue());
	}

}
