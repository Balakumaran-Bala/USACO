package US_Open_Silver_2017;
import java.util.*;
import java.io.*;

///Users/Bala/eclipse-workspace/USACO/src/test.in
public class pairup {

	public static class pair {
		int x;
		int y;
		
		pair(int a, int b) {
			x = a;
			y = b;
		}
		
	}
	
	public static class pairSorter implements Comparator<pair> {
		public int compare(pair arg0, pair arg1) {
			if (arg0.y > arg1.y)
				return 1;
			else if (arg0.y == arg1.y)
				return 0;
			else
				return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    
	    pair[] cows = new pair[n];
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		int first = Integer.parseInt(st.nextToken());
	    		int second = Integer.parseInt(st.nextToken());
	    		pair cow = new pair(first, second);
	    		cows[i] = cow;
	    }
	    
	    Arrays.sort(cows, new pairSorter());
	    int max = 0;
	    int front = 0;
	    int end = n-1;
	    
	    while (front <= end) {
	    		if (cows[front].x == 0) {
	    			front++;
	    		} else if (cows[end].x == 0) {
	    			end--;
	    		} else {
	    			cows[front].x--;
	    			cows[end].x--;
	    			if (cows[front].y + cows[end].y > max) {
	    				max = cows[front].y + cows[end].y;
	    			}
	    		}
	    }
	    
	    out.println(max);
	    out.close();
	}

}
