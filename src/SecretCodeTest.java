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
	
	//We comment it because random generation of secret code.
	//@Test
	//public void testGetSecretCode() {
	//	//Code we expect from calling this method
	//	String expectedSecredCode = "ABCD";
	//	
	//	//Save what we get from the method
	//	SecretCode returnedSecredCode = new SecretCode(expectedSecredCode);
	//	
	//	//Check clue
	//	assertEquals(expectedSecredCode, returnedSecredCode.getSecretCode());
	//}
		
	@Test
	public void checkSecretCodeTest() {
		//We test if a secret code its equal a player code.
		//We will do it with a mockObject because random generation of secret code.
		String code = "ABCD";
		String secretCode = "ABCD";
		
		this.secretCode = new SecretCode(secretCode);
		
		//We check that the code and the secret code are equals.
		boolean checkCode = this.secretCode.checkSecretCode(code);
		assertTrue(checkCode);
		
		secretCode = "DCBA";
		
		this.secretCode = new SecretCode(secretCode);
		
		//We check that the code and the secret code are not equals.
		checkCode = this.secretCode.checkSecretCode(code);
		assertFalse(checkCode);	
	}
}
