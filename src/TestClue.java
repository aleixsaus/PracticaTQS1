import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClue {

	private Clue clue;
	
	@BeforeEach
	void setUp() throws Exception {
		clue = new Clue();
	}
	
	@Test
	void test() {
		//"Clue we should get"
		String expectedClue = "xo--";
		
		String returnedClue = clue.createClue();
		//"Check clue"
		assertEquals(expectedClue, returnedClue);
	}

}
