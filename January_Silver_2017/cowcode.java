package January_Silver_2017;

import java.util.*;
import java.io.*;

public class cowcode {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());

	    String code = st.nextToken();
	    
	    long n = Long.parseLong(st.nextToken());
	    
	    long length = code.length();
	    while (n > code.length()) {
	    		long i = length;
	    		while (i < n) {
	    			i *= 2;
	    		}
	    		
	    		i /= 2;
	    		
	    		if (i + 1 == n) {
	    			n--;
	    		} else {
	    			n -= i + 1;
	    		}
	    }
	    
	    int character = (int) n;
	    out.println(code.charAt(character-1));
	    out.close();
	}

}
