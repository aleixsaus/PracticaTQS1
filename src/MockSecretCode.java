public class MockSecretCode implements InterfaceSecretCode {

	private String secretCode;

	public boolean checkSecretCode(String code) {
		if(this.secretCode.equals(code)) {
			System.out.println("The Secret Code was: " + this.secretCode);
		}
		return this.secretCode.equals(code);
	}
	
	public void setSecretCode(String code){
		this.secretCode = code;
	}
	
	public String getSecretCode() {
		return this.secretCode;
	}

}
