import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MastermindTest {
	private Mastermind mastermind;
	
	@Before
	public void setUp() throws Exception {
		mastermind = new Mastermind();
	}

	@Test
	public void generateCodeTest() {
		String code1 = "ABCD";
		String code2 = this.mastermind.generateCode();
		
		assertEquals(code1, code2);
	}
	
	@Test
	public void checkCodeTest() {
		
		String code1 = "ABCD";
		String code2 = "DCBA";
		String code3 = "ABCD";
		
		boolean checkCode1 = mastermind.checkCode(code1, code2);
		assertFalse(checkCode1);
		
		boolean comprovarCodi2 = mastermind.checkCode(code1, code3);
		assertTrue(comprovarCodi2);	
	}
}
