package December_Bronze_2017;
import java.util.*;
import java.io.*;
///Users/Bala/eclipse-workspace/USACO/src/test.in
public class measurement {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    
		int[] cows = new int[3];
		int[] milkOutput = new int[101];
		String[] corrCows = new String[101];
	    for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(f.readLine());
	    		int day = Integer.parseInt(st.nextToken());
	    		String cow = st.nextToken();
	    		int milk = Integer.parseInt(st.nextToken());
	    		milkOutput[day] = milk;
	    		corrCows[day] = cow;
	    }
	    
	    String max = "Bessie Elsie Mildred";
	    String currentMax = "Bessie Elsie Mildred";
	    int numDisplays = 0;
	    for (int i = 0; i < 100; i++) {
	    		if (corrCows[i] != null) {
	    			if (corrCows[i].equals("Bessie")) {
	    				cows[0] += milkOutput[i];
	    			} else if (corrCows[i].equals("Elsie") ) {
	    				cows[1] += milkOutput[i];
	    			} else if (corrCows[i].equals("Mildred")) {
	    				cows[2] += milkOutput[i];
	    			}
	    			
	    			if (cows[0] == cows[1] && cows[0] == cows[2]) {
	    				currentMax = "Bessie Elsie Mildred";
	    			} else if (cows[0] == cows[1] && cows[0] > cows[2]) {
	    				currentMax = "Bessie Elsie";
	    			} else if (cows[0] == cows[2] && cows[0] > cows[1]) {
	    				currentMax = "Bessie Mildred";
	    			} else if (cows[1] == cows[2] && cows[1] > cows[0]) {
	    				currentMax = "Elsie Mildred";
	    			} else if (cows[0] > cows[1] && cows[0] > cows[2]) {
	    				currentMax = "Bessie";
	    			} else if (cows[1] > cows[0] && cows[1] > cows[2]) {
	    				currentMax = "Elsie";
	    			} else if (cows[2] > cows[1] && cows[2] > cows[0]) {
	    				currentMax = "Mildred";
	    			}
	    			
	    			if (!currentMax.equals(max)) {
	    				numDisplays++;
	    				max = currentMax;
	    			}
	    		}
	    }
	    
	    out.println(numDisplays);
		out.close();
	}

}
