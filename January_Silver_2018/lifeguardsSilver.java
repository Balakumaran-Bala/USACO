package January_Silver_2018;
import java.io.*;
import java.util.*;

///Users/Bala/eclipse-workspace/USACO/src/test.in
public class lifeguardsSilver {
	
	public static class pair {
		long x;
		long y;
		
		pair(long a, long b) {
			x = a;
			y = b;
		}
		
	}
	
	public static class pairSorter implements Comparator<pair> {
		@Override
		public int compare(pair arg0, pair arg1) {
			if (arg0.x > arg1.x)
				return 1;
			else if (arg0.x == arg1.x)
				return 0;
			else
				return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("/Users/Bala/eclipse-workspace/USACO/src/test.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/Bala/eclipse-workspace/USACO/src/test.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    
	    pair[] cows = new pair[n];
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		long start = Integer.parseInt(st.nextToken());
	    		long end = Integer.parseInt(st.nextToken());
	    		pair cow = new pair(start, end);
	    		cows[i] = cow;
	    }
	    
	    Arrays.sort(cows, new pairSorter());
	    long end = cows[0].y;
	    long time = cows[0].y - cows[0].x;
	    for (int i = 1; i < n; i++) {
	    		if (cows[i].y <= end) {
	    			continue;
	    		} else if (cows[i].x > end) {
	    			end = cows[i].x;
	    		} 
	    		
	    		time += cows[i].y - end;
	    		end = cows[i].y;
	    }
	    
	    long min = Integer.MAX_VALUE;
	    for (int i = 1; i < n-1; i++) {
	    		long begin = cows[i].x;
	    		long finish = cows[i].y;
	    		if (begin < cows[i-1].y)
	    			begin = cows[i-1].y;
	    		if (finish > cows[i+1].x)
	    			finish = cows[i+1].x;
	    		
	    		if (finish - begin < min) {
	    			min = finish - begin;
	    		}
	    }
	    
	    if (cows[0].y > cows[1].x) {
	    		min = Math.min(min, cows[1].x - cows[0].x);
	    } else {
	    		min = Math.min(min, cows[0].y - cows[0].x);
	    }
	    	
	    if (cows[n-1].x < cows[n-2].y) {
	    		min = Math.min(min, cows[n-1].y - cows[n-2].y);
	    } else {
	    		min = Math.min(min, cows[n-1].y - cows[n-1].x);
	    }
	    
	    out.println(time - min);
	    out.close();
	}

}
