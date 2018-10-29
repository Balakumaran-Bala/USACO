package December_Silver_2016;
import java.util.*;
import java.io.*;

public class citystate {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());

	    int n = Integer.parseInt(st.nextToken());
	    
	    HashMap<String, ArrayList<String>> cs = new HashMap<String, ArrayList<String>>();
	    
	    
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		String city = st.nextToken();
	    		String state = st.nextToken();
	    		
	    		String shortened = city.substring(0, 2);
	    		
	    		
	    }
	    
	    
	    
	}

}
