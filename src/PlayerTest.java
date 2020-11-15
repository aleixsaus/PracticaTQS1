import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	public static final int CODE_LENGTH = 4;
		
	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player();
	}
	
	// 
	//@Test
	//public void checkPlayerCode() {	
	//	String playerCode = player.insertCode();
	//	
	//	String testingCode = "ABCD";
	//
	//	// Player code its equals working code
	//	assertEquals(playerCode, testingCode);
	//	
	//	// Player code length is correct
	//	assertTrue(playerCode.length() == CODE_LENGTH);
	//
	//	// Player code is not null
	//	assertNotNull(playerCode);	
	//}
	
	@Test
	public void checkEnteredCode() {
		
		//Correct code entered to test.
		String enteredCode = "PRBV";	
		//Save what we get from the method.
		boolean passCheck = player.checkEnteredCode(enteredCode);	
		//We check that the entered code is correct.
		assertTrue(passCheck);
		
		//Wrong code entered to test.
		enteredCode = "1234";
		//Save what we get from the method.
		passCheck = player.checkEnteredCode(enteredCode);
		//We check that the entered code is wrong.
		assertFalse(passCheck);
		
		//Null code entered to test.
		enteredCode = null;
		//Save what we get from the method.
		passCheck = player.checkEnteredCode(enteredCode);
		//We check that the entered code is wrong.
		assertFalse(passCheck);
		
		//Wrong code with wrong length entered to test.
		//Inner limit test 
		enteredCode = "123";
		//Save what we get from the method.
		passCheck = player.checkEnteredCode(enteredCode);
		//We check that the entered code is wrong.
		assertFalse(passCheck);
		
		//Wrong code with wrong length entered to test.
		//Outer limit test
		enteredCode = "12345";
		//Save what we get from the method.
		passCheck = player.checkEnteredCode(enteredCode);
		//We check that the entered code is wrong.
		assertFalse(passCheck);
	}
}
