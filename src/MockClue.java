import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MockClue  {

	String[] clue;
	
	public String[] getClue() {
		return clue;
	}

	public void setClue(String clue, int pos) {
		this.clue[pos] = clue;
	}

	public MockClue() {
		
	}
	

	@SuppressWarnings("null")
	public void getValues(String file) throws IOException {
		
		 BufferedReader br = new BufferedReader(new FileReader(file));
		    String line = null;
		    
		    while ((line = br.readLine()) != null) {
		    	clue = line.split(";");
		      for (String str : clue) {
		       // System.out.println(str);
		      }
		    }
		    br.close();
		   
		  }
}
