public interface InterfaceSecretCode {
		
	boolean checkCode(String code);
	String createRandomCode();
	Clue createClue(Code code);
	String orderClue(String disorderClue);

}