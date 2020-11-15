public class main {

	public static void main(String[] args) {
		
		Mastermind mastermind = new Mastermind();
        Player player = new Player();
		
		mastermind.printInstructions();
		
        while (!mastermind.hasFinished()) {
            String response = player.insertCode();
            while(response == null) {
            	response = player.insertCode();
            }
            mastermind.enterCode(response);
        }
        System.out.println("EXIT");
	}
}