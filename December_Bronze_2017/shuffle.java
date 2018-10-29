package December_Bronze_2017;
import java.util.*;
import java.io.*;
///Users/Bala/eclipse-workspace/USACO/src/test.in
public class shuffle {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("/Users/Bala/eclipse-workspace/USACO/src/test.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/Bala/eclipse-workspace/USACO/src/test.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    
		st = new StringTokenizer(f.readLine());
	    int[] shuff = new int[n];
	    for (int i = 0; i < n; i++) {
	    		shuff[i] = Integer.parseInt(st.nextToken());
	    }
	    
		st = new StringTokenizer(f.readLine());
	    int[] ids = new int[n];
	    for (int i = 0; i < n; i++) {
    			ids[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[] backShuff = new int[n];
	    for (int i = 0; i < n; i++) {
	    		backShuff[shuff[shuff[i] - 1] - 1] = shuff[i];
	    }
	    
	    int[] back1 = new int[n];
	    for (int i = 0; i < n; i++) {
	    		back1[backShuff[i] - 1] = ids[i];
	    }
	    
	    int[] back2 = new int[n];
	    for (int i = 0; i < n; i++) {
    			back2[backShuff[i] - 1] = back1[i];
	    }
	    
	    int[] original = new int[n];
	    for (int i = 0; i < n; i++) {
			original[backShuff[i] - 1] = back2[i];
	    }
	    
	    for (int i = 0; i < n; i++) {
	    		out.println(original[i]);
	    }
	    
	    out.close();
	}

}
