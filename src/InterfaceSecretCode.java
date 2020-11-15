public interface InterfaceSecretCode {
	//We will use it for secret code mock object because 
	//it have functions that generates random numbers.
	boolean checkCode(String code);
	String createRandomCode();
}