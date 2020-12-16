import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;

public class MastermindTest2 {

	private Mastermind mastermind;
	private MockSecretCode mockSecretCode;
	private MockPlayer mockPlayer;
	private MockUser mockUser;
	private MockClue mockClue;
	private Clue clue;
	
	@Test
	public void testGuanyarPartida() throws IOException {
		mastermind = new Mastermind();
		mockSecretCode = new MockSecretCode();
		mockPlayer = new MockPlayer();
		mockUser = new MockUser();
		
		mockSecretCode.setSecretCode("BWBW");
		mastermind.setSecretCode(mockSecretCode);
		String cadena[] = mockUser.getValues("guanyar.txt");
		for(int i  = 0 ; i < cadena.length; i ++) {
			mockPlayer.addPlayerPlay(cadena[i]);
		}
		
		mastermind.setPlayer(mockPlayer);
		mastermind.playerPlaysGame();
		assertTrue(mastermind.hasWinned());
	}
	
	@Test
	public void testPerdrePartida() throws IOException {
		mastermind = new Mastermind();
		mockSecretCode = new MockSecretCode();
		mockPlayer = new MockPlayer();
		mockUser = new MockUser();
		
		mockSecretCode.setSecretCode("OOOO");
		mastermind.setSecretCode(mockSecretCode);
		String cadena[] = mockUser.getValues("perdre.txt");
		for(int i  = 0 ; i < cadena.length; i ++) {
			mockPlayer.addPlayerPlay(cadena[i]);
		}

		mastermind.setPlayer(mockPlayer);
		mastermind.playerPlaysGame();
		assertTrue(!mastermind.hasWinned());
	}
	
	@Test 
	public void mirarResultatCorrectes() throws IOException {
		mastermind = new Mastermind();
		mockSecretCode = new MockSecretCode();
		mockPlayer = new MockPlayer();
		mockUser = new MockUser();
				
		String list[] = {"RBBB", "RPPP","BWBW"};
		String list2[] = {"RBBB", "PRBW","YOOY"};
		String cadena[] = mockUser.getValues("clue.txt");
		for(int i = 0; i  < cadena.length; i ++) {
			Code code = new Code(list[i]);	
			SecretCode secretCode = new SecretCode(list2[i]);
			
		clue = Clue.createClue(code, secretCode.getSecretCode());	
		System.out.println("Valor de l'usuari: " + cadena[i]+ " Valor de codi solucio: "+ clue.getClue());
		assertEquals(clue.getClue(), cadena[i]);	
		}
	
	}
		

	
	
	
	
	
	
	
	
}
