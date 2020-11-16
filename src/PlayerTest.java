import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	
	@Test
	public void checkEnteredCodeTest() {
		
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
	
	@Test
	public void checkDifficultTest() {
		
		//Correct difficult entered to test.
		int enteredDifficult = 4;	
		//Save what we get from the method.
		int realDifficult = player.checkDifficult(enteredDifficult);	
		//We check that the entered difficult is correct.
		assertEquals(enteredDifficult, realDifficult);
		
		//Wrong difficult entered to test.
		enteredDifficult = -1;
		//Save what we get from the method.
		realDifficult = player.checkDifficult(enteredDifficult);
		//We check that the entered difficult is wrong.
		assertEquals(0, realDifficult);
				
		//Wrong difficult with bigger number entered to test.
		//Inner limit test 
		enteredDifficult = 9;
		//Save what we get from the method.
		realDifficult = player.checkDifficult(enteredDifficult);
		//We check that the entered difficult is wrong.
		assertEquals(0, realDifficult);
		
		//Wrong difficult with smaller number entered to test.
		//Outer limit test
		enteredDifficult = 0;
		//Save what we get from the method.
		realDifficult = player.checkDifficult(enteredDifficult);
		//We check that the entered difficult is wrong.
		assertEquals(0, realDifficult);
		
		//Correct difficult with minimum possible value
		enteredDifficult = 1;
		//Save what we get from the method.
		realDifficult = player.checkDifficult(enteredDifficult);
		//We check that the entered difficult is wrong.
		assertEquals(enteredDifficult, realDifficult);
		
		//Correct difficult with maximum possible value
		enteredDifficult = 8;
		//Save what we get from the method.
		realDifficult = player.checkDifficult(enteredDifficult);
		//We check that the entered difficult is wrong.
		assertEquals(enteredDifficult, realDifficult);
	}
	
	@Test
	public void tryParseIntTest() {
		
		//String number to test.
		String enteredNumber = "123";	
		//Save what we get from the method.
		boolean passCheck = player.tryParseInt(enteredNumber);		
		//We check that the entered string is correct.
		assertTrue(passCheck);
		
		//String number to test.
		enteredNumber = "asd";	
		//Save what we get from the method.
		passCheck = player.tryParseInt(enteredNumber);		
		//We check that the entered string is NOT correct.
		assertFalse(passCheck);
			
		//String number to test.
		enteredNumber = null;	
		//Save what we get from the method.
		passCheck = player.tryParseInt(enteredNumber);		
		//We check that the entered string is null.
		assertFalse(passCheck);	
	}
}
