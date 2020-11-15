public class Code {
	
	private String code;
	
	//Empty Constructor for Code
	public Code() {
		
	}
	
	//Constructor to create Code
	public Code(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public String createCode() {
		return "ABCD";
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
