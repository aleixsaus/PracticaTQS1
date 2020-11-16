public class Main {

	public static void main(String[] args) {
		
		Mastermind mastermind = new Mastermind();
        Player player = new Player();
				
        while (!mastermind.hasFinished()) {
            String response = player.enterCode();
            
            while(response == null) {
            	response = player.enterCode();
            }
            mastermind.enterCode(response);
        }
        System.out.println("EXIT");
	}
}