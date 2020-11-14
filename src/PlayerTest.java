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
	
	@Test
	public void checkPlayerCode() {	
		String playerCode = player.insertCode();
		
		String testingCode = "ABCD";

		// Player code its equals working code
		assertEquals(playerCode, testingCode);
		
		// Player code length is correct
		assertTrue(playerCode.length() == CODE_LENGTH);
	
		// Player code is not null
		assertNotNull(playerCode);	
	}
}
