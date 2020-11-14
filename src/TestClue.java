import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCreateClue {

	private Clue clue;
	
	@BeforeEach
	void setUp() throws Exception {
		clue = new Clue();
	}
	
	@Test
	void test() {
		//"Green Red Yellow Blue"
		String expectedClue = "ABCD";
		
		String returnedClue = clue.createClue();
		assertEquals(expectedClue, returnedClue);
	}

}
