import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCheckCode {

	private Mastermind mastermind;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	
	@Test
	void testCheckCode() {
		//What we should expect from calling this method
		String expectedCode = "ABCD";
		
		//Save what we get from the method
		Code returnedCode = new Code(expectedCode);
		//Check code
		assertEquals(expectedCode, returnedCode.getCode());
	}

}
