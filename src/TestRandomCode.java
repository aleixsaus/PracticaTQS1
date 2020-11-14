import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRandomCode {
	
	private Code code;

	@BeforeEach
	void setUp() throws Exception {
		code = new Code();
	}
	
	@Test
	void testRandomCode() {
		//"Code we should get"
		String expectedCode = "ABCD";
		
		String returnedCode = code.createCode();
		//"Check code"
		assertEquals(expectedCode, returnedCode);
	}

}
