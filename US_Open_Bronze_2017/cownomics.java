package US_Open_Bronze_2017;
import java.util.*;
import java.io.*;

public class cownomics {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    String[][] genome = new String[2*n][m];
	    
	    for (int i = 0; i < 2*n; i++) {
    			st = new StringTokenizer(f.readLine());
    			String sequence = st.nextToken();
    			String[] letters = sequence.split("");
    			
    			for (int k = 0; k < m; k++) {
    				genome[i][k] = letters[k];
    			}
    			
	    }
	    
	    int count = 0;
	    boolean common;
	    for (int i = 0; i < m; i++) {
	    		common = false;
	    		for (int j = 0; j < n; j++) {
	    			for (int k = n; k < 2*n; k++) {
	    				if (genome[j][i].equals(genome[k][i])) {
	    					common = true;
	    				}
	    			}
	    			if (common) {
	    				count++;
	    				break;
	    			}
	    		}	    		
	    }
	    
	    out.println(m - count);
	    out.close();
	}

}
