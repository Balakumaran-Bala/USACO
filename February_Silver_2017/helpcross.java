package February_Silver_2017;
import java.util.*;
import java.io.*;

public class helpcross {

	public static class Pair implements Comparable<Pair> {
		int time;
		int id;
		int end;
		
		public Pair(int s, int i, int e) {
			time = s;
			id = i;
			end = e;
		}
		
		public int compareTo(Pair o) {
			if (this.time == o.time)
				return o.id - this.id;
			
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int C = Integer.parseInt(st.nextToken());
	    int N = Integer.parseInt(st.nextToken());
	    
	    Pair[] cows = new Pair[2*N + C];
	    
	    for (int i = 0; i < C; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		int time = Integer.parseInt(st.nextToken());
	    		Pair p = new Pair(time, 0, 0);
	    		cows[i] = p;
	    }
	    
	    for (int i = 0; i < N; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		int s = Integer.parseInt(st.nextToken());
	    		int e = Integer.parseInt(st.nextToken());
	    		Pair p1 = new Pair(s, i+1, e);
	    		Pair p2 = new Pair(e, -(i+1), 0);
	    		cows[C + 2*i] = p1;
	    		cows[C + 2*i + 1] = p2;
	    }
	    
	    Arrays.sort(cows);
	    
	    PriorityQueue<Pair> curr = new PriorityQueue<Pair>(new Comparator<Pair>() {
	    		public int compare(Pair p1, Pair p2) {
	    			return p1.end - p2.end;
	    		}
	    });
	    
	    int numPairs = 0;
	    for (int i = 0; i < cows.length; i++) {
	    		if (cows[i].id > 0) {
	    			curr.add(cows[i]);
	    		} else if (cows[i].id == 0) {    			
	    			if (!curr.isEmpty()) {
	    				numPairs++;
	    				curr.poll();
	    			}
	    			
	    		} else if (cows[i].id < 0) {
	    			for (Pair p : curr) {
	    				if (p.id == -cows[i].id) {
	    					curr.remove(p);
	    					break;
	    				}	
	    			}
	    		}
	    }
	    
	    out.println(numPairs);
	    out.close();
	}

}
