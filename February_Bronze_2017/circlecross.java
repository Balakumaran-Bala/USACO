package February_Bronze_2017;
import java.util.*;
import java.io.*;
///Users/Bala/eclipse-workspace/USACO/src/test.in
public class circlecross {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("circlecross.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    String crossings = st.nextToken();
	    
	    int count = 0;
	    for (int i = 0; i < 26; i++) {
	    		for (int j = 0; j < 26; j++) {
	    			if (i != j) {
	    				int[] id = new int[4];
	    				int indexI = 0;
	    				int indexJ = 1;
	    				for (int k = 0; k < crossings.length(); k++) {
	    					if (crossings.charAt(k) == 'A' + i) {
	    						id[indexI] = k;
	    						indexI += 2;
	    					} else if (crossings.charAt(k) == 'A' + j) {
	    						id[indexJ] = k;
	    						indexJ += 2;
	    					}
	    				}
	    				
	    				if (id[0] < id[1] && id[2] > id[1] && id[1] < id[2] && id[3] > id[2]) {
	    					count++;
	    				} 
	    			}
	    		}
	    }
	    out.println(count);
	    out.close();
	}

}
