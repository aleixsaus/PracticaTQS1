import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SecretCodeTest {
	private SecretCode secretCode;

	@Before
	public void setUp() throws Exception {
		secretCode = new SecretCode("");
	}
	
	@Test
	public void testGetSecretCode() {
		//Code we expect from calling this method
		String expectedSecredCode = "ABCD";
		
		//Save what we get from the method
		SecretCode returnedSecredCode = new SecretCode(expectedSecredCode);
		
		//Check clue
		assertEquals(expectedSecredCode, returnedSecredCode.getSecretCode());
	}
	
	@Test
	public void checkSecretCodeTest() {
		String code = "ABCD";
		String secretCode = "ABCD";
		
		this.secretCode = new SecretCode(secretCode);
		
		boolean checkCode = this.secretCode.checkSecretCode(code);
		assertTrue(checkCode);
		
		code = "ABCD";
		secretCode = "DCBA";
		
		this.secretCode = new SecretCode(secretCode);
		
		checkCode = this.secretCode.checkSecretCode(code);
		assertFalse(checkCode);	
	}
}
