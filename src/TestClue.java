import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClue {

	private Clue clue;
	
	@BeforeEach
	void setUp() throws Exception {

	}
	
	@Test
	void testCreateClue() {
		//Clue we expect from calling this method
		String expectedClue = "xo--";
		
		//Save what we get from the method
		Clue returnedClue = new Clue(expectedClue);
		//Check clue
		assertEquals(expectedClue, returnedClue.getClue());
	}

}
