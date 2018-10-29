package January_Silver_2017;
import java.util.*;
import java.io.*;

public class cowdance {

	public static void main(String[] args) throws IOException {	    
	    BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int T = Integer.parseInt(st.nextToken());
	    
	    int[] cows = new int[N];
	    for (int i = 0; i < N; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		cows[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	    int left = 0;
	    int right = N;
	    int k = 0;
	    while (left < right) {
	    		k = left + (right - left) / 2;
	    		
	    		int index = 0;
	    		while (index < k) {
	    			pq.add(cows[index]);
	    			index++;
	    		}
	    		
	    		boolean possible = true;
	    		while (index < N) {
	    			int done = pq.poll();
	    			if (done > T)
	    				possible = false;
	    			pq.add(cows[index] + done);
	    			index++;
	    		}
	    		
	    		while (!pq.isEmpty()) {
	    			if (pq.poll() > T)
	    				possible = false;
	    		}
	    		
	    		if (possible) {
	    			right = k;
	    		} else {
	    			left = k + 1;
	    		}
	    }
	    
	    out.println(left);
	    out.close();
	}

}
