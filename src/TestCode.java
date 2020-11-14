import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestCode {
	
	private Code code;

	@Before
	public void setUp() throws Exception {
		code = new Code();
	}
	
	@Test
	public void testCreateCode() {
		//Code we should get
		String expectedCode = "ABCD";
		
		//Save what we get from the method
		String returnedCode = code.createCode();
		
		//Check code
		assertEquals(expectedCode, returnedCode);
	}
	
	@Test
	public void testGetCode() {
		//Code we expect from calling this method
		String expectedCode = "ABCD";
		
		//Save what we get from the method
		Code returnedCode = new Code(expectedCode);
		
		//Check clue
		assertEquals(expectedCode, returnedCode.getCode());
	}
}
