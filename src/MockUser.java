import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MockUser extends MockPlayer{

	public String[] getValues(String file) throws IOException {
	
		 BufferedReader br = new BufferedReader(new FileReader(file));
		    String line = null;
		    String[] values = null;
		    while ((line = br.readLine()) != null) {
		     values = line.split(";");
		      for (String str : values) {
		        System.out.println(str);
		      }
		    }
		    br.close();
		    return values;
		  }
}
