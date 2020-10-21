
import org.junit.Assert;

import org.junit.Test;

public class PlayerTest {

	public static final int CODE_LENGTH = 4;
	
	@Test
	public void checkPlayerCode() {	
		Player player = new Player(); 	
		String playerCode = player.insertCode();
		
		String testingCode = "ABCD";

		// Player code its equals working code
		Assert.assertEquals(playerCode, testingCode);
		
		// Player code length is correct
		Assert.assertTrue(playerCode.length() == CODE_LENGTH);
		
		// Player code is not null
		Assert.assertNotNull(playerCode);	
	}
}
