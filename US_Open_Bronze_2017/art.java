package US_Open_Bronze_2017;
import java.util.*;
import java.io.*;
///Users/Bala/eclipse-workspace/USACO/src/test.in
public class art {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("art.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    
	    int[][] canvas = new int[n][n];
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		String line = st.nextToken();
    			String[] colors = line.split("");
    			for (int j = 0; j < n; j++) {
    				canvas[i][j] = Integer.parseInt(colors[j]);
    			}
	    }
	    
	    int[] first = new int[10];
	    
	    for (int k = 1; k < 10; k++) {
	    		for (int i = 0; i < n; i++) {
	    			for (int j = 0; j < n; j++) {
	    				if (canvas[i][j] == k)
	    					first[canvas[i][j]] = 1;
	    			}
	    		}
	    }
	    
	    for (int k = 1; k < 10; k++) {
	    		int minX = n, minY = n, maxX = 0, maxY = 0;
		    for (int i = 0; i < n; i++) {
		    		for (int j = 0; j < n; j++) {
		    			if (canvas[i][j] == k) {
		    				if (j < minX)
		    					minX = j;
		    				if (j > maxX)
		    					maxX = j;
		    				if (i < minY)
		    					minY = i;
		    				if (i > maxY)
		    					maxY = i;
		    			}
		    		}
		    }
		    
		    for (int i = minY; i < maxY + 1; i++) {
		    		for (int j = minX; j < maxX + 1; j++) {
		    			if (canvas[i][j] != k) {
		    				first[canvas[i][j]]++;
		    			}
		    		}
		    }
		    
	    }
	    
	    int count = 0;
	    for (int i = 0; i < first.length; i++) {
	    		if (first[i] == 1)
	    			count++;
	    }
	    
	    out.println(count);
	    out.close();
	}

}
