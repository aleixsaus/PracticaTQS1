import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SecretCodeTest {
	private SecretCode secretCode;
	private MockSecretCode mockSecretCode;

	@Before
	public void setUp() throws Exception {
		secretCode = new SecretCode();
		mockSecretCode = new MockSecretCode();
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
		
	//MOCKOBJECT
	@Test
	public void checkSecretCodeTest() {
		//We test if a secret code its equal a player code.
		//We will do it with a mockObject because random generation of secret code.
		String code = "ABCD";
		String secretCode = "ABCD";
		
		this.mockSecretCode.setSecretCode(secretCode);
		
		//We check that the code and the secret code are equals.
		boolean checkCode = this.mockSecretCode.checkSecretCode(code);
		assertTrue(checkCode);
		
		secretCode = "DCBA";
		
		this.mockSecretCode.setSecretCode(secretCode);
		
		//We check that the code and the secret code are not equals.
		checkCode = this.mockSecretCode.checkSecretCode(code);
		assertFalse(checkCode);	
	}
}
