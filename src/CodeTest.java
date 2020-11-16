import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CodeTest {
		
	@Test
	public void testGetCode() {
		//Statement Coverage - White box
		//Code we expect from calling this method
		String expectedCode = "ABCD";
		
		//Save what we get from the method
		Code returnedCode = new Code(expectedCode);
		
		//Check clue
		assertEquals(expectedCode, returnedCode.getCode());
	}
}
